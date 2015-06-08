/*
 * Copyright 2015-2020 Fengduo.co All right reserved. This software is the confidential and proprietary information of
 * Fengduo.co ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Fengduo.co.
 */
package com.fengduo.spark.service.impl.account;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengduo.spark.commons.core.utils.Clock;
import com.fengduo.spark.commons.core.utils.Encodes;
import com.fengduo.spark.commons.security.Digests;
import com.fengduo.spark.data.dao.TaskDao;
import com.fengduo.spark.data.dao.UserDao;
import com.fengduo.spark.model.entity.User;
import com.fengduo.spark.service.impl.account.ShiroDbRealm.ShiroUser;
import com.fengduo.spark.service.interfaces.AccountService;
import com.google.common.collect.Maps;

/**
 * @author zxc Jun 3, 2015 12:03:12 AM
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static Logger    logger    = LoggerFactory.getLogger(AccountService.class);

    private static final int SALT_SIZE = 8;

    @Autowired
    private UserDao          userDao;
    @Autowired
    private TaskDao          taskDao;

    private Clock            clock     = Clock.DEFAULT;

    public List<User> getAllUser() {
        Map<String, Object> query = Maps.newHashMap();
        return (List<User>) userDao.list(query);
    }

    public User getUser(Long id) {
        return userDao.getById(id);
    }

    public User findUserByLoginName(String loginName) {
        Map<String, Object> query = Maps.newHashMap();
        query.put("loginName", loginName);
        return userDao.find(query);
    }

    public void registerUser(User user) {
        entryptPassword(user);
        user.setRoles("user");
        user.setRegisterDate(clock.getCurrentDate());
        userDao.insert(user);
    }

    public void updateUser(User user) {
        if (StringUtils.isNotBlank(user.getPlainPassword())) {
            entryptPassword(user);
        }
        userDao.update(user);
    }

    public void deleteUser(Long id) {
        if (isSupervisor(id)) {
            logger.warn("操作员{}尝试删除超级管理员用户", getCurrentUserName());
            // throw new ServiceException("不能删除超级管理员用户");
            return;
        }
        userDao.deleteById(id);
        taskDao.deleteByUserId(id);
    }

    /**
     * 判断是否超级管理员.
     */
    private boolean isSupervisor(Long id) {
        return id == 1;
    }

    /**
     * 取出Shiro中的当前用户LoginName.
     */
    private String getCurrentUserName() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.loginName;
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(User user) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }
}
