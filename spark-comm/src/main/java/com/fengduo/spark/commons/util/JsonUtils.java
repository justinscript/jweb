/*
 * Copyright 2015-2020 MSUN.comm All right reserved. This software is the confidential and proprietary information of
 * MSUN.comm ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.comm.
 */
package com.fengduo.spark.commons.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

/**
 * @author zxc May 28, 2015 12:34:20 PM
 */
public class JsonUtils {

    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static boolean isBadJson(String json) {
        return !isGoodJson(json);
    }

    public static boolean isGoodJson(String json) {
        if (StringUtils.isBlank(json)) {
            return false;
        }
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonParseException e) {
            logger.error("bad json: " + json);
            return false;
        }
    }
}
