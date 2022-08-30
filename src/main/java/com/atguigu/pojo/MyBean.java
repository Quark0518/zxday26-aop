package com.atguigu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @date 2022-08-04 14:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyBean {
    private String[] myStrs;
    private List<User> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;


}