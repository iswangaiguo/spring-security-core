package com.imooc.security.core.social.qq.api;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QQImpl extends AbstractOAuth2ApiBinding implements QQ{
	
	Logger logger = LoggerFactory.getLogger(getClass());
   
	private  static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

	private  static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private String appId;
	
	private String openId;
	
	public QQImpl(String accessToken, String appId) {
//		super调用父类构造函数的时候会将accessToken自动放到请求头中而不是以参数的形式放在url后面
//		而qq要求的格式是以参数的形式放在url后面所以指定另一个参数TokenStrategy.ACCESS_TOKEN_PARAMETER的意思就是将
//		Indicates that the access token should be carried as a query parameter named "access_token".
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
		this.appId = appId;
		
		String url = String.format(URL_GET_OPENID, accessToken);
		//RestTemplate是向服务提供商发送获取用户信息
		String result = getRestTemplate().getForObject(url, String.class);
		System.out.println(result);
		
		this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
	}

	@Override
	public QQUserInfo getUserInfo() {
		
		String url = String.format(URL_GET_USERINFO, appId, openId);
		
		String result = getRestTemplate().getForObject(url, String.class);
		
		logger.info(result);
		QQUserInfo userInfo = null;
		try {
			userInfo = objectMapper.readValue(result, QQUserInfo.class);
			userInfo.setOpenId(openId);
			return userInfo;
		} catch (Exception e) {
			throw new RuntimeException("获取用户信息失败", e);
		}
	}
 
}
