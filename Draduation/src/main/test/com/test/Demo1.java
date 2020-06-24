package com.test;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Demo1 {

    private String test="测试各种加密的字符串";
    @Test
    public void test64() throws IOException {

        //base64加解密需要用到的类
        BASE64Decoder base64Decoder = new BASE64Decoder();
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(test.getBytes());
        System.out.println("base64encode"+encode);
        byte[] bytes = base64Decoder.decodeBuffer(encode);
        System.out.println("base64decode"+new String(bytes));
    }
    @Test
    public void  testmd5() throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(test.getBytes());
        byte[] digest = md5.digest();
        System.out.println("md5加密:  "+new String(digest));
    }
    @Test
    public void  sha() throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("SHA");
        md5.update(test.getBytes());
        byte[] digest = md5.digest();
        System.out.println("SHA加密:  "+new String(digest));
    }
    @Test
    public void testHmac() throws NoSuchAlgorithmException, InvalidKeyException {
        // 生成密钥
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGen.generateKey();
        // HmacMD5算法
        Mac mac = Mac.getInstance(key.getAlgorithm());
        mac.init(key);
        // 加密处理
        byte[] digest = mac.doFinal(test.getBytes());
        System.out.println("hamc加密: "+new String(digest));
    }
    @Test
    public void testbajie() throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(test.getBytes());
        System.out.println();
        System.out.println("base64加密后 "+encode);
        byte[] bytes = base64Decoder.decodeBuffer(encode);
        System.out.println("base64解密后"+new String(bytes));
        if(test.equals(new String(bytes))){
            System.out.println("base64加密前 "+test+" base64解密后"+" 验证正确 加密前=解密后");
        }
    }
    @Test
    public void testmd5jie() throws IOException, NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(test.getBytes());
        byte[] digest = md5.digest();
        String encoder1 = encoder(digest);
        MessageDigest md51 = MessageDigest.getInstance("MD5");
        md51.update(test.getBytes());
        String encoder2=encoder(md51.digest());
        if(encoder1.equals(encoder2)){
            System.out.println("验证成功");
            System.out.println("encoder1: "+encoder1+" encoder2: "+encoder2);

        }
    }
    @Test
    public void testshajie() throws IOException, NoSuchAlgorithmException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA");
        //识别码一
        sha1.update((test).getBytes());
        byte[] digest = sha1.digest();
        System.out.println("SHA加密:  "+encoder(digest));
        MessageDigest sha2 = MessageDigest.getInstance("SHA");
        //识别码一
        sha2.update(test.getBytes());
        byte[] digest2 = sha2.digest();
        String yan1=encoder(digest);
        String yan2=encoder(digest2);
        System.out.println("SHA加密:  "+encoder(digest2));
        if(yan1.equals(yan2)){
            System.out.println("验证成功 识别码1==识别码2");
        }
    }
    @Test
    public void testhmacjie() throws Exception {
        String secretKey = UUID.randomUUID().toString().replaceAll("-", "");;
        // 生成密钥
        String hamc1 = gethMac(secretKey, test);
        String hamc2=gethMac(secretKey,test);

       if(hamc1.equals(hamc2)){
           System.out.println(hamc1);
           System.out.println("根据秘钥验证正确");
       }

    }
    public static String gethMac(String secretKey,String data) throws Exception {
        SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signingKey);
        String hamc = byte2hex(mac.doFinal(data.getBytes()));
        return hamc;
    }
    public static String encoder(byte[] bytes){
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(bytes);
        return encode;
    }
    public static String byte2hex(byte[] b)
    {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }
}
