package com.looko.simplealarmspringbootstarter

import com.looko.simplealarmspringbootstarter.autoconfigure.SimpleAlarmAutoConfiguration
import com.looko.simplealarmspringbootstarter.component.AlarmByEmail
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest(classes = [SimpleAlarmAutoConfiguration::class])
@TestPropertySource("classpath:secret_for_git.properties")
class SimpleAlarmSpringBootStarterApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Autowired
    lateinit var alarmByEmail: AlarmByEmail

    @Test
    fun testAlarmByEmail() {
        assert(alarmByEmail.sendMessage("Message Content"))
    }
}
