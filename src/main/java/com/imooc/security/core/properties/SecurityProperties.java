package com.imooc.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {
	
	private BrowserProperities browser = new BrowserProperities();

	private ValidateCodeProperties code = new ValidateCodeProperties();

	private SocialProperties social = new SocialProperties(); 
	
	private MessageProperties message = new MessageProperties();
	

	public MessageProperties getMessage() {
		return message;
	}

	public void setMessage(MessageProperties message) {
		this.message = message;
	}

	public BrowserProperities getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperities browser) {
		this.browser = browser;
	}

	public ValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

	public SocialProperties getSocial() {
		return social;
	}

	public void setSocial(SocialProperties social) {
		this.social = social;
	}
	
}
