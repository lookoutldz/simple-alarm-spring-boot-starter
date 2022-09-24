package com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message.content

data class TextEntity(val content: String, val mentioned_list: Array<String>? = null, val mentioned_mobile_list: Array<String>? = null) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TextEntity

        if (content != other.content) return false
        if (!mentioned_list.contentEquals(other.mentioned_list)) return false
        if (!mentioned_mobile_list.contentEquals(other.mentioned_mobile_list)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = content.hashCode()
        result = 31 * result + mentioned_list.contentHashCode()
        result = 31 * result + mentioned_mobile_list.contentHashCode()
        return result
    }

}
