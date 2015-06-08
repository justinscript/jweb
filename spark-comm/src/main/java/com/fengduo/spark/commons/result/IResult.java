/*
 * Copyright 2015-2020 Fengduo.com All right reserved. This software is the confidential and proprietary information of
 * Fengduo.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Fengduo.com.
 */
package com.fengduo.spark.commons.result;

/**
 * Result 通用返回结果包装类
 * 
 * <pre>
 * 用于方法的返回值
 *      很多方法除了要返回成功与否，还要返回错误信息和数据
 *      isSuccess()得到操作是否成功
 *      getMessage()得到错误信息
 *      getData()数据
 * </pre>
 * 
 * @author zxc May 28, 2015 11:16:31 PM
 */
public interface IResult {

    boolean isSuccess();

    boolean isFailed();

    String getErrorCode();

    String getDesc();

    String toString();
}
