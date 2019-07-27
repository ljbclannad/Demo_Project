package com.example.demo.hashcode;

import com.example.demo.domin.Person;

import java.util.HashMap;

/**
 * @author ：lejb
 * @date ：Created in 2019/7/27 20:08
 * @Description : HashCode与equals测试类
 */

public class HashCodeTest {
    //String默认重写了equals方法

    private static void testHashCode() {
        //(从get和put两方面进行分析)
        //如果两个对象根据equals方法比较是相等的，那么调用这两个对象的任意一个hashcode方法都必须产生相同的结果。
        //对象作为hashMap的value时，不需要重写hashCode
        //HashMap,HashSet,HashTable获取value时通过查找hashCode下对应的区域
        //1.相同的对象，重写了hashCode，没有重写equals:原先hashCode,equals都为true，现在hashCode:false,equals:true,b能找到对应的位置，但返回的不是a的内容，是新的hashCode的内容
        //2.相同的对象，重写了equals,没有重写hashCode,原先hashCode,equals都为true，现在hashCode:true,equals:false，b能找到位置，但找不到a
        //
        // 假设如果有个key为a的元素在HashMap里面的情况：
        //1：b重写了a的hashCode方法如果这时候用equals为true但是hashCode不等的b作为get参数的话，这个时候b算出来的数组下标一定不是a所在的下标位置。
        //2：b重写了a的equals方法，如果这时候用equals为false但是hashCode相等的b作为get参数的话，这个时候b算出来的数组下标是对了，但是用equals来寻找相符的key就找不到a了。
        //所以要保证b和a相同才能找到元素


        Person person = new Person("lejb");
        Person person1 = person;
        System.out.println("第一个对象person的hashCode为：" + person.hashCode());
        System.out.println("第二个对象person1的hashCode为：" + person1.hashCode());
        System.out.println("对象equals比较结果" + person.equals(person1));
        HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put(person, "1");
        System.out.println(map);
        System.out.println(map.get(person1));
    }

    public static void main(String[] args) {
        testHashCode();
    }
}
