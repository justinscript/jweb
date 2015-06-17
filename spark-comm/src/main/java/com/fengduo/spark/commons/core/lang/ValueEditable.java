/*
 * Copyright 2015-2020 MSUN.comm All right reserved. This software is the confidential and proprietary information of
 * MSUN.comm ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.comm.
 */
package com.fengduo.spark.commons.core.lang;

import java.util.Map;

/**
 * @author zxc May 28, 2015 12:22:47 AM
 */
public interface ValueEditable {

    /**
     * 更新属性的值，将更新后的值放到name2Values中去
     * 
     * @param raw 需要回去属性的对象
     * @param name2Values 当前对象的属性名和对应的值
     */
    @SuppressWarnings("rawtypes")
    void edit(Object raw, Map name2Values);
}
