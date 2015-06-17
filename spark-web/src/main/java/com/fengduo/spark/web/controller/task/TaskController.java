/*
 * Copyright 2015-2020 MSUN.comm All right reserved. This software is the confidential and proprietary information of
 * MSUN.comm ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.comm.
 */
package com.fengduo.spark.web.controller.task;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fengduo.spark.commons.pagination.PaginationList;
import com.fengduo.spark.model.entity.Task;
import com.fengduo.spark.model.entity.User;
import com.fengduo.spark.service.impl.account.ShiroDbRealm.ShiroUser;
import com.fengduo.spark.service.interfaces.TaskService;
import com.fengduo.spark.web.utils.Servlets;
import com.google.common.collect.Maps;

/**
 * Task管理的Controller, 使用Restful风格的Urls:
 * 
 * <pre>
 * List page : GET /task/
 * Create page : GET /task/create
 * Create action : POST /task/create
 * Update page : GET /task/update/{id}
 * Update action : POST /task/update
 * Delete action : GET /task/delete/{id}
 * </pre>
 * 
 * @author zxc
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController {

    private static final String        PAGE_SIZE = "3";

    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
    static {
        sortTypes.put("auto", "自动");
        sortTypes.put("title", "标题");
    }

    @Autowired
    private TaskService                taskService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", defaultValue = "1")
    int pageNumber, @RequestParam(value = "page.size", defaultValue = PAGE_SIZE)
    int pageSize, @RequestParam(value = "sortType", defaultValue = "auto")
    String sortType, Model model, ServletRequest request) {
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Long userId = getCurrentUserId();

        PaginationList<Task> tasks = taskService.getUserTask(userId, searchParams, pageNumber, pageSize, sortType);

        model.addAttribute("tasks", tasks);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        // 将搜索条件编码成字符串，用于排序，分页的URL
        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));

        return "task/taskList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("action", "create");
        return "task/taskForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid
    Task newTask, RedirectAttributes redirectAttributes) {
        User user = new User(getCurrentUserId());
        newTask.setUser(user);

        taskService.saveTask(newTask);
        redirectAttributes.addFlashAttribute("message", "创建任务成功");
        return "redirect:/task/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id")
    Long id, Model model) {
        model.addAttribute("task", taskService.getTask(id));
        model.addAttribute("action", "update");
        return "task/taskForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid
    @ModelAttribute("task")
    Task task, RedirectAttributes redirectAttributes) {
        taskService.saveTask(task);
        redirectAttributes.addFlashAttribute("message", "更新任务成功");
        return "redirect:/task/";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id")
    Long id, RedirectAttributes redirectAttributes) {
        taskService.deleteTask(id);
        redirectAttributes.addFlashAttribute("message", "删除任务成功");
        return "redirect:/task/";
    }

    /**
     * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
     * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
     */
    @ModelAttribute
    public void getTask(@RequestParam(value = "id", defaultValue = "-1")
    Long id, Model model) {
        if (id != -1) {
            model.addAttribute("task", taskService.getTask(id));
        }
    }

    /**
     * 取出Shiro中的当前用户Id.
     */
    private Long getCurrentUserId() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }
}
