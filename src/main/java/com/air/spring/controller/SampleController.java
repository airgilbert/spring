package com.air.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleController {
	private Logger log = LoggerFactory.getLogger("SampleController");
    @RequestMapping("/index")
    Object home() {
    	log.info("Hello World!,123你好");
        return "Hello World!,123你好"; 
    }
}
