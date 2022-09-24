package com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message

import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBMessageType
import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBTemplate
import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message.content.ImageEntity

data class ImageMessage(val image: ImageEntity, override val msgtype: EWBMessageType = EWBMessageType.IMAGE):
    EWBTemplate
