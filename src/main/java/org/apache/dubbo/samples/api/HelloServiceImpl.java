package org.apache.dubbo.samples.api;

import org.apache.dubbo.config.annotation.Service;
//@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService{
    public void sayHello() {
        System.out.println("hello word");
    }
}
