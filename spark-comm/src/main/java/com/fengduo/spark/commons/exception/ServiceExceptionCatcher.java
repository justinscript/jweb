/*
 * Copyright 2015-2020 MSUN.com All right reserved. This software is the confidential and proprietary information of
 * MSUN.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.com.
 */
package com.fengduo.spark.commons.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/**
 * @author zxc May 28, 2015 11:18:31 PM
 */
public class ServiceExceptionCatcher {

    protected static final Log log = LogFactory.getLog(ServiceExceptionCatcher.class);

    public void log(JoinPoint proxy, Throwable exception) throws ServiceException {

        if (exception instanceof ServiceException) {
            return;
        }

        Object target = proxy.getTarget();
        log.error(target, exception);
        throw new ServiceException(exception);
    }
}
