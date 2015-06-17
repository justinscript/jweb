/*
 * Copyright 2015-2020 MSUN.comm All right reserved. This software is the confidential and proprietary information of
 * MSUN.comm ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.comm.
 */
package com.fengduo.spark.commons.velocity;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.fengduo.spark.commons.core.SpringContextAware;

/**
 * @author zxc May 28, 2015 2:15:00 PM
 */
@Component
public class VelocityViewPaser {

    private static final Logger logger                   = LoggerFactory.getLogger(VelocityViewPaser.class);

    public static final String  DEFAULT_LAYOUT_DIRECTORY = "/layout";
    public static final String  DEFAULT_VIEW_DIRECTORY   = "/view";
    public static final String  DEFAULT_WIDGET_DIRECTORY = "/widget";

    public static final String  DEFAULT_RELOAD_PATH      = "reloadPath";

    private VelocityEngine      velocityEngine;

    @PostConstruct
    public void init() {

        // @SuppressWarnings("unused")
        // ViewResolver viewResolver = (ViewResolver)
        // SpringContextAware.getBean(DispatcherServlet.VIEW_RESOLVER_BEAN_NAME);

        Properties pro = new Properties();
        pro.setProperty("resource.loader", "file");
        pro.setProperty("file.resource.loader.path", DEFAULT_RELOAD_PATH);
        pro.setProperty("input.encoding", "utf-8");
        pro.setProperty("output.encoding", "utf-8");
        velocityEngine = new VelocityEngine(pro);
    }

    public static VelocityViewPaser getInstance() {
        return (VelocityViewPaser) SpringContextAware.getBean("velocityViewPaser");
    }

    /**
     * 渲染$WORKSPACE/resources下的模板
     * 
     * @param templateName 模板的名字，注意是相对于$WORKSPACE/resources的路径名称。例如/user/join_success.vm
     * @param model 数据对象
     * @return
     */
    @SuppressWarnings("deprecation")
    public StringWriter mergetTemplate(String templateName, Map<String, Object> model) {
        StringWriter sw = new StringWriter();
        try {
            VelocityEngineUtils.mergeTemplate(velocityEngine, getTemplatePath(templateName), model, sw);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return sw;
    }

    private String getTemplatePath(String templateName) {
        return DEFAULT_WIDGET_DIRECTORY + templateName;
    }
}
