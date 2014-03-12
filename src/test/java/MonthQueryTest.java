import com.hongte.weixin.message.req.TextMessage;
import com.hongte.weixin.message.util.MessageUtil;
import com.lianpay.share.utils.DateUtil;


public class MonthQueryTest extends BaseTest{
	String url = "http://localhost:8080/weixin";
	public static void main(String[] args) {
		TextMessage text = new TextMessage();
		text.setContent("01张钦,330681198406142353,浙D6Q520");
		text.setCreateTime(Long.valueOf(DateUtil.getCurrentDateTimeStr1()));
		text.setFromUserName("微信客户端1");
		text.setToUserName("微信服务账号");
		text.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
		String body = textMessageToXml(text);
		System.out.println(body);
		HttpRequestSimple httpClient = new HttpRequestSimple();
		String response = httpClient.postSendHttp("http://localhost:8080/weixin/index.htm", body);
		System.out.println(response);
	}
}	
