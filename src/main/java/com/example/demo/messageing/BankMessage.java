package com.example.demo.messageing;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mybaits.initdata.InitDataListener;
import com.example.demo.utils.SocketUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：lejb
 * @date ：Created in 2019/6/5 11:13
 * @Description 银行发送短信公用类
 */
@Slf4j
public class BankMessage {

    private Map<String, String> messageMap;

    @Value("${message.host}")
    private String host;

    @Value("${message.port}")
    private int port;

    /**
     * 短信发送响应结果失败
     */
    private String responseFail = "1";

    public String sendMessage(String phoneno, String isreply, String messageid, Map<String, String> data) {
        log.info("调用发送短信接口");

        /*读取配置中所有短信模板*/
        messageMap = InitDataListener.messageMap;

        String message = "";

        /*通过传入的id查找短信模板*/
        Iterator<Map.Entry<String, String>> iterator = messageMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> map = iterator.next();
            String key = map.getKey();
            if (messageid.equals(key)) {
                message = map.getValue();
            }
        }
        log.info("查找到的短信模板为:" + message);



        /*拼装具体短信内容*/
//        message = String.format(message, name);
        message = splitMessage(message, data);

        log.info("拼接完的短信内容为:" + message);

        /*组装短信接口JSON参数*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phoneno", phoneno);
        jsonObject.put("msgcontent", message);
        jsonObject.put("isreply", isreply);

        /*调用银行发送短信接口*/
        String result = "";
        try {
            result = SocketUtil.Socket(jsonObject.toJSONString(), host, port);
            log.info("银行短信接口返回参数为:" + result);
        } catch (Exception e) {
            //TODO 抛出异常
            log.info("调用银行发送短信接口失败");
        }

        JSONObject resultData = JSONObject.parseObject(result);
        if (responseFail.equals(resultData.get("responsecode"))) {
            //TODO 抛出异常
            log.info(String.format("银行短信接口发送失败,失败原因为:&s", resultData.getString("responsemsg")));
        }

        return result;
    }

    private String splitMessage(String message, Map<String, String> map) {

        log.info("拼接前的短信模板为:" + message);

        List<String> elNames = new ArrayList<>();
        Pattern p = Pattern.compile("\\{(.*?)\\}");
        Matcher m = p.matcher(message);
        while (m.find()) {
            elNames.add(m.group(0));
        }

        for (int i = 0; i < elNames.size(); i++
        ) {
            String s1 = elNames.get(i);
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                String key = entry.getKey();
                String elNameKey = "{" + key + "}";
                if (elNameKey.equals(s1)) {
                    message = message.replace(s1, entry.getValue());
                }
            }
        }

        log.info("拼接后的短信模板为:" + message);
        return message;
    }

}
