package com.hongte.weixin.mybatis.map;

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
public class XdMnCwsupMapperTest {
	
	@Autowired
	XdMnCwsupMapper xdMnCwsupMapper;

	@Test
	public void testCountByExample() {
	}

	@Test
	public void testDeleteByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		XdMnCwsupKey key = new XdMnCwsupKey();
		key.setFentryid(1);
		key.setFid(52);
		System.out.println(JSONObject.toJSONString(xdMnCwsupMapper.selectByPrimaryKey(key)));
	}

	@Test
	public void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

	//--------------------------------------------------Instance Variables

	//--------------------------------------------------Public Methods

	//--------------------------------------------------Private Methods
}
