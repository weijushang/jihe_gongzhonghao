package com.hongte.weixin.message.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hongte.weixin.domain.AccessToken;
import com.hongte.weixin.domain.Button;
import com.hongte.weixin.domain.CommonButton;
import com.hongte.weixin.domain.ComplexButton;
import com.hongte.weixin.domain.Menu;
import com.hongte.weixin.domain.MenuKey;

/**
 * 菜单管理器类
 * 
 * @author dujq
 */
public class MenuManager {
	
	private static Logger log =Logger.getLogger(MenuManager.class);
	
	private static final String MICROWEB_HOST = "http://115.29.236.253";
	
	private static final String MICROWEB_FAQ_URL=MICROWEB_HOST+"/TinyCar/car/faq.htm";
			
	private static final String MICROWEB_ONLINEORDER_URL=MICROWEB_HOST+"/TinyCar/car/order.htm";
	
	private static final String MICROWEB_SITE_URL =MICROWEB_HOST+"/TinyCar/";
	
	private static final String MICROWEB_FAV_PRO=MICROWEB_HOST+"/TinyCar/car/favorable.htm";//优惠专家

	private static final String MICROWEB_DEBIT_PRO = MICROWEB_HOST+"/TinyCar/car/product.htm";
	
	private static final String MICROWEB_SETTLE_ORDER = MICROWEB_HOST+"/TinyCar/car/settle.htm";
	
	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wx805f3de9dde020cf";
		// 第三方用户唯一凭证密钥
		String appSecret = "8c38315948b1a5d9f88641029181c7ca";

		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());

			// 判断菜单创建结果
			if (0 == result)
				log.info("菜单创建成功！");
			else
				log.info("菜单创建失败，错误码：" + result);
		}
//		System.out.println(JSONObject.toJSONString(getMenu()));
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		CommonButton monthQuery = new CommonButton();
		monthQuery.setName("月还查询");
		monthQuery.setType("click");
		monthQuery.setKey(MenuKey.MONTH_QUERY.getKey());

		CommonButton balanceQuery = new CommonButton();
		balanceQuery.setName("余额查询");
		balanceQuery.setType("click");
		balanceQuery.setKey(MenuKey.BALANCE_QUERY.getKey());

		CommonButton settleOrder = new CommonButton();
		settleOrder.setName("结清预约");
		settleOrder.setType("view");
		settleOrder.setUrl(MICROWEB_SETTLE_ORDER);

		CommonButton expireRemind = new CommonButton();
		expireRemind.setName("保险到期提醒");
		expireRemind.setType("click");
		expireRemind.setKey(MenuKey.EXPIRE_REMIND.getKey());

		CommonButton faq = new CommonButton();
		faq.setName("汽车金融小百科");
		faq.setType("view");
		faq.setUrl(MICROWEB_FAQ_URL);

		CommonButton wantbuy = new CommonButton();
		wantbuy.setName("优惠专家");
		wantbuy.setType("view");
		wantbuy.setUrl(MICROWEB_FAV_PRO);


		CommonButton debitpro = new CommonButton();
		debitpro.setName("贷款专家");
		debitpro.setType("view");
		debitpro.setUrl(MICROWEB_DEBIT_PRO);

		CommonButton onlineOrder = new CommonButton();
		onlineOrder.setName("在线申请");
		onlineOrder.setType("view");
		onlineOrder.setUrl(MICROWEB_ONLINEORDER_URL);

		CommonButton mircowebsite = new CommonButton();
		mircowebsite.setName("微网站");
		mircowebsite.setType("view");
		mircowebsite.setUrl(MICROWEB_SITE_URL);


		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("我是车主");
		mainBtn1.setSub_button(new CommonButton[] { monthQuery, balanceQuery, settleOrder, expireRemind, faq});

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("抢优惠");
		mainBtn2.setSub_button(new CommonButton[] { wantbuy, onlineOrder});

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("微网站");
		mainBtn3.setSub_button(new CommonButton[] { mircowebsite });

		/**
		 * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br>
		 * 
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		List<Button> mainList = new ArrayList<Button>();
		mainList.add(mainBtn1);
		mainList.add(mainBtn2);
		mainList.add(mainBtn3);
		menu.setButton(mainList);
		return menu;
	}
}