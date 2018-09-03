package com.kz.kzsys.core.common;



import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 
 * @Title: Const.java
 * @Package com.kz.core.common
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 凯舟.陈超
 * @date 2017年12月29日 上午10:45:44
 * @version V1.0
 */
public class Const {

	public static final String CURRENT_USER = "currentUser";

	public static final String IDCARD = "idcard";
	public static final String USERNAME = "username";

	public interface ProductListOrderBy {
		Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
	}

	public interface Cart {
		int CHECKED = 1;// 即购物车选中状态
		int UN_CHECKED = 0;// 购物车中未选中状态

		String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
		String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
	}
	public interface UserTYPE {
		int TYPE_CUSTOMER = 0; // 普通用户
		int TYPE_ADMIN = 1;// 管理员
	}

	public enum UniversityStatusEnum {
		PUBLISH(1, "已发布"),UN_PUBLISH(2,"未发布");
		private String value;
		private int code;

		UniversityStatusEnum(int code, String value) {
			this.code = code;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public int getCode() {
			return code;
		}
	}

	public enum OrderStatusEnum {
		CANCELED(0, "已取消"), NO_PAY(10, "未支付"), PAID(20, "已付款"), SHIPPED(40, "订单完成"), ORDER_SUCCESS(50,
				"订单关闭");
		OrderStatusEnum(int code, String value) {
			this.code = code;
			this.value = value;
		}
		private String value;
		private int code;

		public String getValue() {
			return value;
		}

		public int getCode() {
			return code;
		}

		public static OrderStatusEnum codeOf(int code) {
			for (OrderStatusEnum orderStatusEnum : values()) {
				if (orderStatusEnum.getCode() == code) {
					return orderStatusEnum;
				}
			}
			throw new RuntimeException("么有找到对应的枚举");
		}
	}

	public interface AlipayCallback {
		String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
		String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

		String RESPONSE_SUCCESS = "success";
		String RESPONSE_FAILED = "failed";
	}

	public enum PayPlatformEnum {
		ALIPAY(1, "支付宝");

		PayPlatformEnum(int code, String value) {
			this.code = code;
			this.value = value;
		}

		private String value;
		private int code;

		public String getValue() {
			return value;
		}

		public int getCode() {
			return code;
		}
	}

	public enum PaymentTypeEnum {
		ONLINE_PAY(1, "在线支付");

		PaymentTypeEnum(int code, String value) {
			this.code = code;
			this.value = value;
		}

		private String value;
		private int code;

		public String getValue() {
			return value;
		}

		public int getCode() {
			return code;
		}

		public static PaymentTypeEnum codeOf(int code) {
			for (PaymentTypeEnum paymentTypeEnum : values()) {
				if (paymentTypeEnum.getCode() == code) {
					return paymentTypeEnum;
				}
			}
			throw new RuntimeException("么有找到对应的枚举");
		}

	}

}
