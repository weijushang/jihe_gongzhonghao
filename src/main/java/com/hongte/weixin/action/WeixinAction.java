package com.hongte.weixin.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.hongte.weixin.domain.FunctionKey;
import com.hongte.weixin.domain.MenuKey;
import com.hongte.weixin.domain.MessageContent;
import com.hongte.weixin.message.resp.TextMessage;
import com.hongte.weixin.message.resp.WeixinServerRes;
import com.hongte.weixin.message.util.Constants;
import com.hongte.weixin.message.util.MessageUtil;
import com.hongte.weixin.message.util.SignUtil;
import com.hongte.weixin.service.IMyCarService;
import com.hongte.weixin.util.SpringConfigUtil;
import com.lianpay.share.utils.DateUtil;
import com.lianpay.share.utils.FuncUtils;

public class WeixinAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1700734662188470428L;

	private static Logger log = Logger.getLogger(WeixinAction.class);

	private String signature;

	private String timestamp;

	private String nonce;

	private String echostr;
	
	@Autowired
	private IMyCarService myCarService;


	// --------------------------------------------------Public Methods

	public void index() {
		log.info("signature:" + signature + ",timestamp:" + timestamp + ",nonce:" + nonce + ",echostr" + echostr);

		String method = getHttpServletRequest().getMethod();

		try {
			boolean isGetMethod = "GET".equalsIgnoreCase(method);
			if (isGetMethod) {
				if(validateWeixin()){
					// 校验
					print(echostr);
				}
				return;
			}

			Map<String, String> reqMap = MessageUtil.parseXml(getHttpServletRequest());
			log.info("客户端请求消息:" + reqMap);
			String msgType = "";
			// 如果是点击事件
			msgType = reqMap.get("MsgType");
			log.info("消息类型:" + msgType);
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				String event = reqMap.get("Event");
				String eventKey = reqMap.get("EventKey");
				// 判断是否是点击事件
				if (event.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// 月查询
					if (eventKey.equals(MenuKey.MONTH_QUERY.getKey())) {
						// Step1：提示输入信息
						TextMessage text = createTextMessageRes(reqMap, MessageContent.MONTH_QUERY_MSG);
						log.info("服务返回消息:" + MessageUtil.textMessageToXml(text));
						print(MessageUtil.textMessageToXml(text));
						return;
					} else if (eventKey.equals(MenuKey.BALANCE_QUERY.getKey())) {
						// Step1：提示输入信息
						TextMessage text = createTextMessageRes(reqMap, MessageContent.BALANCE_QUERY_MSG);
						log.info("服务返回消息:" + MessageUtil.textMessageToXml(text));
						print(MessageUtil.textMessageToXml(text));
						return;
					} else if (eventKey.equals(MenuKey.SETTLE_ORDER.getKey())) {
						// Step1：提示输入信息
						TextMessage text = createTextMessageRes(reqMap, MessageContent.SETTLE_ORDER_MSG);
						log.info("服务返回消息:" + MessageUtil.textMessageToXml(text));
						print(MessageUtil.textMessageToXml(text));
						return;
					} else if (eventKey.equals(MenuKey.EXPIRE_REMIND.getKey())) {
						// Step1：提示输入信息
						TextMessage text = createTextMessageRes(reqMap, MessageContent.EXPIRE_REMIND_MSG);
						log.info("服务返回消息:" + MessageUtil.textMessageToXml(text));
						print(MessageUtil.textMessageToXml(text));
						return;
					} else{
						// 消息格式错误或功能号输入错误
						TextMessage text = createTextMessageRes(reqMap, MessageContent.FORMATTER_ERROR);
						print(MessageUtil.textMessageToXml(text));
						return;
					}
				}
			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				log.info("文本消息处理开始---");
				String message = reqMap.get("Content");
				if (FuncUtils.isnull(message)) {
					TextMessage text = createTextMessageRes(reqMap, MessageContent.MISS_MSG);
					print(MessageUtil.textMessageToXml(text));
					return;
				}
				// 消息如果为01姓名,身份证,车牌号调用月还查询
				String funcKey = "";// 功能号
				String content = "";// 内容
				if (message.length() > 2) {
					funcKey = message.substring(0, 2);
					content = message.substring(2, message.length());

					if (FuncUtils.isnull(content)) {
						// 消息格式错误或功能号输入错误
						TextMessage text = createTextMessageRes(reqMap, MessageContent.FORMATTER_ERROR);
						print(MessageUtil.textMessageToXml(text));
						return;
					}
					String[] contentA = content.split(",|，");
					if (funcKey.equals(FunctionKey.MONTH_QUERY.getKey())) {// 月还查询
						//
						if (contentA.length < 3) {
							// 消息格式错误或功能号输入错误
							TextMessage text = createTextMessageRes(reqMap, MessageContent.FORMATTER_ERROR);
							print(MessageUtil.textMessageToXml(text));
							return;
						}
						String resContent = myCarService.monthQuery(contentA[0], contentA[1], contentA[2]);
						TextMessage text = createTextMessageRes(reqMap, resContent);
						log.info(JSONObject.toJSON(text));
						print(MessageUtil.textMessageToXml(text));
						return;
					} else if (funcKey.equals(FunctionKey.BALANCE_QUERY.getKey())) {// 余额查询
						if (contentA.length < 3) {
							// 消息格式错误或功能号输入错误
							TextMessage text = createTextMessageRes(reqMap, MessageContent.FORMATTER_ERROR);
							print(MessageUtil.textMessageToXml(text));
							return;
						}
						String resContent = myCarService.balanceQuery(contentA[0], contentA[1], contentA[2]);
						TextMessage text = createTextMessageRes(reqMap, resContent);
						log.info(JSONObject.toJSON(text));
						print(MessageUtil.textMessageToXml(text));
						return;
					} else if (funcKey.equals(FunctionKey.EXPIRE_REMIND.getKey())) {// 到期提醒
						if (contentA.length < 3) {
							// 消息格式错误或功能号输入错误
							TextMessage text = createTextMessageRes(reqMap, MessageContent.FORMATTER_ERROR);
							print(MessageUtil.textMessageToXml(text));
							return;
						}
						String resContent = myCarService.expireRemind(contentA[0], contentA[1], contentA[2]);
						TextMessage text = createTextMessageRes(reqMap, resContent);
						log.info(JSONObject.toJSON(text));
						print(MessageUtil.textMessageToXml(text));
						return;
					}
				} else {
					// 消息格式错误或功能号输入错误
					TextMessage text = createTextMessageRes(reqMap, MessageContent.FORMATTER_ERROR);
					print(MessageUtil.textMessageToXml(text));
					return;
				}

			} else {
				// 消息格式错误或功能号输入错误
				TextMessage text = createTextMessageRes(reqMap, MessageContent.SERVICE_NOT_EXIST);
				print(MessageUtil.textMessageToXml(text));
				return;
			}

		} catch (Exception e) {
			log.error("系统错误！");
			e.printStackTrace();
			try {
				print(e.getMessage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private boolean validateWeixin(){
		return SignUtil.checkSignature(signature, timestamp, nonce);
	}

	private TextMessage createTextMessageRes(Map<String, String> reqMap, String content) {
		TextMessage message = new TextMessage();
		message.setToUserName(reqMap.get("FromUserName"));
		message.setFromUserName(reqMap.get("ToUserName"));
		message.setCreateTime(Long.valueOf(DateUtil.getCurrentDateTimeStr1()));
		message.setMsgType("text");
		message.setContent(content);
		return message;
	}

	private String monthQuery(String name, String id_no, String car_no) {
		try{
			List<NameValuePair> request = new ArrayList<NameValuePair>();
			request.add(new BasicNameValuePair("name", name));
			request.add(new BasicNameValuePair("id_no", id_no));
			request.add(new BasicNameValuePair("car_no", car_no));
			String res = httpClient.sendHttpForJson(SpringConfigUtil.getProperties(Constants.WEIXIN_HOST)+SpringConfigUtil.getProperties(Constants.WEIXIN_SERVER_MONTHQUERY), request);
			if(!FuncUtils.isnull(res)){
				WeixinServerRes weixinRes = JSONObject.parseObject(res, WeixinServerRes.class);
				return weixinRes.getContent();
			}
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return MessageContent.ERROR_MSG;
	}

	private String balanceQuery(String name, String id_no, String car_no) {
		try{
			List<NameValuePair> request = new ArrayList<NameValuePair>();
			request.add(new BasicNameValuePair("name", name));
			request.add(new BasicNameValuePair("id_no", id_no));
			request.add(new BasicNameValuePair("car_no", car_no));
			String res = httpClient.sendHttpForJson(SpringConfigUtil.getProperties(Constants.WEIXIN_HOST)+SpringConfigUtil.getProperties(Constants.WEIXIN_SERVER_BALANCEQUERY), request);
			if(!FuncUtils.isnull(res)){
				WeixinServerRes weixinRes = JSONObject.parseObject(res, WeixinServerRes.class);
				return weixinRes.getContent();
			}
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return MessageContent.ERROR_MSG;
	}

	private String expireRemind(String name, String id_no, String car_no) {
		try{
			List<NameValuePair> request = new ArrayList<NameValuePair>();
			request.add(new BasicNameValuePair("name", name));
			request.add(new BasicNameValuePair("id_no", id_no));
			request.add(new BasicNameValuePair("car_no", car_no));
			String res = httpClient.sendHttpForJson(SpringConfigUtil.getProperties(Constants.WEIXIN_HOST)+SpringConfigUtil.getProperties(Constants.WEIXIN_SERVER_EXPIREREMIND), request);
			if(!FuncUtils.isnull(res)){
				WeixinServerRes weixinRes = JSONObject.parseObject(res, WeixinServerRes.class);
				return weixinRes.getContent();
			}
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return MessageContent.ERROR_MSG;
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

	// --------------------------------------------------Private Methods

	public static void main(String[] args) {
		String message = "01杜俊强";
		String key = message.substring(0, 2);
		String content = message.substring(2, message.length());
		System.out.println(key);
		System.out.println(content);
	}
}
