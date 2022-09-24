package com.looko.simplealarmspringbootstarter.task

import com.google.gson.Gson
import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBTemplate
import com.looko.simplealarmspringbootstarter.enumeration.AlarmLevelEnum
import org.slf4j.LoggerFactory
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class EnterpriseWechatBotWebhookTask(
    private val webhookUrl: String,
    private val messageTemplate: EWBTemplate,
    override val alarmLevelEnum: AlarmLevelEnum
) :
    PrioritizedAlarmTask(alarmLevelEnum) {

    private val logger = LoggerFactory.getLogger(EnterpriseWechatBotWebhookTask::class.java)

    override fun run() {
        try {
            post(webhookUrl, Gson().toJson(messageTemplate))
        } catch (e: InterruptedException) {
            // 线程响应中断
            logger.warn("任务被中断!任务信息: {}", this)
        } catch (e: RuntimeException) {
            logger.warn("任务异常!", e)
        }
    }

    override fun toString(): String {
        return "EnterpriseWechatBotWebhookTask(alarmLevelEnum=$alarmLevelEnum), webhookUrl='$webhookUrl', messageTemplate=$messageTemplate"
    }

    private fun post(urlString: String, content: String?, contentType: String? = "application/json"): String {

        try {
            val url = URL(urlString)
            return (url.openConnection() as? HttpURLConnection)?.let { conn ->
                conn.requestMethod = "POST"
                conn.doOutput = true
                conn.doInput = true
                conn.useCaches = false
                conn.addRequestProperty("Content-Type", contentType)
                conn.connect()

                content?.let {
                    val bufferedWriter = BufferedWriter(OutputStreamWriter(conn.outputStream))
                    bufferedWriter.write(content)
                    bufferedWriter.close()
                }

                return if (conn.responseCode == HttpsURLConnection.HTTP_OK) {
                    val allBytes = conn.inputStream.readAllBytes()
                    String(allBytes)
                } else {
                    val allBytes = conn.errorStream.readAllBytes()
                    String(allBytes)
                }

            } ?: ""
        } catch (e: Exception) {
            throw RuntimeException("连接发生错误! 地址: [$urlString], 信息: ${e.message}")
        }
    }

}