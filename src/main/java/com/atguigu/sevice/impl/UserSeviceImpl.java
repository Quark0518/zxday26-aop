package com.atguigu.sevice.impl;

import com.atguigu.pojo.User;
import com.atguigu.sevice.Userservice;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2022-08-03 20:16
 */
@Service
public class UserSeviceImpl implements Userservice {
    public void add(User user){
        System.out.println("UserSeviceImpl add");
    }

    public void delete(Integer id) {
        System.out.println("UserSeviceImpl delete");
    }

    public void update(User user) {
        System.out.println("UserSeviceImpl update");

    }

    public List<User> select() {
        System.out.println("UserSeviceImpl select");
        return null;
    }
}