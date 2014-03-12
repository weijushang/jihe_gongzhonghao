package com.hongte.weixin.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.hongte.weixin.domain.MessageContent;
import com.hongte.weixin.mybatis.domain.AvwFileprocess;
import com.hongte.weixin.mybatis.domain.AvwFileprocessExample;
import com.hongte.weixin.mybatis.domain.AvwXdOther;
import com.hongte.weixin.mybatis.domain.AvwXdOtherExample;
import com.hongte.weixin.mybatis.domain.TCar;
import com.hongte.weixin.mybatis.domain.TCarExample;
import com.hongte.weixin.mybatis.domain.XdDkdetailtobank;
import com.hongte.weixin.mybatis.map.AvwFileprocessMapper;
import com.hongte.weixin.mybatis.map.AvwXdOtherMapper;
import com.hongte.weixin.mybatis.map.TCarMapper;
import com.hongte.weixin.mybatis.map.XdDkdetailtobankMapper;
import com.hongte.weixin.service.IMyCarService;
import com.lianpay.share.utils.FuncUtils;

public class MyCarServiceImpl implements IMyCarService {
	private static Logger log = Logger.getLogger(MyCarServiceImpl.class);

	@Autowired
	private AvwFileprocessMapper avwFileprocessMapper;// 贷款处理视图

	@Autowired
	private TCarMapper tCarMapper;// 汽车信息

	@Autowired
	private AvwXdOtherMapper avwXdOtherMapper;// 还款信息

	@Autowired
	private XdDkdetailtobankMapper xdDkdetailtobankMapper;// 银行信息

	public String monthQuery(String name, String id_no, String car_no) {
		log.info("[月还查询]姓名:" + name + ";身份证:" + id_no + ";车牌:" + car_no);
		if (FuncUtils.isnull(name) || FuncUtils.isnull(id_no) || FuncUtils.isnull(car_no)) {
			return MessageContent.FORMATTER_ERROR;
		}

		AvwFileprocessExample example = new AvwFileprocessExample();
		example.createCriteria().andFcustnameEqualTo(name.trim()).andFidcardEqualTo(id_no.trim())
				.andFmcardnoEqualTo(car_no.trim());
		List<AvwFileprocess> list = avwFileprocessMapper.selectByExample(example);
		if (null != list && list.size() > 0) {
			AvwFileprocess item = list.get(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			String first = "";
			String date = "";
			if (null != item.getFsyday()) {
				first = sdf.format(item.getFsyday());
				date = first.substring(8, first.length());
			}
			return "首期还款:" + first + "；首月还款金额:" + item.getFfmpay() + "元；月还日期:" + date + "；月还金额:" + item.getFmonthpay()
					+ "元";
		} else {
			return MessageContent.CONTENT_NOT_EXIST;
		}

	}

	/**
	 * 贷款余额=放款总额*（1+银行基准利率）-月还*（查询当月-首期放款月）
	 */
	public String balanceQuery(String name, String id_no, String car_no) {
		if (FuncUtils.isnull(name) || FuncUtils.isnull(id_no) || FuncUtils.isnull(car_no)) {
			return MessageContent.FORMATTER_ERROR;
		}
		if (FuncUtils.isnull(name) || FuncUtils.isnull(id_no) || FuncUtils.isnull(car_no)) {
			return MessageContent.FORMATTER_ERROR;
		}
		log.info("[月还查询]姓名:" + name + ";身份证:" + id_no + ";车牌:" + car_no);
		AvwFileprocessExample example = new AvwFileprocessExample();
		example.createCriteria().andFcustnameEqualTo(name.trim()).andFidcardEqualTo(id_no.trim())
				.andFmcardnoEqualTo(car_no.trim());
		List<AvwFileprocess> list = avwFileprocessMapper.selectByExample(example);
		int fid = 0;
		if (null != list && list.size() > 0) {
			AvwFileprocess item = list.get(0);
			fid = item.getFid();
			BigDecimal monthPay = item.getFmonthpay();
			if (null != monthPay) {
				// 获取放款总额
				AvwXdOtherExample otherExample = new AvwXdOtherExample();
				otherExample.createCriteria().andFidEqualTo(fid);
				List<AvwXdOther> otherList = avwXdOtherMapper.selectByExample(otherExample);
				if (null != otherList && otherList.size() > 0) {
					AvwXdOther other = otherList.get(0);
					BigDecimal debitTotal = other.getFfkamt();
					Date first = item.getFsyday();
					if (null != first) {
						long dateLong = getMonth(first, new Date());
						BigDecimal bDateLong = new BigDecimal(dateLong);
						XdDkdetailtobank xdDetailBank = xdDkdetailtobankMapper.selectByPrimaryKey(fid);
						if (null != xdDetailBank) {
							// 贷款余额=放款总额*（1+银行基准利率）-月还*（查询当月-首期放款月）
							if (null != xdDetailBank.getFstandard()) {
								log.info("基准利率："+xdDetailBank.getFstandard());
								BigDecimal stand = xdDetailBank.getFstandard().divide(new BigDecimal(100));
								log.info("贷款余额=" + debitTotal + "*（1+" + stand + "）-" + monthPay + "*（" + bDateLong
										+ "）");
								BigDecimal firstItem = debitTotal.multiply(new BigDecimal(10000)).multiply(stand.add(BigDecimal.ONE));
								BigDecimal secondItem = bDateLong.multiply(monthPay);
								BigDecimal balance = firstItem.subtract(secondItem).setScale(2);
								Calendar now = Calendar.getInstance();
								return "截止" + now.get(Calendar.YEAR) + "年" + (now.get(Calendar.MONTH) + 1) + "月"
										+ now.get(Calendar.DAY_OF_MONTH) + "日，您还需还款的余额约为：" + balance
										+ "元（仅供参考，实际已银行查询为准）";
							}
						}
					}
				}
			}
		}

		return MessageContent.CONTENT_NOT_EXIST;

	}

	public String expireRemind(String name, String id_no, String car_no) {
		if (FuncUtils.isnull(name) || FuncUtils.isnull(id_no) || FuncUtils.isnull(car_no)) {
			return MessageContent.FORMATTER_ERROR;
		}
		log.info("[月还查询]姓名:" + name + ";身份证:" + id_no + ";车牌:" + car_no);
		AvwFileprocessExample example = new AvwFileprocessExample();
		example.createCriteria().andFcustnameEqualTo(name.trim()).andFidcardEqualTo(id_no.trim())
				.andFmcardnoEqualTo(car_no.trim());
		List<AvwFileprocess> list = avwFileprocessMapper.selectByExample(example);
		if (null != list && list.size() > 0) {
			AvwFileprocess item = list.get(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			if(null != item.getFinsuredate1()){
				String findate = sdf.format(item.getFinsuredate1());
				return "车辆车牌号:" + car_no + ";保险到期时间:" + findate + ";";
			}
		} 
		
		return MessageContent.CONTENT_NOT_EXIST;

	}

	public List<TCar> queryParentCar() {
		TCarExample example = new TCarExample();
		example.createCriteria().andFparentidEqualTo(0);
		List<TCar> list = tCarMapper.selectByExample(example);
		if (null != list) {
			log.info(JSONObject.toJSON(list));
			return list;
		}
		return new ArrayList<TCar>();
	}

	public List<TCar> queryCarByParentId(String parentId) {
		TCarExample example = new TCarExample();
		example.createCriteria().andFparentidEqualTo(Integer.parseInt(parentId));
		List<TCar> list = tCarMapper.selectByExample(example);
		if (null != list) {
			log.info(JSONObject.toJSON(list));
			return list;
		}
		return new ArrayList<TCar>();
	}
	
	private  long getMonth(Date startDate, Date endDate) {
		log.info("首期还款日："+startDate+";"+"当前日期："+endDate);
		long monthday;
		// 开始时间与今天相比较
		Date endDate1 = new Date();

		Calendar starCal = Calendar.getInstance();
		starCal.setTime(startDate);

		int sYear = starCal.get(Calendar.YEAR);
		int sMonth = starCal.get(Calendar.MONTH);
		int sDay = starCal.get(Calendar.DATE);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate1);
		int eYear = endCal.get(Calendar.YEAR);
		int eMonth = endCal.get(Calendar.MONTH);
		int eDay = endCal.get(Calendar.DATE);

		monthday = ((eYear - sYear) * 12 + (eMonth - sMonth));

		if (sDay < eDay) {
			monthday = monthday + 1;
		}
		return monthday;
	}

}
