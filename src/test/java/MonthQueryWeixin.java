import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;


public class MonthQueryWeixin {

	public static void main(String[] args) {
		List<NameValuePair> request = new ArrayList<NameValuePair>();
		request.add(new BasicNameValuePair("name", "张钦"));
		request.add(new BasicNameValuePair("id_no", "330681198406142353"));
		request.add(new BasicNameValuePair("car_no", "浙D6Q520"));
		HttpRequestSimple httpClient = new HttpRequestSimple();
		String response = httpClient.sendHttpForJson("http://localhost:8080/weixin/monthQuery.htm", request);
		System.out.println(response);
	}
}
