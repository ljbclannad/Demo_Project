package com.example.demo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.constants.ShowStatus;
import com.example.demo.domin.Person;
import com.example.demo.domin.SchedulerTask;
import com.example.demo.domin.Student;
import com.example.demo.utils.CommonUtil;
import com.example.demo.utils.DateUtil;
import com.example.demo.utils.DesCbcSecurity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Test1 {

    private DateUtil dateUtil = new DateUtil();

    @Test
    public void test() {
        SchedulerTask schedulerTask = new SchedulerTask();
    }

    @Test
    public void test1() {
        Class student = Student.class;
    }

    @Test
    public void testString() {
        String cardNum = "62309107990228044241";
//        System.out.println(cardNum.length());
//        //subString从下标开始,选择几位
        System.out.println(StringUtils.left(cardNum, 4) + " **** " + cardNum.substring(cardNum.length() - 4, cardNum.length()));
        System.out.println(StringUtils.right(cardNum,4));
//        String s = "2019-09-20";
//        System.out.println(s.substring(0,7));
//        System.out.println(StringUtils.isBlank(null));

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        //每小时的00:00:00
        Date start = calendar.getTime();

        calendar.setTime(start);
        calendar.add(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        //每小时的最后
        Date end = calendar.getTime();
        System.out.println(start);
        System.out.println(end);
    }

    @Test
    public void testRandom() {
        //随机获取5位数
//        int a1 = (int)(((Math.random()*9+1)*100000));
//        System.out.println(System.currentTimeMillis()+"#"+String.valueOf(a1));
//        JSONObject j = new JSONObject();
//        j.put("1","23");
//        JSONObject a = new JSONObject();
//        a.put("23","34");
//        j.put("231213",a);
//        System.out.println(j);
//
//        System.out.println((Map<String,String>)j.get("231213"));
        Date end_date = DateUtils.addDays(new Date(),1);
        System.out.println(end_date);
        long diffDays = (end_date.getTime() - new Date().getTime()) / (24 * 60 * 60 * 1000);
        System.out.println(diffDays);
    }

    @Test
    public void testJSON() throws Exception{
//        Person person = new Person();
//        person.setAge("11");
//        Object jsonObject = JSONObject.toJSON(person);
//        System.out.println(JSONObject.toJSONString(jsonObject));

        HashMap map = new HashMap();
        String s = "231";
        map.put(s,"123");
        map.put(s,"321");
        System.out.println(map.get(s));
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").parse("20191012011111"));
        System.out.println(new DateUtil().timeFormat.format(new SimpleDateFormat("yyyyMMddHHmmss").parse("20191012011111")));
    }

    @Test
    public void test111() {

        List<String> elNames = new ArrayList<>();
        String s = "农商行{name},额度为{amount}";
        Pattern p = Pattern.compile("\\{(.*?)\\}");
        Matcher m = p.matcher(s);
        while (m.find()) {
            elNames.add(m.group(0));
        }

        Map<String, String> map = new HashMap<>();
        map.put("name", "123");
        map.put("amount", "23123");

        for (int i = 0; i < elNames.size(); i++
        ) {
            String s1 = elNames.get(i);
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                String key = entry.getKey();
                String elNameKey = "{" + key + "}";
                if (elNameKey.equals(s1)) {
                    s = s.replace(s1, entry.getValue());
                }
            }
        }

//        elNames.forEach(s1 -> {
//            System.out.println(s1);
//            Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
//            while (it.hasNext()){
//                Map.Entry<String,String> entry = it.next();
//                String key = entry.getKey();
//                String elNameKey = "{"+key+"}";
//                if(elNameKey.equals(s1)){
//                    s = s.replace(s1,entry.getValue());
//                }
//            }
//        });

//        s = s.replaceAll("name","123");
        System.out.println(s);
    }


    @Test
    public void Test222() throws Exception {
//        String s = "<Response><ResponseCode>0</ResponseCode><ResponseMsg></ResponseMsg><BankTraceNo></BankTraceNo><IDCardNo>123000000000000000</IDCardNo><CustName>张三</CustName><CustState>1</CustState><CustInfo><Item><AcctNo>002345678</AcctNo><AcctState>0</AcctState ></Item><Item><AcctNo>002345699</AcctNo><AcctState>1</AcctState></Item></CustInfo></Response>";
        String s = "<Response>   <ResponseCode>0</ResponseCode>   <ResponseMsg>查询客户名下账号信息成功</ResponseMsg>   <BankTraceNo>711801344167</BankTraceNo>   <IDCardNo>330723198206190010</IDCardNo>   <CustName>客户81070932305</CustName>   <CustState>1</CustState>   <CustInfo>     <Item>       <AcctNo>6230910799022804424</AcctNo>       <AcctState>0</AcctState>     </Item>     <Item>       <AcctNo>6230910199059062238</AcctNo>       <AcctState>0</AcctState>     </Item>   </CustInfo> </Response>";
//        String s = "<Response><ResponseCode>0</ResponseCode><ResponseMsg>批扣成功</ResponseMsg><BankTraceNo></BankTraceNo><VoucherNo></VoucherNo><BatchNo></BatchNo><BatchSuccInfo><Item><BatchSuccNo>20190101082233</BatchSuccNo></Item><Item><BatchSuccNo>20190101082244</BatchSuccNo></Item></BatchSuccInfo><BatchFailInfo><Item><BatchFailNo>20190101082233</BatchFailNo><BatchFailMess>账户余额不足</BatchFailMess></Item><Item><BatchFailNo>20190101082244</BatchFailNo><BatchFailMess>账户冻结</BatchFailMess></Item></BatchFailInfo></Response>";
//        JSONObject jsonObject = CommonUtil.xml2JSON(s);
//        System.out.println(jsonObject);


//        String resString = StringUtils.substringAfter(s, "?>");
//        System.out.println("resString:"+resString);
        JSONObject jsonObject = CommonUtil.xml2JSON(s);
        System.out.println(jsonObject);

        JSONObject responseJson = jsonObject.getJSONObject("Response");
        System.out.println(responseJson);
//
        String responseCode = responseJson.getString("ResponseCode");
        System.out.println(responseCode);
//
        JSONObject custInfoJson = responseJson.getJSONObject("CustInfo");
        System.out.println(custInfoJson);
//
        Object itemObject = custInfoJson.get("Item");
        JSONArray itemJson = new JSONArray();
        if (itemObject instanceof JSONObject) {
            itemJson.add(itemObject);
        } else {
            itemJson.addAll(custInfoJson.getJSONArray("Item"));
        }

//        JSONArray itemJson = custInfoJson.getJSONArray("Item");
        for (int i = 0; i < itemJson.size(); i++) {
            JSONObject jsonObject1 = itemJson.getJSONObject(i);
            System.out.println(jsonObject1);
        }
    }

    @Test
    public void testBigDeicmal() {
//        BigDecimal bigDecimal = new BigDecimal(2);
//        BigDecimal bigDecimal1 = new BigDecimal(-1);
////        bigDecimal = bigDecimal.add(bigDecimal1);
//        System.out.println(bigDecimal.add(bigDecimal1));

        BigDecimal bigDecimal = new BigDecimal("246402.00");
        BigDecimal bigDecimal1 = new BigDecimal("500000.00");
//        System.out.println(bigDecimal.divide(bigDecimal1,4,BigDecimal.ROUND_HALF_UP));
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMinimumFractionDigits(2);//设置数的小数部分所允许的最小位数(如果不足后面补0)
        percent.setMaximumFractionDigits(3);//设置数的小数部分所允许的最大位数(如果超过会四舍五入)
        System.out.println(percent.format(bigDecimal.divide(bigDecimal1, 4, BigDecimal.ROUND_HALF_UP)));
    }

    @Test
    public void testMonthDay() throws Exception {
//        System.out.println(new SimpleDateFormat("MM月dd日").format(new SimpleDateFormat("MM-dd").parse("2019-01-11")));
        System.out.println(new SimpleDateFormat("MM月dd日").format(new Date()));
    }

    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
//        int day = calendar.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
//        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
//        Date week = calendar.getTime();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(week));

        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date month = calendar.getTime();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(month));
    }

    /**
     * 获取时间范围内的天数
     *
     * @return
     * @throws Exception
     */
    @Test
    public void testBetweenTime() throws Exception {

        //查找时间段内的每个时间
        List<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start_date = sdf.parse("2019-06-10");
        Date end_date = sdf.parse("2019-07-20");
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start_date);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end_date);
        while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {
            result.add(sdf.format(tempStart.getTime()));
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        Collections.reverse(result);

        result.forEach(System.out::println);
        //查看中间相隔天数
//        Date end_date =new DateUtil().timeFormat.parse("2019-12-31 23:59:59");
//        long diffDays = (end_date.getTime() - new Date().getTime()) / (24 * 60 * 60 * 1000);
//        System.out.println(String.valueOf(diffDays));
    }

    @Test
    public void testSubString() throws Exception{
//        String s = "2019-06-10";
        String s = null;
        String start = Optional.ofNullable(s)
                .map(time -> s)
//                .map(time -> withholdStartTime.substring(0, 7))
                .orElse(dateUtil.commonDateFormat.format(new Date()));
        System.out.println(start);
    }
}
