package com.example.demo.ybmessage;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author ：lejb
 * @date ：Created in 2019/5/20 17:27
 */
@Slf4j
public class YbMessage {

    /**
     * 报文区域分隔符
     */
    private static String ybCode = "$$";

    /**
     * 一级报文分隔符
     */
    private static String ybMessageCode = "~";

    /**
     * 二级报文分隔符
     */
    private static String ybSecendMessageCode = "%%";


    /**
     * 由于前4位固定,创建数组
     *
     * @param ksbm  社会保障卡识别码
     * @param index 传入参数个数
     * @return
     */
    public static String[] ybInBeanAssemble(String ksbm, int index) {
        String[] ybInBean = new String[index];
        ybInBean[0] = "2";
        ybInBean[1] = ksbm;
        ybInBean[2] = "1";
        ybInBean[3] = "";
        return ybInBean;
    }



    /**
     * 根据传入的参数(数组形式)组装成一级报文体
     *
     * @param ybInBean
     * @return
     */
    public static String ybMessageAssemble(String[] ybInBean) {

        StringBuffer ybMessage = new StringBuffer(ybCode);
        List<String> ybInBeanList = Arrays.asList(ybInBean);
        /* 将传入的参数根据报文分隔符进行组装 */
        ybInBeanList.forEach(message -> ybMessage.append(message ==null ? "":message).append(ybMessageCode));
        /* 根据报文格式要求,去除最后一位分隔符 */
        ybMessage.deleteCharAt(ybMessage.length()-1);
        ybMessage.append(ybCode);
        log.info("根据参数拼装成的一级报文为:"+ybMessage);
        return ybMessage.toString();
    }

    /**
     * 根据传入的参数(数组形式)组装成二级报文体
     * @param ybSecendInBean
     * @return
     */
    public static String ybSecendMessageAssemble(String[] ybSecendInBean){

        StringBuffer ybSecendMessage = new StringBuffer();
        List<String> ybSecendInBeanList = Arrays.asList(ybSecendInBean);
        /* 将传入的参数根据报文分隔符进行组装 */
        ybSecendInBeanList.forEach(message->ybSecendMessage.append(message == null ? "" :message).append(ybSecendMessageCode));
        /* 根据报文格式要求,去除最后一位分隔符 */
        ybSecendMessage.delete(ybSecendMessage.length()-2,ybSecendMessage.length());
        log.info("根据参数拼装成的二级报文为:"+ybSecendMessage);
        return ybSecendMessage.toString();
    }

    /**
     * 将返回的报文体返回成数组结构(只针对一级报文体)
     * @param ybOutMessage
     * @return
     */
    public static String[] ybMessageSplit(String ybOutMessage) {

        log.info("医保返回参数内容为:"+ybOutMessage);

        ybOutMessage = ybOutMessage.replace(ybCode, "");

        /**
         * 如果最后一位为空,则需要添加 ~来进行解析,否则数组获取不到内容
         */
        if (ybMessageCode.equals(ybOutMessage.substring(ybOutMessage.length() - 1))) {
            ybOutMessage += (" "+ybMessageCode);
        }
        String[] ybOutBean = ybOutMessage.split(ybMessageCode);
        List<String> ybOutBeanList = Arrays.asList(ybOutBean);
        ybOutBeanList.stream().forEach(log::info);
        return ybOutBean;
    }


    /**
     * 将医保返回的结构体按照%%进行转化(二级报文体)
     * @param ybComposite
     * @return
     */
    public static String[] ybCompositeSplit(String ybComposite){

        log.info("医保返回二级结构体的参数为:"+ybComposite);

        /**
         * 如果最后一位为空,则需要添加 %%来进行解析,否则数组获取不到内容
         */
        if(ybSecendMessageCode.equals(ybComposite.substring(ybComposite.length()-2,ybComposite.length()))){
            ybComposite += (" "+ybSecendMessageCode);
        }
        String[] ybCompositeOutBean = ybComposite.split(ybSecendMessageCode);
        List<String> ybCompositeOutBeanList = Arrays.asList(ybCompositeOutBean);
        ybCompositeOutBeanList.stream().forEach(log::info);
        return ybCompositeOutBean;
    }


    public static void main(String[] args) {
//        String[] secendInBean = new String[]{"1","2","3","4","5"};
//        String ybSecendMessage = ybSecendMessageAssemble(secendInBean);
//        String[] inBean = ybInBeanAssemble("123", 5);
//        inBean[4] = ybSecendMessage;
//        ybMessageAssemble(inBean);
//
//        String ybOutMessage = "$$0~~0~~~1111%%2344%%张三%%1%%01%%19800101%%%%1%%155%%11%%1%%3%%~000000000000000~000000000000000~000000000000000~$$";
//        String[] outBean = ybMessageSplit(ybOutMessage);
//        ybCompositeSplit(outBean[5]);

        String[] documentsLists = new String[8];
        documentsLists[0] = "21132213213";
        documentsLists[1] = "123123";
        documentsLists[2] = "耳鼻咽喉科";
        documentsLists[3] = "123";
        documentsLists[4] = "123321";
        documentsLists[5] = "某某人";
        documentsLists[6] = "10";
        documentsLists[7] = "521.00";
        String documentsList = YbMessage.ybSecendMessageAssemble(documentsLists);

        String[] ybChargeLists = new String[21];
        ybChargeLists[0] = "21132213213";
        ybChargeLists[1] = "2";
        ybChargeLists[2] = "1018";
        ybChargeLists[3] = "1018";
        ybChargeLists[4] = "mg";
        ybChargeLists[8] = "15";
        ybChargeLists[9] = "1";
        ybChargeLists[10] = "1";
        ybChargeLists[11] = "15";
        ybChargeLists[12] = "0";
        ybChargeLists[13] = "";
        ybChargeLists[14] = "0";
        ybChargeLists[15] = "";
        ybChargeLists[16] = "0";
        ybChargeLists[17] = "102001";
        ybChargeLists[18] = "001";
        ybChargeLists[19] = "102001";
        ybChargeLists[20] = "";
        String ybChargeList = YbMessage.ybSecendMessageAssemble(ybChargeLists);

        String[] yjsStrLists = YbMessage.ybInBeanAssemble("123123",24);
        yjsStrLists[4] = "10";
        yjsStrLists[5] = "123123";
        yjsStrLists[6] = new SimpleDateFormat("yyyymmdd").format(new Date());
        yjsStrLists[7] = "11";
        yjsStrLists[8] = "";
        yjsStrLists[9] = "咽喉炎";
        yjsStrLists[10] = "";
        yjsStrLists[11] = "闫浩";
        yjsStrLists[12] = "1";
        yjsStrLists[13] = documentsList;
        yjsStrLists[14] = ybChargeList;
        yjsStrLists[15] = "12";
        yjsStrLists[16] = "16";
        yjsStrLists[17] = "17";
        yjsStrLists[18] = "18";
        yjsStrLists[19] = "19";
        yjsStrLists[20] = "20";
        yjsStrLists[21] = "21";
        yjsStrLists[22] = "22";
        yjsStrLists[23] = "23";
        String yjsStr = YbMessage.ybMessageAssemble(yjsStrLists);
        System.out.println(yjsStr);
    }

}
