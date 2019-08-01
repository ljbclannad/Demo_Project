package com.example.demo.csv;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lejb
 * @date ：Created in 2019/8/1 14:19
 * @Description :Xml导出测试类
 */
@Slf4j
public class XmlTest {

    public static void main(String[] args) throws Exception{
        List<JSONObject> xmlList = new ArrayList<JSONObject>();

        JSONObject row1 = new JSONObject();
        row1.put("Number1","1");
        row1.put("Number2","2");
        row1.put("Number3","3");
        row1.put("Number4","4");
        row1.put("Number5","5");

        xmlList.add(row1);

        WriteXml.createXML(xmlList);
    }
}
