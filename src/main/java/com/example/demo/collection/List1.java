package com.example.demo.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：lejb
 * @date ：Created in 2019-07-29 10:26:25
 */

public class List1 {

    /**
     * 测试LinkedList和ArrayList的操作时间复杂度
     */
    private static void listTest() {
        String[] strings = {"1", "2", "3", "4","5","6","7","8","9","10"};
        List<String> list = Arrays.asList(strings);

        //测试ArrayList
        ArrayList<String> arrayList = new ArrayList<>(list);
        long time1 = System.currentTimeMillis();
        System.out.println("当前时间戳为:" + time1 + "当前时间为:" + new Date());
        arrayList.add(2, "5");
        long time2 = System.currentTimeMillis();
        System.out.println("当前时间戳为:" + time2 + "当前时间为:" + new Date());
        arrayList.remove(2);
        long time3 = System.currentTimeMillis();
        System.out.println("当前时间戳为:" + time3 + "当前时间为:" + new Date());
        arrayList.get(6);
        long time4 = System.currentTimeMillis();
        System.out.println("\nArrayList添加元素的耗时为:" + (time2 - time1));
        System.out.println("ArrayList删除元素的耗时为:" + (time3 - time2));
        System.out.println("ArrayList遍历元素的耗时为:" + (time4 - time3));

        //测试LinkedList
        LinkedList<String> linkedList = new LinkedList<>(list);
        long time5 = System.currentTimeMillis();
        System.out.println("当前时间戳为:" + time5 + "当前时间为:" + new Date());
        linkedList.add(2, "5");
        long time6 = System.currentTimeMillis();
        System.out.println("当前时间戳为:" + time6 + "当前时间为:" + new Date());
        linkedList.remove(2);
        long time7 = System.currentTimeMillis();
        System.out.println("当前时间戳为:" + time7 + "当前时间为:" + new Date());
        linkedList.forEach(System.out::print);
        linkedList.get(6);
        long time8 = System.currentTimeMillis();
        System.out.println("\nLinkedList添加元素的耗时为:" + (time6 - time5));
        System.out.println("LinkedList删除元素的耗时为:" + (time7 - time6));
        System.out.println("LinkedList遍历元素的耗时为:" + (time8 - time7));
    }

    public static void main(String[] args) {
        //ArrayList适合查找操作,LinkedList适合添加和删除操作(链表查找操作会进行遍历)
        listTest();
    }
}
