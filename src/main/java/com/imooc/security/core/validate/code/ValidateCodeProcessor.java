package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;
/*
 * 	校验码处理器，用来封装不同的校验码的处理逻辑
 */
public interface ValidateCodeProcessor {

	String SESSION_KEY_PROFIEX = "SESSION_KEY_FOR_CODE_";
	
	void create(ServletWebRequest request) throws Exception;
	
	void validate(ServletWebRequest request);
}
