package com.hongte.weixin.domain;

public enum FunctionKey {
	
	//我是车主
	MONTH_QUERY("01","月还查询"),//月还查询
	BALANCE_QUERY("02","余额查询"),//余额查询
	EXPIRE_REMIND("03","保险到期提醒"),//保险到期提醒
	SETTLE_ORDER("04","结清预约"),//结清预约
	FAQ_QUERY("05","汽车金融小百科"),//汽车金融小百科
	//抢优惠
	FAVORABLE_PRO("11","优惠专家"),//优惠专家
	DEBIT_PRO("12","贷款专家"),//贷款专家
	APPLY_ONLINE("13","在线申请");//在线申请
	
	
	private String key;
	
	private String name;

	private FunctionKey(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
