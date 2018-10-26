package com.air.spring;

import java.util.List;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import com.air.spring.controller.BasicErrorController;

/**
 * --------------------- 作者：夜宿山寺 来源：CSDN
 * 原文：https://blog.csdn.net/king_is_everyone/article/details/53080851
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 * 
 * https://github.com/yandongquan/SpringBootInstance/tree/master/SpringBootException
 * 
 * @author airgilbert
 *
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class })
@AutoConfigureBefore(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(ResourceProperties.class)
public class ConfigSpringboot {
	@Autowired(required = false)
	private List<ErrorViewResolver> errorViewResolvers;
	private final ServerProperties serverProperties;

	public ConfigSpringboot(ServerProperties serverProperties) {
		this.serverProperties = serverProperties;
	}

	@Bean
	public BasicErrorController basicErrorController(ErrorAttributes errorAttributes) {
		return new BasicErrorController(errorAttributes, this.serverProperties.getError(), this.errorViewResolvers);
	}
}
