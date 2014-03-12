package com.hongte.weixin.service;

import java.util.Map;

import com.hongte.weixin.message.resp.NewsMessage;

/**
 * 抢优惠
 * @author dujq
 *
 */
public interface IFavorableService {

	/**
	 * 车优惠
	 * @return
	 */
	public NewsMessage carFavor(Map<String, String> reqMap);
	
}
