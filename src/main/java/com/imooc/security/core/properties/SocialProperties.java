package com.imooc.security.core.properties;

public class SocialProperties {
	
	private String filterProcessUrl = "/auth";
	
	private QQProperities qq = new QQProperities();
	
	private WeixinProperties weixin = new WeixinProperties(); 
	
	public String getFilterProcessUrl() {
		return filterProcessUrl;
	}

	public void setFilterProcessUrl(String filterProcessUrl) {
		this.filterProcessUrl = filterProcessUrl;
	}

	public QQProperities getQq() {
		return qq;
	}

	public void setQq(QQProperities qq) {
		this.qq = qq;
	}

	public WeixinProperties getWeixin() {
		return weixin;
	}

	public void setWeixin(WeixinProperties weixin) {
		this.weixin = weixin;
	}
}
