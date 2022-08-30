package com.atguigu.proxy;

import com.atguigu.sevice.CustomerServiceIml;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class CustomerCGLIBProxyTest {
    @Autowired
    private CustomerCGLIBProxy customerCGLIBProxy;
    @Test

    public void creCglibProxy() {
        CustomerServiceIml customerServiceIml = customerCGLIBProxy.creCglibProxy(CustomerServiceIml.class);
        customerServiceIml.add(null);
    }
}