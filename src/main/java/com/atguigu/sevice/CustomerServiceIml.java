package com.atguigu.sevice;

import com.atguigu.pojo.User;

import java.util.List;

/**
 * @date 2022-08-04 13:47
 */
public class CustomerServiceIml {
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