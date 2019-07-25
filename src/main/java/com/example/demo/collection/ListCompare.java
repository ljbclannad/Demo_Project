package com.example.demo.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author ：lejb
 * @date ：Created in 2019/6/25 17:05
 */
@Slf4j
public class ListCompare {

    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("createTime","2019-06-30");
        map1.put("count","1");
        Map<String,Object> map = new HashMap<>();
        map.put("createTime","2019-06-19");
        map.put("count","0");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("createTime","2019-06-21");
        map3.put("count","2");
        list.add(map3);
        list.add(map1);
        list.add(map);

        list.sort( (Map<String,Object> a, Map<String,Object> b) ->
               a.get("createTime").toString().compareTo(b.get("createTime").toString())
        );


//        list.sort((map4,map5)->
//             - map4.get("createTime").toString().compareTo(map5.get("createTime").toString())
//        );

//        /**
//         * 按照时间倒序排序
//         */
//        Collections.sort(list, new Comparator<Map<String,Object>>() {
//            @Override
//            public int compare(Map<String,Object> o1, Map<String,Object> o2) {
//                String o1Time = o1.get("createTime").toString();
//                String o2Time = o2.get("createTime").toString();
//                int compare = o1Time.compareTo(o2Time);
//                return -compare;
//            }
//        });

//        List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
//        list1.addAll(list);
        list.stream().forEach(System.out::println);
    }

}
