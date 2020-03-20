package com.example.demo.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/16 11:12
 * @description :
 */

public class ListRemoval {

    /**
     * 遍历后判断赋给另一个List集合，保持原来顺序
     *
     * @param list
     */
    public static void ridRepeat1(List<String> list) {
        System.out.println("list = [" + list + "]");
        List<String> listNew = new ArrayList<String>();
        for (String str : list) {
            if (!listNew.contains(str)) {
                listNew.add(str);
            }
        }
        System.out.println("listNew = [" + listNew + "]");
    }


    /**
     * Set集合去重，保持原来顺序
     *
     * @param list
     */
    public static void ridRepeat2(List<String> list) {
        System.out.println("list = [" + list + "]");
        List<String> listNew = new ArrayList<String>();
        Set set = new HashSet();
        for (String str : list) {
            if (set.add(str)) {
                listNew.add(str);
            }
        }
        System.out.println("listNew = [" + listNew + "]");
    }

    /**
     * Set通过HashSet去重（将ridRepeat3方法缩减为一行） 无序
     *
     * @param list
     */
    public static void ridRepeat3(List<String> list) {
        System.out.println("list = [" + list + "]");
        List<String> listNew = new ArrayList<String>(new HashSet(list));
        System.out.println("listNew = [" + listNew + "]");
    }

    /**
     * 使用java8来使用
     *
     * @param list
     */
    public static void ridRepeat4(List<String> list) {
        List uniqueList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueList.toString());
    }

    public static void main(String[] args) {
        List<String> userList = new ArrayList<String>();
        userList.add("小黄");
        userList.add("小红");
        userList.add("小黄");
        userList.add("小绿");

        ridRepeat1(userList);
        ridRepeat2(userList);
        ridRepeat3(userList);
        ridRepeat4(userList);
    }
}
