package org.apache.dubbo.samples.api;

import com.alibaba.dubbo.config.annotation.Service;

//@Service(version = "1.0.0")
public class GreetingsServiceImpl implements GreetingsService{
    public String sayHi(String name) {
        return "hi, " + name;
    }
}
