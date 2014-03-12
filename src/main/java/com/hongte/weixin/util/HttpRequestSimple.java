package com.hongte.weixin.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

import com.lianpay.share.http.HttpClientFactory;

public class HttpRequestSimple {
	private static Log log = LogFactory.getLog(HttpRequestSimple.class);
	
	
	public String sendHttpForJson(String url,List<NameValuePair> request){

		if (url == null || "".equals(url)) {
			log.error("request url is empty.");
			return null;
		}
		log.info("请求地址:"+url);
		HttpClient httpClient = HttpClientFactory.getThreadSafeHttpClient();
		HttpUriRequest httpRequest;
		try {
			httpRequest = postRequest(url,request);
			return sendRequest(httpClient, httpRequest);
		} catch (UnsupportedEncodingException e) {
			log.error("远程调用异常!");
			e.printStackTrace();
		}
		return null;
	}
	
	private HttpUriRequest postRequest(String url, List<NameValuePair> request) throws UnsupportedEncodingException
	{
		HttpPost post = new HttpPost(url);
		post.setHeader("Accept", "text/json");
		post.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		UrlEncodedFormEntity formEntity = null;
		formEntity = new UrlEncodedFormEntity(request, "utf-8");
		post.setEntity(formEntity);
		return post;
	}

	private String sendRequest(HttpClient httpClient, HttpUriRequest request) {
		try{
			HttpResponse resp;
			resp = httpClient.execute(request);
			if (null == resp) {
				return null;
			}
			int ret = resp.getStatusLine().getStatusCode();
			log.info("HTTP状态码:" + ret);
			// 响应分析
			HttpEntity entity = resp.getEntity();
			BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
			StringBuffer responseString = new StringBuffer();
			String result = br.readLine();
			while (result != null) {
				responseString.append(result);
				result = br.readLine();
			}
			return responseString.toString();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null != request){
				log.info("释放链接！");
				request.abort();
			}
		}
		
		return null;
	}


}
