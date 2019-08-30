package com.example.demo.aes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author ：lejb
 * @date ：Created in 2019/8/6 14:44
 */

public class AESTest {

    public static void main(String[] args) throws Exception{

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("appId","wx1a9bfbb4e9423152");
        jsonObject.put("certNum","421083199502215919");
        jsonObject.put("name","吴晨");
        jsonObject.put("openId","oZTdJszvMXuX2g4-7fXM3whlSzDw");
        jsonObject.put("phone","18069750131");
        System.out.println(AESOperator.encrypt(jsonObject.toJSONString()));
//
        String s = "XnRuWp3CzinkqEvJDifpQpp58qO9dQ7ZU3vMO4IwhAy9hmo tn29FxPN50K oVOXTRORB0eWiNhiy68/NyS5xbBYmDKYvzj0KR8CtFoIy7QpGAtQTLQbVDZP/zVESBEWuUYDkN8FQ1TRXwe4tVu3yY4efUVaUcU051bVe2fZtA1Ku/e oJE6HY1D62YBCFRm";
         String s1 = s.replaceAll(" ","+");
        System.out.println(AESOperator.decrypt(s1));
//        System.out.println(AESOperator.decrypt("XnRuWp3CzinkqEvJDifpQpp58qO9dQ7ZU3vMO4IwhAy9hmotn29FxPN50KoVOXTRORB0eWiNhiy68/NyS5xbBYmDKYvzj0KR8CtFoIy7QpGAtQTLQbVDZP/zVESBEWuUYDkN8FQ1TRXwe4tVu3yY4efUVaUcU051bVe2fZtA1Ku/eoJE6HY1D62YBCFRm"));
    }
}
