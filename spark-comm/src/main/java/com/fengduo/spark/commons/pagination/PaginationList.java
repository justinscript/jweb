/*
 * Copyright 2015-2020 Fengduo.com All right reserved. This software is the confidential and proprietary information of
 * Fengduo.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Fengduo.com.
 */
package com.fengduo.spark.commons.pagination;

import java.util.ArrayList;

/**
 * @author zxc May 28, 2015 11:18:10 PM
 */
public class PaginationList<E> extends ArrayList<E> {

    private static final long serialVersionUID = 8198909484620898963L;

    private Pagination        query;

    public PaginationList(Pagination query) {
        super();
        this.query = query;
    }

    public Pagination getQuery() {
        return query;
    }

    public void setQuery(Pagination query) {
        this.query = query;
    }
}
