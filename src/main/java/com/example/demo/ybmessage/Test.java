package com.example.demo.ybmessage;

import com.dabay.esicp.core.ESICPClient;
import com.dabay.esicp.util.EsicpResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lejb
 * @date ：Created in 2019/5/21 9:54
 */

public class Test {
    public static void main(String[] args) {
//        Map map=new HashMap();
//        map.put("tradeCode","8500");
//
//        map.put("channelNo","3305000003");
//        map.put("signNo","0E8160B6D465687C55F19CD82E78BCF7");
//        EsicpResult result= new ESICPClient("http://10.87.0.88:8080/bsse/services/bsse?wsdl", "de3737b10fa741be8b0430a7d8724f80", "PsHpo3Qr/KOBw3GrtCI3N6SNdac=").request(map);

        String[] documentsLists = new String[8];
        String documentsList = YbMessage.ybSecendMessageAssemble(documentsLists);

        String[] ybChargeLists = new String[21];
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
