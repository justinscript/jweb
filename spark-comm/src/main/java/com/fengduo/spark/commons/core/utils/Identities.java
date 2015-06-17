/*
 * Copyright 2015-2020 MSUN.comm All right reserved. This software is the confidential and proprietary information of
 * MSUN.comm ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.comm.
 */
package com.fengduo.spark.commons.core.utils;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import com.fengduo.spark.commons.security.EncryptBuilder;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * 
 * @author zxc May 28, 2015 4:06:35 PM
 */
public class Identities {

    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间有-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid2() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 使用SecureRandom随机生成Long.
     */
    public static long randomLong() {
        return Math.abs(random.nextLong());
    }

    /**
     * 基于Base62编码的SecureRandom随机生成bytes.
     */
    public static String randomBase62(int length) {
        byte[] randomBytes = new byte[length];
        random.nextBytes(randomBytes);
        return Encodes.encodeBase62(randomBytes);
    }

    public static final String PURE_MIDDLE_DATE_TIME_FORMAT_STR = "yyyyMMddHHmm";

    public final static String getVehicleCode() {
        Random random = new Random();
        return DateFormatUtils.format(new Date(), PURE_MIDDLE_DATE_TIME_FORMAT_STR) + RandomUtils.nextInt(random, 10)
               + RandomUtils.nextInt(random, 10);
    }

    public final static String getTimestampUUID() {
        return DateFormatUtils.format(new Date(), PURE_MIDDLE_DATE_TIME_FORMAT_STR) + RandomUtils.nextInt(10);
    }

    public static void main(String[] args) {
        System.out.println(uuid2());
        System.out.println(EncryptBuilder.getInstance().encrypt(Long.toString(System.nanoTime()), "fengd$@2015052824"));
    }
}
