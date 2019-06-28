package com.bolen.ssm.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class FlowLimitInterceptor extends HandlerInterceptorAdapter {

	public FlowLimitInterceptor() {
		super();
		System.out.println("hello world...FlowLimitInterceptor");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		//handler instanceof 
        Method method = handlerMethod.getMethod();
		Class<? extends Object> class1 = handler.getClass();
		Annotation[] annotations = class1.getAnnotations();
		
		return true;
	}
}
