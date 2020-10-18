package org.apache.dubbo.samples.api.seata;

//import org.apache.curator.test.TestingServer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The type Dubbo tcc provider starter.
 *
 * @author zhangsen
 */
public class DubboTccProviderStarter {

    //private static TestingServer server;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        //mock zk server
        //mockZKServer();

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            new String[] {"spring/seata-tcc.xml", "spring/seata-dubbo-provider.xml"});

        new ApplicationKeeper(applicationContext).keep();
    }
}
