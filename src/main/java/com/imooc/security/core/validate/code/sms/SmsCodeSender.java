package com.imooc.security.core.validate.code.sms;

import com.imooc.security.core.properties.SecurityProperties;

public interface SmsCodeSender {

	void send(String mobile, String code);

}
