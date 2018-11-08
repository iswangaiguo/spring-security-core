package com.imooc.security.core.validate.code.sms;

import java.io.IOException;

import org.json.JSONException;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.imooc.security.core.properties.SecurityProperties;

public class DefaultSmsCodeSender implements SmsCodeSender{

	private SecurityProperties securityProperties;
	
	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机" + mobile + "发送短信验证码:" + code);
		String expireIn = String.valueOf(securityProperties.getCode().getSms().getExpireIn());
		String[] params = {code, expireIn};
		int appid = securityProperties.getMessage().getApp_id();;
		String appkey = securityProperties.getMessage().getApp_key();
		SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		try {
			SmsSingleSenderResult result = ssender.sendWithParam("86", mobile,
					securityProperties.getMessage().getTemplateId(), 
					params, securityProperties.getMessage().getSign(), "", "");
			System.out.println(result.errMsg);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (HTTPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
	
}
