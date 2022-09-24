package com.looko.simplealarmspringbootstarter.task

import com.looko.simplealarmspringbootstarter.enumeration.AlarmLevelEnum

abstract class PrioritizedAlarmTask(open val alarmLevelEnum: AlarmLevelEnum): Runnable, Comparable<PrioritizedAlarmTask> {
    override fun compareTo(other: PrioritizedAlarmTask): Int {
        return other.alarmLevelEnum.value - this.alarmLevelEnum.value
    }
}
