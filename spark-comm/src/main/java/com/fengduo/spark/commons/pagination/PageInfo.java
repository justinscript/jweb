/*
 * Copyright 2015-2020 Fengduo.com All right reserved. This software is the confidential and proprietary information of
 * Fengduo.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Fengduo.com.
 */
package com.fengduo.spark.commons.pagination;

/**
 * 分页---页面显示的
 * 
 * @author zxc May 28, 2015 11:14:09 PM
 */
public class PageInfo {

    private String  text;
    private String  url;
    private int     page;
    private boolean current; // 是否是当前页

    public PageInfo(String text, int page, boolean current, String url) {
        super();
        this.text = text;
        this.url = url;
        this.page = page;
        this.current = current;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
