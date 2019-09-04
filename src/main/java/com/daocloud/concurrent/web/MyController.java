package com.daocloud.concurrent.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dushiyu
 * @Date: 2019-09-03 14:42
 * @Version 1.0
 */
@RestController
public class MyController {

    @GetMapping("/test")
    public String get(){
        return "test";
    }
}
