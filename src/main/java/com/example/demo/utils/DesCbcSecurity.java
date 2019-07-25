package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * DES CBC 加密、解密算法
 *
 */
public class DesCbcSecurity {
 
    public static final String SECRET_DES    = "DES";
    public static final String ALGORITHM_DES = "DES/CBC/NoPadding";
 
    
    public static String strTo16(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }
    
    public static final String bytesToHexString(byte[] bArray) {
    	  StringBuffer sb = new StringBuffer(bArray.length);
    	  String sTemp;
    	  for (int i = 0; i < bArray.length; i++) {
    	   sTemp = Integer.toHexString(0xFF & bArray[i]);
    	   if (sTemp.length() < 2)
    	    sb.append(0);
    	   sb.append(sTemp.toUpperCase());
    	  }
    	  return sb.toString();
    	 }
    /**
     * 16进制转换成为string类型字符串
     * @param s
     * @return
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }
    
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }
    public static byte[] DESUT(String context,String key) {
        String request = null;
        String result = "";
        String qqq = strTo16(context);
        System.out.println("明文转16进制"+qqq);
        if(qqq.length() %16 !=0) {
    		System.out.println("!11");
    		int templen = qqq.length()/16 *16 +16;
    		System.out.println(templen);
    		request = qqq;
    		System.out.println(request);
    		String xx= "0";
    		int yy = request.length();
    		while(yy<(templen-1) ) {
    			xx = xx+"0"; 
    			System.out.println("xx"+xx);
    			yy+=1;
    		}
    		request = qqq+xx;
    		System.out.println("填补之后的16jinzhi"+request);
    		System.out.println("填补后的长度"+request.length());
    		request = hexStringToString(request);
//    		System.out.println("转换成明文"+hexStringToString(request));
    	}else {
    		request = context;
    	}
       byte[] aaa= new byte[0];
		for(int i = 0;i<request.length();i=i+8) {
        	String text = request.substring(i, i+8);
        	System.out.println("加密前：" + text);
            byte[] encrypedString = encrypt(text, key);
            aaa = byteMerger(aaa, encrypedString);
            System.out.println(new String(aaa));
        }
        System.out.println("加密后的长度:"+aaa.length);
        return aaa;
    }
    
    public static String Encry(byte[] context,String key) throws Exception {
    	byte[] reclData = null;
		byte[] data= new byte[0];
		for(int i = 0;i<context.length;i=i+8) {
			byte[] a = new byte[8];
			System.arraycopy(context, i, a, 0, 8);
			reclData = DesCbcSecurity.decrypt(a, key);
			data = byteMerger(data, reclData);
		}
		String resData = new String(data, "gbk");
		String resString = StringUtils.substringAfter(resData, "?>");
		resString = StringUtils.substringBeforeLast(resData, ">");
		resString = resString+">";
		return resString;
    	
    }
    
	public static byte[] byteMerger(byte[] byte_1, byte[] byte_2){  
        byte[] byte_3 = new byte[byte_1.length+byte_2.length];  
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);  
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);  
        return byte_3;  
    }
    
    
/**
     * 加密
     * @author xiaoliang.chen
     * 2017年12月16日 下午12:59:28
     * @param content
     * @param key
     * @return
     */
    public static byte[] encrypt(String content, String key) {
        return encrypt(content.getBytes(), key.getBytes());
    }
 
    public static byte[] encrypt(byte[] content, byte[] keyBytes) {
        try {
            DESKeySpec keySpec = new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SECRET_DES);
            SecretKey key = keyFactory.generateSecret(keySpec);
 
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(new byte[8]));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 解密
     * @author xiaoliang.chen
     * 2017年12月16日 下午1:01:01
     * @param content
     * @param key
     * @return
     */
    public static byte[] decrypt(byte[] content, String key) {
//        byte[] contentBytes = hexStringToBytes(content);
        return decrypt(content, key.getBytes());
    }
     
    public static byte[] decrypt(byte[] content, byte[] keyBytes) {
        try {
            DESKeySpec keySpec = new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SECRET_DES);
            SecretKey key = keyFactory.generateSecret(keySpec);
 
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(new byte[8]));
            byte[] result = cipher.doFinal(content);
            String contentString = new String(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    public static String byteToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length);
        String sTemp;
        for (int i = 0; i < bytes.length; i++) {
            sTemp = Integer.toHexString(0xFF & bytes[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
     
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
 
        }
        return d;
    }
 
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}