/*
 * Copyright 2015-2020 MSUN.com All right reserved. This software is the confidential and proprietary information of
 * MSUN.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.com.
 */
package com.fengduo.spark.data.dao;

import com.fengduo.spark.commons.persistence.CrudMapper;
import com.fengduo.spark.commons.persistence.annotation.MyBatisRepository;
import com.fengduo.spark.model.entity.User;

/**
 * @author zxc Jun 2, 2015 10:28:11 PM
 */
@MyBatisRepository
public interface UserDao extends CrudMapper<User> {

}
