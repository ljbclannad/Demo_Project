package com.example.demo.csv;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lejb
 * @date ：Created in 2019/8/1 13:47
 * @Description :创建CSV文件
 */
@Slf4j
public class WriteCsv {

    public static String writeCSV(List<List<Object>> dataList, String fileName, String path
    ) throws Exception {

        // 表格头
//        List<Object> headList = Arrays.asList(head);
        // 文件路径
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "csvReport" + System.getProperty("file.separator");
        log.info("filePath:" + filePath);

        File csvFile = null;
        BufferedWriter csvWtriter = null;
        try {
            csvFile = new File(filePath + fileName);
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            // GB2312使正确读取分隔符","
            csvWtriter = new BufferedWriter(new OutputStreamWriter(new
                    FileOutputStream(csvFile), "GB2312"), 1024);
            csvWtriter.write(fileName);
            csvWtriter.newLine();

            // 写入文件头部
//            writeRow(headList, csvWtriter);
            // 写入文件内容
            if (dataList != null) {
                for (List<Object> row : dataList) {
                    writeRow(row, csvWtriter);
                }
            }

            csvWtriter.flush();
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            if (csvWtriter != null) {
                csvWtriter.close();
            }
        }
        return filePath;
    }

    /**
     * 写一行数据
     *
     * @param row       数据列表
     * @param csvWriter
     * @throws IOException
     */
    private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
        for (Object data : row) {
            StringBuffer sb = new StringBuffer();
            String rowStr = sb.append("\"").append(data).append("\",").toString();
            csvWriter.write(rowStr);
        }
        csvWriter.newLine();
    }
}
