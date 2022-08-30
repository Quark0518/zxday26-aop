package com.atguigu.sevice;

import com.atguigu.pojo.User;

import java.util.List;

/**
 * @date 2022-08-03 20:11
 */
public interface Userservice {
    void add(User user);
    void delete(Integer id);
    void update(User user);
    List<User> select();
}