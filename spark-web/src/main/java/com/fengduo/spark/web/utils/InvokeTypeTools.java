/*
 * Copyright 2015-2020 Fengduo.com All right reserved. This software is the confidential and proprietary information of
 * Fengduo.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Fengduo.com.
 */
package com.fengduo.spark.web.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * 请求的类型
 * 
 * @author zxc May 28, 2015 11:54:13 PM
 */
public class InvokeTypeTools {

    private static final String INVOKE_TYPE                    = "Invoke-Type";

    private static final String HTML5_FILE_UPLOAD_CONTENT_TYPE = "application/octet-stream";

    public static boolean isHtml5(HttpServletRequest request) {
        return HTML5_FILE_UPLOAD_CONTENT_TYPE.equals(request.getContentType());
    }

    public static boolean isAjax(HttpServletRequest request) {
        return InvokeType.isAjax(request.getHeader(INVOKE_TYPE))
               || "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }

    public static InvokeType getInvokeType(HttpServletRequest request) {
        return InvokeType.getEnum(request.getHeader(INVOKE_TYPE));
    }

    public static enum InvokeType {

        AJAX, HTTP;

        public static boolean isAjax(String type) {
            return AJAX.name().equalsIgnoreCase(type);
        }

        public static boolean isHttp(String type) {
            return HTTP.name().equalsIgnoreCase(type);
        }

        public static InvokeType getEnum(String type) {
            for (InvokeType t : values()) {
                if (StringUtils.equalsIgnoreCase(t.name(), type)) {
                    return t;
                }
            }
            return null;
        }
    }
}
