package com.looko.simplealarmspringbootstarter.component

import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBTemplate
import com.looko.simplealarmspringbootstarter.enumeration.AlarmLevelEnum
import com.looko.simplealarmspringbootstarter.manager.WebhookAlarmManager
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

class AlarmByEnterpriseWechatBot(private val webhookUrls: Array<String>) {

    private val logger = LoggerFactory.getLogger(AlarmByEnterpriseWechatBot::class.java)

    @Autowired
    private lateinit var webhookAlarmManager: WebhookAlarmManager

    fun sendMessage(message: EWBTemplate, alarmLevelEnum: AlarmLevelEnum = AlarmLevelEnum.LOW): Boolean {
        return try {
            // 发送信息
            for (s in webhookUrls) {
                webhookAlarmManager.alarm(s, message, alarmLevelEnum)
                logger.info("已发送. 内容: {$alarmLevelEnum, $s, $message}")
            }
            true
        } catch (e: Exception) {
            logger.error("发送告警信息失败: {}", e.message)
            false
        }
    }
}