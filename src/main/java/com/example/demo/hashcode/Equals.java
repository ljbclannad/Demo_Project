package com.example.demo.hashcode;

import com.example.demo.domin.Person;

/**
 * @author ：lejb
 * @date ：Created in 2019/7/28 13:46
 * @Description equals和==测试类
 */

public class Equals {

    private static void equalsTest() {
        //测试==满足的条件(判断2个对象是不是相同的对象)\
        //== : 它的作用是判断两个对象的地址是不是相等。即，判断两个对象是不是同一个对象。(基本数据类型==比较的是值，引用数据类型==比较的是内存地址)
        Person person = new Person("lejb");
        Person person1 = new Person("lejb");
        System.out.println(person == person1);
        Person person2 = person;
        System.out.println(person == person2);
        int i = 10;
        int i1 = 10;
        System.out.println(i == i1);

        //equals:类没有覆盖equals()方法。则通过equals()比较该类的两个对象时，等价于通过“==”比较这两个对象。
        //创造了"a"的内存地址,然后将a的地址的内容赋值给s1 ,s和s1都引用了同一个"a",所以2个对象是同一个对象,相等
        String s = "a";
        String s1 = "a";
        System.out.println(s ==s1);
        System.out.println(person.equals(person1));

    }

    public static void main(String[] args) {
        equalsTest();
    }
}
