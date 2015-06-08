/*
 * Copyright 2015-2020 Fengduo.co All right reserved. This software is the confidential and proprietary information of
 * Fengduo.co ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Fengduo.co.
 */
package com.fengduo.spark.service.interfaces;

import java.util.List;

import com.fengduo.spark.model.entity.User;

/**
 * @author zxc Jun 3, 2015 12:02:07 AM
 */
public interface AccountService {

    public static final String HASH_ALGORITHM   = "SHA-1";
    public static final int    HASH_INTERATIONS = 1024;

    public List<User> getAllUser();

    public User getUser(Long id);

    public User findUserByLoginName(String loginName);

    public void registerUser(User user);

    public void updateUser(User user);

    public void deleteUser(Long id);
}
