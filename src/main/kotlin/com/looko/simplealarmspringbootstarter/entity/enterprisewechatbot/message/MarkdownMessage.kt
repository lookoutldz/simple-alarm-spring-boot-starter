package com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message

import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBMessageType
import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.EWBTemplate
import com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message.content.TextEntity

// markdown内容，最长不超过4096个字节，必须是utf8编码
data class MarkdownMessage(val markdown: TextEntity, override val msgtype: EWBMessageType = EWBMessageType.MARKDOWN):
    EWBTemplate