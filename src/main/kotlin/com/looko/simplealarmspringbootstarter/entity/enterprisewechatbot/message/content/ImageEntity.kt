package com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message.content

// 图片（base64编码前）最大不能超过2M，支持JPG,PNG格式
data class ImageEntity(val base64: String, val md5: String)
