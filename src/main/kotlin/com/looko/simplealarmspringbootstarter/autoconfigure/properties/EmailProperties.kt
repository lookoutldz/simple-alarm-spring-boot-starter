package com.looko.simplealarmspringbootstarter.autoconfigure.properties

import com.looko.simplealarmspringbootstarter.entity.config.EmailConfigEntity
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "simple.alarm.email")
data class EmailProperties(
    var configs: Array<EmailConfigEntity> = arrayOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EmailProperties

        if (!configs.contentEquals(other.configs)) return false

        return true
    }

    override fun hashCode(): Int {
        return configs.contentHashCode()
    }

}