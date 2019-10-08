package com.example.demo.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

/**
 * @author ：lejb
 * @date ：Created in 2019/10/8 9:13
 * @description : 二维码生成类
 */

public class QrCode {

    public static String getCodeBase64Str(String content) throws IOException{

        int width = 300;
        int height = 300;
        String format = "png";
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        //新建流。
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
        ImageIO.write(image, format, os);
        //从流中获取数据数组。
        byte b[] = os.toByteArray();
        String str = new BASE64Encoder().encode(b);
        return str;
    }

    public static void main(String[] args) throws IOException {
        String text = "999666111222";
        int width = 300;
        int height = 300;
        String format = "png";
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        //直接写入文件
//        File outputFile = new File("d:/new.png");
//        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
//
        //通过流写入文件，不需要flush()
//        OutputStream os1 = new FileOutputStream("d:/new2.png");
//        MatrixToImageWriter.writeToStream(bitMatrix, format, os1);

        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        //新建流。
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
        ImageIO.write(image, format, os);
        //从流中获取数据数组。
        byte b[] = os.toByteArray();
        String str = new BASE64Encoder().encode(b);
        System.out.println(str);
    }

}
