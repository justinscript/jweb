/*
 * Copyright 2015-2020 MSUN.comm All right reserved. This software is the confidential and proprietary information of
 * MSUN.comm ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.comm.
 */
package com.fengduo.spark.commons.exception;

import org.springframework.transaction.TransactionException;

/**
 * @author zxc May 28, 2015 11:18:31 PM
 */
public class RollbackException extends TransactionException {

    private static final long serialVersionUID = -8139406723353941539L;

    public RollbackException(String msg) {
        super(msg);
    }

    public RollbackException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
