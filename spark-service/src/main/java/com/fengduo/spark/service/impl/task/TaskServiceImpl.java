/*
 * Copyright 2015-2020 MSUN.com All right reserved. This software is the confidential and proprietary information of
 * MSUN.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.com.
 */
package com.fengduo.spark.service.impl.task;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengduo.spark.commons.pagination.Pagination;
import com.fengduo.spark.commons.pagination.PaginationList;
import com.fengduo.spark.data.dao.TaskDao;
import com.fengduo.spark.model.entity.Task;
import com.fengduo.spark.service.interfaces.TaskService;
import com.google.common.collect.Maps;

/**
 * @author zxc Jun 3, 2015 12:03:42 AM
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    public Task getTask(Long id) {
        return taskDao.getById(id);
    }

    public void saveTask(Task entity) {
        taskDao.insert(entity);
    }

    public void deleteTask(Long id) {
        taskDao.deleteById(id);
    }

    public List<Task> getAllTask() {
        Map<String, Object> query = Maps.newHashMap();
        return (List<Task>) taskDao.list(query);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public PaginationList<Task> getUserTask(Long userId, Map<String, Object> searchParams, int pageNumber,
                                            int pageSize, String sortType) {
        searchParams.put("startRecordIndex", pageNumber - 1);
        searchParams.put("pageSize", pageSize);
        searchParams.put("userId", userId);

        if ("auto".equals(sortType)) {
            searchParams.put("sort", "id");
        } else if ("title".equals(sortType)) {
            searchParams.put("sort", "title");
        }

        Pagination query = new Pagination();
        query.setNowPageIndex((int) searchParams.get("startRecordIndex"));
        query.setPageSize(pageSize);

        PaginationList paginationList = new PaginationList(query);
        Integer count = taskDao.count(searchParams);
        int totalCount = count == null ? 0 : count;
        query.init(totalCount);
        if (totalCount > 0) {
            List<Task> items = taskDao.listPagination(searchParams);
            if (items != null) {
                paginationList.addAll(items);
            }
        }
        return paginationList;
    }
}
