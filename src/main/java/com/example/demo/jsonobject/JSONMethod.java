package com.example.demo.jsonobject;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：lejb
 * @date ：Created in 2019/10/15 16:43
 * @description :
 */

public class JSONMethod {

    private static void getJSONList() {
        JSONObject inBean = new JSONObject();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "lejb");
        map.put("pwd", "123456");
        list.add(map);
        inBean.put("details", list);
        inBean.put("returnCode", "SUCCESS");
        List list1 = inBean.getJSONArray("details");
        System.out.println(((JSONArray) list1).getJSONObject(0).getString("name"));
        System.out.println(list1.size());
    }

    public static void main(String[] args) {
        getJSONList();
    }
}
