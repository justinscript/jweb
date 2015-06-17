/*
 * Copyright 2015-2020 MSUN.com All right reserved. This software is the confidential and proprietary information of
 * MSUN.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.com.
 */
package com.fengduo.spark.commons.util;

import org.joda.time.DateTime;

/**
 * @author zxc May 28, 2015 3:47:12 PM
 */
public class TimeHelper {

    private TimeHelper() {

    }

    public static final long ONE_DAY_MILLISECONDS = 60 * 60 * 24 * 1000;

    public static long calcDelay(int hour, int minute, int second) {
        if (!(0 <= hour && hour <= 23 && 0 <= minute && minute <= 59 && 0 <= second && second <= 59)) {
            throw new IllegalArgumentException();
        }
        return calcDelay(fixed(hour, minute, second));
    }

    private static long calcDelay(DateTime targetDatetimeOfToday) {
        long delay = 0;
        DateTime now = new DateTime();

        // 时间点已过，只好延时到明天的这个时间点再执行
        if (now.isAfter(targetDatetimeOfToday)) {
            delay = now.plusDays(1).getMillis() - now.getMillis();

            // 时间点未到
        } else {
            delay = targetDatetimeOfToday.getMillis() - now.getMillis();
        }

        return delay;
    }

    /**
     * 返回这样一个DateTime对象： 1.日期为今天 2.时分秒为参数指定的值
     * 
     * @param hour 0-23
     * @param minute 0-59
     * @param second 0-59
     * @return
     */
    private static DateTime fixed(int hour, int minute, int second) {

        return new DateTime().withHourOfDay(hour).withMinuteOfHour(minute).withSecondOfMinute(second);
    }
}
