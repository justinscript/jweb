/*
 * Copyright 2015-2020 Fengduo.co All right reserved. This software is the confidential and proprietary information of
 * Fengduo.co ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Fengduo.co.
 */
package com.fengduo.spark.data.dao;

import com.fengduo.spark.commons.persistence.CrudMapper;
import com.fengduo.spark.commons.persistence.annotation.MyBatisRepository;
import com.fengduo.spark.model.entity.Task;

/**
 * @author zxc Jun 2, 2015 10:28:11 PM
 */
@MyBatisRepository
public interface TaskDao extends CrudMapper<Task> {

    public void deleteByUserId(Long id);
}
