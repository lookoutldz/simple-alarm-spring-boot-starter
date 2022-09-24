package com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message

import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBMessageType
import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBTemplate
import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message.content.TemplateCardEntity

data class TemplateCardMessage(val template_card: TemplateCardEntity, override val msgtype: EWBMessageType = EWBMessageType.TEMPLATE_CARD):
    EWBTemplate
