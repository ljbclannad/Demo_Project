package com.example.demo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author ：lejb
 * @date ：Created in 2019/7/23 17:43
 * @Description lambada Stream接口
 */

public class Stream {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");

        //测试过滤
//        stringList.stream().filter(s -> s.startsWith("a"))
//                .forEach(System.out::println);

        //测试排序
        //Collection.stream()方法利用创建的stream对象进行函数处理,不会影响Collection的值.
        stringList.stream()
                .filter(s -> s.startsWith("a"))
                /*.sorted((String a, String b) -> b.compareTo(a))*/
                .sorted(String::compareTo)
                .forEach(System.out::println);

        //测试Map(映射)
        stringList.stream()
                .filter(s -> s.startsWith("b"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //测试Match(匹配)
        Boolean isMatch = stringList.stream()
//                .anyMatch(s -> s.startsWith("s"));
//                .allMatch(s -> s.startsWith("a"));
                .anyMatch(s -> s.startsWith("a"));
        System.out.println(isMatch);

        //测试Count(计数)
        Long count = stringList.stream()
                .filter(s -> s.startsWith("c"))
                .count();
        System.out.println(count);

        //测试Reduce(规约)
        Optional<String> optional = stringList.stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);
        //如果optional不为空,则做consumer处理
        optional.ifPresent(System.out::println);

        //ParallelStream并行流
        long t0 = System.nanoTime();
//        long number = stringList.parallelStream().sorted().count();
        long t1 = System.nanoTime();
        long number1 = stringList.stream().sorted().count();
        long t2 = System.nanoTime();
        //并行流排序所需时间
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        //串行流排序所需时间
        long millis1 = TimeUnit.NANOSECONDS.toMillis(t2 - t1);
        System.out.println(String.format("parallel sort took: %d ms", millis));
        System.out.println(String.format("sort took: %d ms", millis1));
    }
}
