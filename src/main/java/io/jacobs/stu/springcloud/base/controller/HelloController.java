package io.jacobs.stu.springcloud.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jacobs on 2017/8/5.
 */
@RestController
public class HelloController {

    @RequestMapping("/hi")
    public String sayHello(){
        return "hello Jacobs";
    }

}
