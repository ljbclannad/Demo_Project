package com.example.demo.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：lejb
 * @date ：Created in 2019/5/5 13:59
 */

public class List1 {

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("1","1");
        Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
        Set<Map.Entry<String, String>> map = hashMap.entrySet();
    }
}
