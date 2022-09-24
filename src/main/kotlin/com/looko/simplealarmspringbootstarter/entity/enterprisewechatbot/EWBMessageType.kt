package com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot

import com.google.gson.annotations.SerializedName

enum class EWBMessageType(private val value: String) {

    @SerializedName("text")
    TEXT("text"), // 文本
    @SerializedName("markdown")
    MARKDOWN("markdown"), // markdown
    @SerializedName("image")
    IMAGE("image"), // 图片
    @SerializedName("news")
    NEWS("news"), // 图文
    @SerializedName("file")
    FILE("file"), // 文件
    @SerializedName("template_card")
    TEMPLATE_CARD("template_card"); // 模板卡片;
}