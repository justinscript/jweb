/*
 * Copyright 2015-2020 MSUN.comm All right reserved. This software is the confidential and proprietary information of
 * MSUN.comm ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.comm.
 */
package com.fengduo.spark.commons.core;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 自定义toString方法Style
 * 
 * @author zxc May 28, 2015 12:18:08 PM
 */
public class CustomToStringStyle extends ToStringStyle {

    private static final long serialVersionUID = -2609851797407312977L; ;

    protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
        if (value instanceof Date) {
            value = new SimpleDateFormat("yyyy-MM-dd").format(value);
        }
        buffer.append(value);
    }
}
