package com.example.demo;

import com.example.demo.domin.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lejb
 * @date ：Created in 2019/5/13 9:16
 * @Description 阿里云个人认证结果参数
 */

public class IdCardValidateTest {

    private static String host = "http://naidcard.market.alicloudapi.com";

    private static String path = "/nidCard";

    private static String method = "GET";

//    APPCODE e8e8da3139d248a499fe68cd1d0c52f9

    public static void main(String[] args) throws Exception {
        Map<String,String> headers = new HashMap<>();
        Map<String,String> querys = new HashMap<>();
        headers.put("Authorization","APPCODE e8e8da3139d248a499fe68cd1d0c52f9");
        querys.put("idCard","330206199606043133");
        querys.put("name","乐锦波");
        HttpResponse response = HttpUtils.doGet(host,path,method,headers,querys);
//        String result = EntityUtils.toString(response.getEntity());
//        System.out.println("返回结果为:"+result);

        System.out.println(response.getStatusLine());

        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null){
            stringBuffer.append(line);
        }
        System.out.println("返回结果内容为:"+stringBuffer);
        in.close();

    }
}
