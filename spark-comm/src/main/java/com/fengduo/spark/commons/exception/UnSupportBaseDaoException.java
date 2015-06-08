/*
 * Copyright 2015-2020 Fengduo.co All right reserved. This software is the confidential and proprietary information of
 * Fengduo.co ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Fengduo.co.
 */
package com.fengduo.spark.commons.exception;

/**
 * @author zxc Jun 2, 2015 6:01:12 PM
 */
public class UnSupportBaseDaoException extends RuntimeException {

    private static final long serialVersionUID = -146345309677115693L;

    public UnSupportBaseDaoException() {

    }

    public UnSupportBaseDaoException(String message) {
        super(message);
    }

    public UnSupportBaseDaoException(Throwable cause) {
        super(cause);
    }

    public UnSupportBaseDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
