/*
 * Copyright 2015-2020 Fengduo.com All right reserved. This software is the confidential and proprietary information of
 * Fengduo.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Fengduo.com.
 */
package com.fengduo.spark.web.rest;

import org.springframework.http.HttpStatus;

/**
 * @author zxc
 */
public class RestException extends RuntimeException {

    private static final long serialVersionUID = -741160051865240916L;

    public HttpStatus         status           = HttpStatus.INTERNAL_SERVER_ERROR;

    public RestException() {
    }

    public RestException(HttpStatus status) {
        this.status = status;
    }

    public RestException(String message) {
        super(message);
    }

    public RestException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
