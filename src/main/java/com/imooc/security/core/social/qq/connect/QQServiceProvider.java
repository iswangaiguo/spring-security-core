package com.imooc.security.core.social.qq.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

import com.imooc.security.core.social.qq.api.QQ;
import com.imooc.security.core.social.qq.api.QQImpl;
/*
 * AbstractOAuth2ServiceProvider的泛型为API的类型
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ>{

	private String appId;
	
	//URL_AUTHORIZE对应着认证流程的第一步
	private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
	
	//URL_AUTHORIZE对应着认证流程的第四步
	private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";
	
	public QQServiceProvider(String appId, String appSecret) {
		super(new QQAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
		this.appId = appId;
	}

	@Override
	public QQ getApi(String accessToken) {
		return new QQImpl(accessToken, appId);
	}

}
