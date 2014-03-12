package com.hongte.weixin.service;

import java.util.List;

import com.hongte.weixin.mybatis.domain.TCar;

//我是车主
public interface IMyCarService {

	/**
	 * 月还查询
	 * @param name
	 * @param id_no
	 * @param car_no
	 * @return
	 */
	public String monthQuery(String name,String id_no,String car_no);
	
	/**
	 * 余额查询
	 * @param name
	 * @param id_no
	 * @param car_no
	 * @return
	 */
	public String balanceQuery(String name,String id_no,String car_no);
	
	
	
	/**
	 * 过期提醒
	 * @param name
	 * @param id_no
	 * @param car_no
	 * @return
	 */
	public String expireRemind(String name,String id_no,String car_no);
	
	
	public List<TCar> queryParentCar();
	
	public List<TCar> queryCarByParentId(String parentId);
}
