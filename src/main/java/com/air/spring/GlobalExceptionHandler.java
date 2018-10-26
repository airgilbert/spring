package com.air.spring;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger log = LoggerFactory.getLogger("GlobalExceptionHandler");
	public static final String DEFAULT_ERROR_VIEW = "/error.html"; // @ExceptionHandler用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("errorname", "统一异常处理页面");
		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());
		log.info("#########################");
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
}
