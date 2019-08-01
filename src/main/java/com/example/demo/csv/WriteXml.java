package com.example.demo.csv;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.List;

/**
 * @author ：lejb
 * @date ：Created in 2019/8/1 14:15
 * @Description :Xml导出类
 */
@Slf4j
public class WriteXml {

    public static void createXML(List<JSONObject> list)
            throws ParserConfigurationException, IOException {
        Document doc = DocumentHelper.createDocument();
        Element bills = doc.addElement("TEST");
        if (list != null && list.size() > 0) {
            for (JSONObject json : list) {
                Element bill = bills.addElement("test");
                Element channel = bill.addElement("Number1");
                channel.setText(json.getString("Number1"));
                Element source = bill.addElement("Number2");
                source.setText(json.getString("Number2"));
                Element payNo = bill.addElement("Number3");
                payNo.setText(json.getString("Number3"));
                Element feeType = bill.addElement("Number4");
                feeType.setText(json.getString("Number4"));
                Element patientName = bill.addElement("Number5");
                patientName.setText(json.getString("Number5"));
            }
        }

        // 实例化输出格式对象
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置输出编码
        format.setEncoding("UTF-8");
        // 创建需要写入的File对象
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator");
//        String fileName = ExportHelp.BILL_XML_NAME;
        String fileName = "邮件.Xml";
        File file = new File(filePath + fileName);
        // 生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        // 开始写入，write方法中包含上面创建的Document对象
        writer.write(doc);
    }
}
