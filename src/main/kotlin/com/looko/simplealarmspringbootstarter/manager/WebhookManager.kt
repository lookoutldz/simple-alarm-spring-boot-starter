package com.looko.simplealarmspringbootstarter.manager

import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBTemplate
import com.looko.simplealarmspringbootstarter.enumeration.AlarmLevelEnum
import com.looko.simplealarmspringbootstarter.task.EnterpriseWechatBotWebhookTask
import org.slf4j.LoggerFactory
import java.util.concurrent.PriorityBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class WebhookAlarmManager {
    private val logger = LoggerFactory.getLogger(WebhookAlarmManager::class.java)

    private val workQueue = PriorityBlockingQueue<Runnable>()
    private val threadPool: ThreadPoolExecutor

    init {
        logger.info("Webhook 线程池启动中...")
        threadPool = ThreadPoolExecutor(
            1, 1, 60, TimeUnit.SECONDS, workQueue
        )
        logger.info("Webhook 线程池已启动.")
    }

    fun alarm(webhookUrl: String, messageTemplate: EWBTemplate, alarmLevelEnum: AlarmLevelEnum) {
        threadPool.execute(EnterpriseWechatBotWebhookTask(webhookUrl, messageTemplate, alarmLevelEnum))
    }

    fun onDestroy() {
        logger.info("Webhook 线程池关闭中...")
        threadPool.shutdown()
        try {
            if (!threadPool.awaitTermination(1, TimeUnit.SECONDS)) {
                shutdownNowAndLog()
            }
        } catch (e: InterruptedException) {
            shutdownNowAndLog()
        }
        logger.info("Webhook 线程池已关闭.")
    }

    private fun shutdownNowAndLog() {
        threadPool.shutdownNow().forEach { runnable ->
            (runnable as? EnterpriseWechatBotWebhookTask)?.let {
                logger.warn("线程池关闭, 未执行的任务: {}", it)
            }
        }
    }
}