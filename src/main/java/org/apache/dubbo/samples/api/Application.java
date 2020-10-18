package org.apache.dubbo.samples.api;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.util.concurrent.CountDownLatch;

public class Application {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");

    private static void export1() {
        ServiceConfig<GreetingsService> service = new ServiceConfig<GreetingsService>();
        service.setApplication(new ApplicationConfig("first-dubbo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://"+zookeeperHost+":2181"));
        service.setInterface(GreetingsService.class);
        service.setRef(new GreetingsServiceImpl());
        service.export();
    }

    public static void main(String[] args) throws Exception{


        export1();

        System.out.println("dubbo service provider started");
        new CountDownLatch(1).await();
    }
}
