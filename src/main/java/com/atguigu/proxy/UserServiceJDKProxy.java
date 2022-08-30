package com.atguigu.proxy;

import com.atguigu.pojo.User;
import com.atguigu.sevice.Userservice;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date 2022-08-03 20:24
 */
@Service
@Qualifier("UserServiceJDKProxy")
public class UserServiceJDKProxy {
    /**
     * @param userservice 代理对象(实际上是UserServiceImpl,整理用了多态
     * @return 返回的是代理对象
     */
    public static Userservice createProxy(final Userservice userservice) {
        //jdkProxy核心代理对象
        //ClassLoader loader : 被代理类的类加载器
        //Class<?>[] interfaces : 被代理类实现的所有接口
        //InvocationHandler h : 方法增强处理器
        Userservice proxy = (Userservice) Proxy.newProxyInstance(userservice.getClass().getClassLoader(),
                userservice.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //Object proxy 代理类对象
                        //Method method 被代理类方法
                        //Object[] args 被代理类方法参数
                        //返回值是代理对象

                        //增强方法
                        System.out.println("权限校验");
                        //原方法
                        Object result = method.invoke(userservice, args);
                        System.out.println("日志打印");

                        return null;
                    }
                }
        );
        return proxy;
    }
}