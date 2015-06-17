/*
 * Copyright 2015-2020 MSUN.com All right reserved. This software is the confidential and proprietary information of
 * MSUN.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.com.
 */
package com.fengduo.spark.web.controller.account;

import javax.validation.Valid;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fengduo.spark.model.entity.User;
import com.fengduo.spark.service.interfaces.AccountService;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求), 真正登录的POST请求由Filter完成, 用户注册的Controller.
 * 
 * @author zxc May 28, 2015 11:54:13 PM
 */
@Controller
public class LoginController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "account/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM)
    String userName, Model model) {
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
        return "account/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm() {
        return "account/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid
    User user, RedirectAttributes redirectAttributes) {
        accountService.registerUser(user);
        redirectAttributes.addFlashAttribute("username", user.getLoginName());
        return "redirect:/login";
    }

    /**
     * Ajax请求校验loginName是否唯一。
     */
    @RequestMapping(value = "/register/checkLoginName")
    @ResponseBody
    public String checkLoginName(@RequestParam("loginName")
    String loginName) {
        if (accountService.findUserByLoginName(loginName) == null) {
            return "true";
        } else {
            return "false";
        }
    }
}
