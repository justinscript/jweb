/*
 * Copyright 2015-2020 Fengduo.com All right reserved. This software is the confidential and proprietary information of
 * Fengduo.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Fengduo.com.
 */
package com.fengduo.spark.commons.persistence;

import java.io.Serializable;

/**
 * @author zxc May 28, 2015 11:17:18 PM
 */
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 5989416184485750520L;

    /**
     * 实体编号（唯一标识）
     */
    protected String          id;

    public BaseEntity() {

    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
