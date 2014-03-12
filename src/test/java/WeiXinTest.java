import org.junit.Test;

import com.hongte.weixin.domain.MenuKey;
import com.hongte.weixin.message.req.ClickEventMessage;
import com.hongte.weixin.message.req.TextMessage;
import com.hongte.weixin.message.util.MessageUtil;
import com.lianpay.share.utils.DateUtil;
public class WeiXinTest  extends BaseTest{
	
	public String url = "http://115.29.236.253/weixin/index.htm";

	/**
	 * 
	 */
	public void testMonthQueryClick(){
	}
	
	@Test
	public void testMonthQuery() {
		TextMessage text = new TextMessage();
		text.setContent("01黎明,30010102012,浙A123");
		text.setCreateTime(Long.valueOf(DateUtil.getCurrentDateTimeStr1()));
		text.setFromUserName("微信客户端1");
		text.setToUserName("微信服务账号");
		text.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
		String body = textMessageToXml(text);
		System.out.println(body);
		HttpRequestSimple httpClient = new HttpRequestSimple();
		String response = httpClient.postSendHttp(url, body);
		System.out.println(response);
	}
	
	@Test
	public void testBalanceQuery(){
		TextMessage text = new TextMessage();
		text.setContent("02黎明,30010102012,浙A123");
		text.setCreateTime(Long.valueOf(DateUtil.getCurrentDateTimeStr1()));
		text.setFromUserName("微信客户端1");
		text.setToUserName("微信服务账号");
		text.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
		String body = textMessageToXml(text);
		System.out.println(body);
		HttpRequestSimple httpClient = new HttpRequestSimple();
		String response = httpClient.postSendHttp(url, body);
		System.out.println(response);
	}
	
	/**
	 * 优惠专家
	 */
	@Test
	public void testFavPro(){
		ClickEventMessage message = new ClickEventMessage();
		message.setFromUserName("微信客户端");
		message.setToUserName("微信服务端");
		message.setCreateTime(Long.parseLong(DateUtil.getCurrentDateTimeStr1()));
		message.setMsgType("event");
		message.setEvent("CLICK");
		message.setEventKey(MenuKey.FAVORABLE_PRO.getKey());
		String body = eventMessageToXml(message);
		System.out.println(body);
		HttpRequestSimple httpClient = new HttpRequestSimple();
		String response = httpClient.postSendHttp(url, body);
		System.out.println(response);
	}
	

}
