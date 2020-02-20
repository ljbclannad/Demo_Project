package com.example.demo.rsa;


import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

@Log4j
public class RSASignature {

    /**
     * 签名算法
     */
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    public static final String SIGN_ALGORITHMS_SHA256 = "SHA256WithRSA";

    public static final String SIGN = "sign";

    /**
     * RSA签名
     *
     * @param content    待签名数据
     * @param privateKey 商户私钥
     * @return 签名值
     */
    public static String sign(String content, String privateKey, String encode) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));

            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(encode));

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return null;
    }

    /**
     * @param: [content, privateKey]
     * @return: java.lang.String
     * @description: 私钥签名
     * @author: lejb
     * @date: 2020/1/17 10:30
     */
    public static String sign(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(content.getBytes());
            byte[] signed = signature.sign();
            return Base64.encode(signed);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return null;
    }

    /**
     * RSA验签名检查
     *
     * @param content   待签名数据
     * @param sign      签名值
     * @param publicKey 分配给开发商公钥
     * @param encode    字符集编码
     * @return 布尔值
     */
    public static boolean doCheck(String content, String sign, String publicKey, String encode, String type) {
        log.info("content:" + content);
        log.info("sign:" + sign);
        log.info("publicKey:" + publicKey);
        log.info("encode:" + encode);
        log.info("type:" + type);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(type);
            byte[] encodedKey = Base64.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            log.info("pubKey:" + pubKey);

            Signature signature = Signature
                    .getInstance(SIGN_ALGORITHMS);
            log.info("signature:" + signature);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(encode));

            boolean bverify = signature.verify(Base64.decode(sign));
            log.info("bverify:" + bverify);
            return bverify;

        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return false;
    }

    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            if (SIGN.endsWith(key)) {
                continue;
            }
            String value = sortedParams.get(key);
            if (StringUtils.isNotBlank(sortedParams.get(key))) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }

    /**
     * @param: [content, publicKey]
     * @return: java.lang.String
     * @description: 公钥解密
     * @author: lejb
     * @date: 2020/1/17 10:28
     */
    public static String decrypByPrivKey(String content, String publicKey) {
        try {
            byte[] pubKeyInByte = org.apache.commons.codec.binary.Base64.decodeBase64(publicKey);
            byte[] data = org.apache.commons.codec.binary.Base64.decodeBase64(content.getBytes("UTF-8"));
            KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec pub_spec = new X509EncodedKeySpec(pubKeyInByte);
            PublicKey pubKey = mykeyFactory.generatePublic(pub_spec);
            Cipher cipher = Cipher.getInstance(mykeyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, pubKey);
            return new String(cipher.doFinal(data),"UTF-8");
        } catch (Exception e) {
            return null;
        }
    }
}
