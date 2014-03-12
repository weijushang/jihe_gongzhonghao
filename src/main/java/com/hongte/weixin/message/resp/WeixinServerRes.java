package com.hongte.weixin.message.resp;

import java.io.Serializable;

public class WeixinServerRes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -906886995510190831L;
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
