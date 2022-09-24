package com.looko.simplealarmspringbootstarter.component

import com.looko.simplealarmspringbootstarter.entity.config.EmailConfigEntity
import org.slf4j.LoggerFactory
import java.util.*
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class AlarmByEmail(private val configs: Array<EmailConfigEntity>) {

    private val logger = LoggerFactory.getLogger(AlarmByEmail::class.java)

    fun sendMessage(content: String): Boolean {
        try {
            for (config in configs) {
                with(config) {
                    val properties = Properties()
                        .apply {
                            setProperty("mail.transport.protocol", emailProtocol)
                            setProperty("mail.smtp.auth", authEnable.toString())
                            setProperty("mail.smtp.ssl.enable", sslEnable.toString())
                            setProperty("mail.smtp.ssl.protocols", sslProtocol)
                            setProperty("mail.smtp.host", host)
                        }
                    val session = Session.getDefaultInstance(
                        properties,
                        object: Authenticator() {
                            override fun getPasswordAuthentication(): PasswordAuthentication {
                                return PasswordAuthentication(senderEmail, senderPassword)
                            }
                        }
                    ).apply {
                        debug = false
                    }
                    val mimeMessage = MimeMessage(session)
                        .apply {
                            subject = "这是一封测试邮件"
                            setFrom(
                                InternetAddress(senderEmail, senderEmail, "UTF-8")
                            )
                            setRecipients(
                                Message.RecipientType.TO,
                                receivers.map { InternetAddress(it) }.toTypedArray()
                            )
                            setText(content)
                        }
                    session.transport.apply {
                        connect(host, senderEmail, senderPassword)
                        sendMessage(mimeMessage, mimeMessage.allRecipients)
                        close()
                    }
                    logger.info("邮件已发送自[$senderEmail].")
                }
            }
            return true
        } catch (e: Exception) {
            logger.error("邮件发送失败. 详细信息: ", e)
            return false
        }
    }
}