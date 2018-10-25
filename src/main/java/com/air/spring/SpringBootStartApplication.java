package com.air.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class SpringBootStartApplication extends SpringBootServletInitializer {
	private Logger log = LoggerFactory.getLogger("SpringBootDemo1Application");
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		 	log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	        // 注意这里要指向原先用main方法执行的Application启动类
	        return builder.sources(SpringBootDemo1Application.class);
	    }
}
