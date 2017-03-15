package com.calf.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制类
 *
 * @author calf
 * @create 2017-03-10 15:10
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!!!";
    }
}
