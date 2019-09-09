package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;

/**
 * @Author LiYuanMing
 * @Date 2019/6/9 19:47
 */
public class CommonUtil {
    /**
     * * 转换一个xml格式的字符串到json格式
     * *
     * * @param xml
     * *            xml格式的字符串
     * * @return 成功返回json 格式的字符串;失败反回null
     */
    @SuppressWarnings("unchecked")
    public static JSONObject xml2JSON(String xml) {
        JSONObject obj = new JSONObject();
        try {
            Document doc = DocumentHelper.parseText(xml);
            Element root = doc.getRootElement();
            obj.put(root.getName(), iterateElement(root));
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 迭代
     *
     * @param element
     * @return java.util.Map 实例
     */
    @SuppressWarnings("unchecked")
    private static Map iterateElement(Element element) {
        List jiedian = element.elements();
        Element et = null;
        Map obj = new HashMap();
        Object temp;
        List list = null;
        for (int i = 0; i < jiedian.size(); i++) {
            list = new LinkedList();
            et = (Element) jiedian.get(i);
            if (et.getTextTrim().equals("")) {
                if (et.elements().size() == 0)
                    continue;
                if (obj.containsKey(et.getName())) {
                    temp = obj.get(et.getName());
                    if (temp instanceof List) {
                        list = (List) temp;
                        list.add(iterateElement(et));
                    } else if (temp instanceof Map) {
                        list.add((HashMap) temp);
                        list.add(iterateElement(et));
                    } else {
                        list.add((String) temp);
                        list.add(iterateElement(et));
                    }
                    obj.put(et.getName(), list);
                } else {
                    obj.put(et.getName(), iterateElement(et));
                }
            } else {
                if (obj.containsKey(et.getName())) {
                    temp = obj.get(et.getName());
                    if (temp instanceof List) {
                        list = (List) temp;
                        list.add(et.getTextTrim());
                    } else if (temp instanceof Map) {
                        list.add((HashMap) temp);
                        list.add(iterateElement(et));
                    } else {
                        list.add((String) temp);
                        list.add(et.getTextTrim());
                    }
                    obj.put(et.getName(), list);
                } else {
                    obj.put(et.getName(), et.getTextTrim());
                }

            }

        }
        return obj;
    }

    /**
     * 返回长度为【strLength】的随机数，在前面补0
     *
     * @param strLength
     * @return
     */
    public static String getFixLenthString(int strLength) {
        Random rm = new Random();

        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);

        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);

        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1);
    }
}
