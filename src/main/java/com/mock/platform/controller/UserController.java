package com.mock.platform.controller;

import com.alibaba.fastjson.JSONArray;
import com.mock.platform.common.Result;
import com.mock.platform.controller.request.UserRequest;
import com.mock.platform.pojo.User;
import com.mock.platform.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //标记这是控制器，下面每个方法的返回值都会直接转换成json数据格式
@RequestMapping("user")
public class UserController {
    @Autowired //自动装配 CategoryService
    UserService userService;

    @GetMapping("/userList") //当访问users,会获取所有的User对象集合，并返回。RestController会自动转成json给浏览器
    public List<User> userList() throws Exception {
        return userService.userList();
    }


    @PostMapping("/login")
    public Result login(@RequestBody UserRequest user) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        Map<String, Object> userToken = new HashMap<>();
        if (userService.isUserExist(username, password)) {
            userToken.put("token","admin-token");
            return Result.success(userToken);
        } else {
            return Result.fail("用户名或密码错误");
        }
    }


    @GetMapping("/useInfo")
    public Result useInfo(HttpServletRequest request) throws Exception {
        String token = request.getParameter("token");
        Map<String, Object> result = new HashMap<>();
        JSONArray roles = new JSONArray();
        if (token.equals("admin-token")) {
            roles.add("admin");
            result.put("roles", roles);
            result.put("introduction", "我是超级管理员");
            result.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        }
        return Result.success(result);
    }

    @PostMapping("/logout")
    public Result logout() throws Exception {
        return Result.success();
    }
}
