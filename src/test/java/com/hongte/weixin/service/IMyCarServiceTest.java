package com.hongte.weixin.service;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.hongte.weixin.mybatis.domain.XdMnCwsupKey;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class IMyCarServiceTest {
	
	@Autowired
	IMyCarService myCarService;

	@Test
	public void testMonthQuery() {
		String res = myCarService.monthQuery("徐晓云", "330124198909130624", "浙A8EB51");
		System.out.println(res);
	}

	@Test
	public void testBalanceQuery() {
		String res = myCarService.balanceQuery("徐晓云", "330124198909130624", "浙A8EB51");
		System.out.println(res);
	}

	@Test
	public void testSettleOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testExpireRemind() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCar() {
		System.out.println(myCarService.queryParentCar().size());
	}
	
	@Test
	public void testCarByParentId() {
		System.out.println(myCarService.queryCarByParentId("1").size());
	}

	//--------------------------------------------------Instance Variables

	//--------------------------------------------------Public Methods

	//--------------------------------------------------Private Methods
}
