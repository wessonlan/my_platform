package com.mock.platform.service;

import com.alibaba.fastjson.JSONObject;
import com.mock.platform.dao.UserDAO;
import com.mock.platform.pojo.User;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //标记这是一个service类
public class UserService {
    @Autowired //自动装配UserDAO对象
    UserDAO userDAO;

    public List<User> userList() {
        //  Sort 对象，表示通过 id 倒排序
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        // 通过 categoryDAO进行查询
        return userDAO.findAll(sort);
    }

    /**
     * 判断用户是否存在，存在则返回true，不存在则返回false
     * @param username 用户名
     * @param password 用户密码
     * @return true,false
     */
    public boolean isUserExist(String username, String password) {
        List<User> userList = userList();
        boolean isExist = false;
        for (User user: userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                isExist = true;
            }
        }
        return isExist;
    }
}
