package com.hongte.weixin.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hongte.weixin.message.resp.WeixinServerRes;
import com.hongte.weixin.mybatis.domain.TCar;
import com.hongte.weixin.service.IMyCarService;

public class WeixinServerAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2414516384762486149L;
	private String name;
	private String id_no;
	private String car_no;
	private String phone_no;
	private List<TCar> cars; 
	private WeixinServerRes content;
	private String parentId;
	
	@Autowired 
	private IMyCarService myCarService;
	
	public String monthQuery(){
		content = new WeixinServerRes();
		content.setContent(myCarService.monthQuery(name, id_no, car_no));
		return SUCCESS;
	}
	
	public String balanceQuery(){
		content = new WeixinServerRes();
		content.setContent(myCarService.balanceQuery(name, id_no, car_no));
		return SUCCESS;
	}
	
	public String expireRemind(){
		content = new WeixinServerRes();
		content.setContent(myCarService.expireRemind(name, id_no, car_no));
		return SUCCESS;
	}
	
	public String queryParentCar(){
		cars = myCarService.queryParentCar();
		return SUCCESS;
	}
	
	public String queryCarByParent(){
		cars = myCarService.queryCarByParentId(parentId);
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public String getId_no() {
		return id_no;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public IMyCarService getMyCarService() {
		return myCarService;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public void setMyCarService(IMyCarService myCarService) {
		this.myCarService = myCarService;
	}

	public String getCar_no() {
		return car_no;
	}

	public List<TCar> getCars() {
		return cars;
	}

	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}

	public void setCars(List<TCar> cars) {
		this.cars = cars;
	}

	public WeixinServerRes getContent() {
		return content;
	}

	public void setContent(WeixinServerRes content) {
		this.content = content;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
