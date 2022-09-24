package com.looko.simplealarmspringbootstarter.entity.config

data class EmailConfigEntity(
    var host: String? = null,
    var senderEmail: String? = null,
    var senderPassword: String? = null,
    var authEnable: Boolean = true,
    var emailProtocol: String = "smtp",
    var sslEnable: Boolean = true,
    var sslProtocol: String = "TLSv1.2",
    var receivers: Array<String> = arrayOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EmailConfigEntity

        if (host != other.host) return false
        if (senderEmail != other.senderEmail) return false
        if (senderPassword != other.senderPassword) return false
        if (authEnable != other.authEnable) return false
        if (emailProtocol != other.emailProtocol) return false
        if (sslEnable != other.sslEnable) return false
        if (sslProtocol != other.sslProtocol) return false
        if (!receivers.contentEquals(other.receivers)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = host.hashCode()
        result = 31 * result + senderEmail.hashCode()
        result = 31 * result + senderPassword.hashCode()
        result = 31 * result + authEnable.hashCode()
        result = 31 * result + emailProtocol.hashCode()
        result = 31 * result + sslEnable.hashCode()
        result = 31 * result + sslProtocol.hashCode()
        result = 31 * result + receivers.contentHashCode()
        return result
    }
}
