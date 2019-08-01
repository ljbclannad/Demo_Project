package com.example.demo.csv;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lejb
 * @date ：Created in 2019/8/1 13:51
 * @Description :导出CSV文件测试类
 */

public class CsvTest {

    public static void main(String[] args) throws Exception{
        List<Object> rowList = new ArrayList<Object>();
        for (int i = 0; i <10 ; i++) {
            rowList.add(i);
        }

        List<List<Object>> columnList = new ArrayList<List<Object>>();
        for (int i = 0; i <10 ; i++) {
            columnList.add(rowList);
        }

        System.out.println(WriteCsv.writeCSV(columnList,"邮件",null));
    }
}
