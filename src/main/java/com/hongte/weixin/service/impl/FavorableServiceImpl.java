package com.hongte.weixin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.hongte.weixin.message.resp.Article;
import com.hongte.weixin.message.resp.NewsMessage;
import com.hongte.weixin.message.util.MessageUtil;
import com.hongte.weixin.service.IFavorableService;
import com.lianpay.share.utils.DateUtil;

public class FavorableServiceImpl implements IFavorableService{
	private static Logger log = Logger.getLogger(FavorableServiceImpl.class);
	
	private static int pageSize = 5;
	
	public NewsMessage carFavor(Map<String, String> reqMap) {
		log.info("[优惠专家]");
		NewsMessage news = new NewsMessage();
		news.setFromUserName(reqMap.get("ToUserName"));
		news.setToUserName(reqMap.get("FromUserName"));
		news.setCreateTime(Long.parseLong(DateUtil.getCurrentDateTimeStr1()));
		news.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		news.setArticleCount(pageSize);
		List<Article> articles = new ArrayList<Article>();
		Article a = new Article();
		a.setTitle("润华雷克萨斯");
		a.setDescription("济南润华雷克萨斯RX270精英版优惠3万");
		a.setPicUrl("http://car0.autoimg.cn/upload/spec/12437/s_201205291533367034136.jpg");
		a.setUrl("http://car0.autoimg.cn/upload/spec/12437/s_201205291533367034136.jpg");
		Article b = new Article();
		b.setTitle("河南中宇进口大众");
		b.setDescription("河南进口大众优惠");
		b.setPicUrl("http://car0.autoimg.cn/upload/spec/12437/s_201205291533367034136.jpg");
		b.setUrl("http://car0.autoimg.cn/upload/spec/12437/s_201205291533367034136.jpg");
		Article c = new Article();
		c.setTitle("润华雷克萨斯2");
		c.setDescription("济南润华雷克萨斯RX270精英版优惠3万");
		c.setPicUrl("http://car0.autoimg.cn/upload/spec/12437/s_201205291533367034136.jpg");
		c.setUrl("http://car0.autoimg.cn/upload/spec/12437/s_201205291533367034136.jpg");
		Article d = new Article();
		d.setTitle("润华雷克萨斯3");
		d.setDescription("济南润华雷克萨斯RX270精英版优惠3万");
		d.setPicUrl("http://car0.autoimg.cn/upload/spec/12437/s_201205291533367034136.jpg");
		d.setUrl("http://car0.autoimg.cn/upload/spec/12437/s_201205291533367034136.jpg");
		Article e = new Article();
		e.setTitle("润华雷克萨斯4");
		e.setDescription("济南润华雷克萨斯RX270精英版优惠3万");
		e.setPicUrl("http://car0.autoimg.cn/upload/spec/12437/s_201205291533367034136.jpg");
		e.setUrl("http://car0.autoimg.cn/upload/spec/12437/s_201205291533367034136.jpg");
		articles.add(a);
		articles.add(b);
		articles.add(c);
		articles.add(d);
		articles.add(e);
		news.setArticles(articles);
		return news;
	}

}
