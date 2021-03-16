package com.dong;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PraticeDailyApplicationTests {

	@Autowired
	List<RequestMappingInfoHandlerMapping> requestMappingInfoHandlerMappings;
	@Test
	void contextLoads() {
	}

	@Test
	public void testHanlder() {
		final Map<RequestMappingInfo, HandlerMethod> handlerMethods = new HashMap<>(32);
		requestMappingInfoHandlerMappings.stream().map(RequestMappingInfoHandlerMapping::getHandlerMethods).forEach(handlerMethods::putAll);
		System.out.println("工程接口数量：" + handlerMethods.size());
	}
}
