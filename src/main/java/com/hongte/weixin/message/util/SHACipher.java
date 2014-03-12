package com.hongte.weixin.message.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * SHA加密算法实现
 * @author dujq
 */
public class SHACipher {

	private static Logger logger = Logger.getLogger(SHACipher.class);
	
	private static final String ENCODE = "UTF-8";
	private static final String ALGORITHM = "SHA-1"; //算法
	private static MessageDigest sha1MD;
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static SHACipher instance;
	
	private SHACipher(){
		try {
			sha1MD = MessageDigest.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			logger.error("构造MessageDigest实例异常,"+e.getMessage());
		}
	}
	
	public static SHACipher getInstance(){
		if(null == instance)
			instance = new SHACipher();
		return instance;
	}
	
	/**
	 * SHA加密实现
	 * @param source
	 * @return
	 */
	public String digest(String source) {
		if(null == sha1MD){
			return "";
		}
		try {
			byte [] bSour = source.getBytes(ENCODE);
			sha1MD.update(bSour, 0, bSour.length);
		} catch (UnsupportedEncodingException e) {
			logger.error("SHA加密,不支持的编码格式异常,使用系统默认编码格式处理"+e.getMessage());
			sha1MD.update(source.getBytes(), 0, source.length());
		}
		return byteArrayToHexString(sha1MD.digest());
	}

	/**
	 * 转换字节数组为16进制字串
	 * @param b 字节数组
	 * @return 16进制字串
	 */
	private String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * 转换字节数组为高位字符串
	 * @param b 字节数组
	 * @return
	 */
	private String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}
