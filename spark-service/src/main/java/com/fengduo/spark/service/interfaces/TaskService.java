/*
 * Copyright 2015-2020 MSUN.com All right reserved. This software is the confidential and proprietary information of
 * MSUN.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.com.
 */
package com.fengduo.spark.service.interfaces;

import java.util.List;
import java.util.Map;

import com.fengduo.spark.commons.pagination.PaginationList;
import com.fengduo.spark.model.entity.Task;

/**
 * @author zxc Jun 3, 2015 12:02:38 AM
 */
public interface TaskService {

    public Task getTask(Long id);

    public void saveTask(Task entity);

    public void deleteTask(Long id);

    public List<Task> getAllTask();

    public PaginationList<Task> getUserTask(Long userId, Map<String, Object> searchParams, int pageNumber,
                                            int pageSize, String sortType);
}
