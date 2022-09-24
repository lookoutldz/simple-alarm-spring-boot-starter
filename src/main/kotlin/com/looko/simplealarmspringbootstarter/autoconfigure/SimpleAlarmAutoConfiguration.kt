package com.looko.simplealarmspringbootstarter.autoconfigure

import com.looko.simplealarmspringbootstarter.autoconfigure.properties.EmailProperties
import com.looko.simplealarmspringbootstarter.autoconfigure.properties.EnterpriseWechatBotProperties
import com.looko.simplealarmspringbootstarter.component.AlarmByEmail
import com.looko.simplealarmspringbootstarter.component.AlarmByEnterpriseWechatBot
import com.looko.simplealarmspringbootstarter.manager.WebhookAlarmManager
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnClass(SimpleAlarmAutoConfiguration::class)
@EnableConfigurationProperties(value = [EmailProperties::class, EnterpriseWechatBotProperties::class])
class SimpleAlarmAutoConfiguration {
    @Bean
    fun alarmByEmail(properties: EmailProperties): AlarmByEmail {
        // TODO 参数校验
        return AlarmByEmail(properties.configs)
    }

    @Bean
    fun alarmByEnterpriseWechatBot(properties: EnterpriseWechatBotProperties): AlarmByEnterpriseWechatBot {
        // TODO 参数校验
        return AlarmByEnterpriseWechatBot(properties.webhookUrls)
    }

    @Bean(destroyMethod = "onDestroy")
    fun webhookAlarmManager(): WebhookAlarmManager {
        return WebhookAlarmManager()
    }
}