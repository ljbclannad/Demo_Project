package com.example.demo.csv;


import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lejb
 * @date ：Created in 2019/10/22 16:25
 * @description :
 */

public class wordTest {

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        HttpServletResponse response = null;
        WriteWordUtil.createWord(list, "开通协议", response);
    }
}
