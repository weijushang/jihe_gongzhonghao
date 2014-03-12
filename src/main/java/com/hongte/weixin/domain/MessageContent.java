package com.hongte.weixin.domain;

public class MessageContent {

	public static final String ERROR_MSG = "系统错误！请重试！";
	
	public static final String MISS_MSG= "输入的信息为空！请重试！";
	
	public static final String FORMATTER_ERROR = "消息格式错误或功能编号错误！请重试！";
	
	public static final String MONTH_QUERY_MSG = "使用月还查询需要输入信息格式如下:"+MenuKey.MONTH_QUERY.getKey()+"姓名，身份证号，车牌号";
	
	public static final String BALANCE_QUERY_MSG = "使用余额查询需要输入信息格式如下:"+MenuKey.BALANCE_QUERY.getKey()+"姓名，身份证号，车牌号";
	
	public static final String SETTLE_ORDER_MSG = "使用结清预约需要输入信息格式如下:"+MenuKey.SETTLE_ORDER.getKey()+"姓名，手机号";
	
	public static final String EXPIRE_REMIND_MSG = "使用到期提醒需要输入信息格式如下:"+MenuKey.EXPIRE_REMIND.getKey()+"姓名，身份证号，车牌号";
	
	public static final String SERVICE_NOT_EXIST="您请求的服务不存在噢,请尝试其他服务吧！";
	
	public static final String CONTENT_NOT_EXIST="您请求的数据不存在噢,请输入正确的信息进行查询！";
}
