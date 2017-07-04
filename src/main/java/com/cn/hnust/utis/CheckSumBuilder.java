package com.cn.hnust.utis;

import java.security.MessageDigest;

/**
 * 
*
* 项目名称：springmvcMave
* 类名称：CheckSumBuilder
* 类描述：
* 创建人：zhangjiangnan
* 创建时间：2017-4-28 上午10:24:53
* 修改人：Administrator
* 修改时间：2017-4-28 上午10:24:53
* 修改备注：
*
 */
public class CheckSumBuilder {
	
	/**
	 * 
	* getCheckSum(这里用一句话描述这个方法的作用)
	* @param appSecret(开发者平台分配的AppKey)
	* nonce(随机数,随机数，最大长度128个字符)
	* curTime(当前UTC时间戳)
	* @return String DOM对象
	* @Exception 异常对象
	 */
    public static String getCheckSum(String appSecret, String nonce, String curTime) {
        return encode("sha1", appSecret + nonce + curTime);
    }
    private static String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
}