package com.looko.simplealarmspringbootstarter.entity.enterprisewechatbot.message.content

data class NewsEntity(val articles: Array<ArticleEntity>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NewsEntity

        if (!articles.contentEquals(other.articles)) return false

        return true
    }

    override fun hashCode(): Int {
        return articles.contentHashCode()
    }
}
