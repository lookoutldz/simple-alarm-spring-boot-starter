package com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message

import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBMessageType
import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBTemplate
import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message.content.TextEntity


data class TextMessage(val text: TextEntity, override val msgtype: EWBMessageType = EWBMessageType.TEXT): EWBTemplate