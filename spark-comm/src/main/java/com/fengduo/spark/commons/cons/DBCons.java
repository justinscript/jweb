/*
 * Copyright 2015-2020 Fengduo.com All right reserved. This software is the confidential and proprietary information of
 * Fengduo.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Fengduo.com.
 */
package com.fengduo.spark.commons.cons;

/**
 * 数据库 规则
 * 
 * @author zxc May 28, 2015 1:47:03 PM
 */
public interface DBCons {

    /**
     * 数据库中字符串最大长度<br>
     * oracle中varchar2最大长度4000,用UTF-8存储,每个中文占3个字节
     */
    int    MAX_STRING_LENGTH  = 1333;

    /**
     * 数据库中一些数据的分隔符
     */
    char   SPLIT_COMMA        = ',';

    /**
     * 数据库中一些数据的分隔符
     */
    String SPLIT_COMMA_STRING = ",";
}
