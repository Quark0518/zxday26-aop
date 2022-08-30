package com.atguigu.proxy;

import com.atguigu.sevice.CustomerServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.lang.reflect.Method;

/**
 * @date 2022-08-04 13:53
 */

@Service
@ContextConfiguration(locations = "classpath:spring.xml")
public class CustomerCGLIBProxy {
    @Autowired
    @Qualifier("Enhancer")
    private  Enhancer enhancer;

    /**
     *
     * @param clazz 参数是被代理类对象字节码对象
     * @return 返回值是代理对象
     */
    public  CustomerServiceIml creCglibProxy(Class<CustomerServiceIml> clazz){
        //利用CGLIB核心类对象继承被代理类
        //Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        //执行方法增强
        enhancer.setCallback(new MethodInterceptor() {
            // proxy代理对象
            //method 被代理类原方法对象
            //args 被代理类原方法的实际参数
            //methodProxy 代理类方法对象
            public Object intercept(Object proxy,
                                    Method method,
                                    Object[] args,
                                    MethodProxy methodProxy) throws Throwable {
                System.out.println("权限校验");
                /*//执行原方法--通过原方法执行
                method.invoke(clazz.newInstance(),args);*/
                //通过执行代理对象方法执行原方法
                methodProxy.invokeSuper(proxy,args);
                System.out.println("日志记录");
                return null;
            }
        });

        return (CustomerServiceIml) enhancer.create();
    }
}