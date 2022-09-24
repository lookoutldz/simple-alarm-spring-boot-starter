package com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message

import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBMessageType
import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBTemplate
import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message.content.NewsEntity

data class NewsMessage(val news: NewsEntity, override val msgtype: EWBMessageType = EWBMessageType.NEWS): EWBTemplate
