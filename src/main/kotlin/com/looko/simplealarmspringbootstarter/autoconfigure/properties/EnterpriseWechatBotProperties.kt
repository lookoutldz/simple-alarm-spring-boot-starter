package com.looko.simplealarmspringbootstarter.autoconfigure.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "simple.alarm.enterprise-wechat-bot")
data class EnterpriseWechatBotProperties(var webhookUrls: Array<String> = arrayOf()) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EnterpriseWechatBotProperties

        if (!webhookUrls.contentEquals(other.webhookUrls)) return false

        return true
    }

    override fun hashCode(): Int {
        return webhookUrls.contentHashCode()
    }
}