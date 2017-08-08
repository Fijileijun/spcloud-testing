package io.jacobs.stu.springcloud.provider.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by Jacobs on 2017/8/5.
 */
@RestController
public class HelloController {

    private  Logger logger = Logger.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hi")
    public String sayHello() throws InterruptedException {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();

        //添加休眠时间，导致客户端超时，触发circuit breaker逻辑
        int sleepTimes = new Random().nextInt(3000);
        Thread.sleep(sleepTimes);

        logger.info("service_id is " + instance.getServiceId());

        return "hello Jacobs";
    }

}
