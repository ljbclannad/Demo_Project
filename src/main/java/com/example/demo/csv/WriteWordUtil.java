package com.example.demo.csv;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author ：lejb
 * @date ：Created in 2019/10/22 16:06
 * @description : 数据打印word类
 */
@Slf4j
public class WriteWordUtil {

    public static void createWord(List<String> content, String fileName, HttpServletResponse response) throws Exception {

        // 文件路径
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator");
        System.out.println(filePath);

        XWPFDocument document = new XWPFDocument();
        OutputStream stream = null;
        BufferedOutputStream bufferStream = null;

        try {
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(filePath + fileName);
            stream = new FileOutputStream(file);
            bufferStream = new BufferedOutputStream(stream, 1024);
            // 创建一个段落
            XWPFParagraph p1 = document.createParagraph();
            // 设置居中
            p1.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun r1 = p1.createRun();
            // 是否加粗
            r1.setBold(true);
            // 与下一行的距离
            r1.setTextPosition(30);
            // 字体大小
            r1.setFontSize(18);
            // 增加换行
            r1.addCarriageReturn();
            // 创建第二个段落
            XWPFParagraph p2 = document.createParagraph();
            XWPFRun r2 = p2.createRun();
            for (int i = 0; i < content.size(); i++) {
                r2.setText(i + 1 + "、" + content.get(i));
                r2.addCarriageReturn();
            }
            // 设置字体
            r2.setFontFamily("仿宋");
            r2.setFontSize(14);
            document.write(stream);
            stream.close();
            bufferStream.close();

            try (InputStream fis = new BufferedInputStream(new FileInputStream(file))) {
                byte[] buffer = new byte[fis.available()];
                int count = 0;
                while ((count = fis.read(buffer)) > 0) {
                }
                fis.close();
                // 清空response
                response.reset();
                // 设置response的Header
                response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.addHeader("Content-Length", "" + file.length());
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                toClient.write(buffer);
                toClient.flush();
                toClient.close();
                if (file.delete()) {
                    log.info("");
                }
            } catch (FileNotFoundException e) {
                log.info(e.getMessage());
            }
        } catch (Exception ex) {
            log.error("写word或Excel错误文件失败：{}", ex.getMessage());
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error("写word文件失败：{}", e.getMessage());
                }
            }
            if (bufferStream != null) {
                try {
                    bufferStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error("写word文件失败：{}", e.getMessage());
                }
            }
        }

    }
}
