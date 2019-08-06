package com.example.demo.aes;

/**
 * @author ：lejb
 * @date ：Created in 2019/8/6 14:44
 */

public class AESTest {

    public static void main(String[] args) throws Exception{
        System.out.println(AESOperator.encrypt("朱雅萍"));
        System.out.println(AESOperator.decrypt("J0nNrNvnmo1GqstBDpPgZg=="));
    }
}
