package top.sakta.hrmsys.utils;

import java.security.MessageDigest;

/**
 * MD5加密工具类
 * @author sakta
 * @version 1.0
 * @date 2023/12/22
 */

public class Md5Util {
    /**
     * 加密MD5
     * @param data
     * @return
     */
    public static String getMD5(String data)  {
        try {
            java.security.MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception exception) {
        }
        return null;
    }
}
