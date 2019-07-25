package com.example.demo.lambda;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * @author ：lejb
 * @date ：Created in 2019/7/17 16:47
 */

public class Optionals {

    public static void main(String[] args) {
        String a = "123";
        String s = null;

        Optional optional = Optional.ofNullable(s);
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
//        System.out.println(Optional.ofNullable(s)
                //查看.map源码 属于Optional类,不属于lambda表达式.
//                .map(s1 -> "1234789")
                //在orElse中能进行返回值为String处理
//                .orElse("s false"));
//                .orElseThrow(() ->new RuntimeException()));
//                .orElse(String.format("处理完的参数为%s",a)));
//        String start = Optional.ofNullable(s).orElse(a);
//        System.out.println(start);
    }
}
