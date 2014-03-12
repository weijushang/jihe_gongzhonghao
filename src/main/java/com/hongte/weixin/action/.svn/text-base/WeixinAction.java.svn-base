package com.hongte.weixin.action;

import org.apache.log4j.Logger;

import com.hongte.weixin.message.resp.TextMessage;
import com.hongte.weixin.message.util.MessageUtil;

public class WeixinAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(WeixinAction.class);
	
	private  String signature;
	
	private String timestamp;
	
	private String nonce;
	
	private String echostr;

	//--------------------------------------------------Public Methods
	
	public void index(){
		log.info("signature:"+signature+",timestamp:"+timestamp+",nonce:"+nonce+",echostr"+echostr);
		try {
			
//			log.info(MessageUtil.parseXml(getHttpServletRequest()));
			TextMessage msg = new TextMessage();
			msg.setContent("neirong");
			msg.setCreateTime(System.currentTimeMillis());
			msg.setFromUserName("123");
			msg.setFuncFlag(1);
			msg.setMsgType("test");
			msg.setToUserName("toUserName");
			System.out.println(MessageUtil.textMessageToXml(msg));
			print(MessageUtil.textMessageToXml(msg));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
	

	//--------------------------------------------------Private Methods
	
	
}
