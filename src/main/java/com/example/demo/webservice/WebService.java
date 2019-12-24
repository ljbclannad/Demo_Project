package com.example.demo.webservice;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import java.util.Iterator;
import java.util.Map;

/**
 * @author ：lejb
 * @date ：Created in 2019/12/24 21:15
 * @description : WebService工具类 记一次生产BUG
 */
@Slf4j
public class WebService {


    /**
     * @param: [url, method, params]
     * @return: java.lang.Object
     * @description: CXF客户端请求WebService, 会莫名出现超时BUG（暂未解决），生产出过一次事，建议谨慎使用
     * @author: lejb
     * @date: 2019/12/24 21:18
     */
    public static Object sendWs(String url, String method, Object... params) throws Exception {
        Object result = null;
        try {
            // 创建动态客户端
            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
            Client client = dcf.createClient(url);
            HTTPConduit conduit = (HTTPConduit) client.getConduit();
            HTTPClientPolicy policy = new HTTPClientPolicy();
            policy.setAllowChunking(false);
            //连接超时时间
            policy.setConnectionTimeout(6000000);
            //请求超时时间.
            policy.setReceiveTimeout(6000000);
            conduit.setClient(policy);
            Object data = client.invoke(method, params)[0];
            if (data instanceof Integer) {
                result = data;
            } else {
                result = JSONObject.parseObject(JSONObject.toJSONString(data));
                log.info(String.format("向%s发送请求，接口出参为%s", url, ((JSONObject) result).toJSONString()));
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return result;
    }


    /**
     * call调用webservice接口
     *
     * @param url        接口地址
     * @param nameSpace  命名空间(XML中targetNamespace属性)
     * @param methodName 方法名
     * @param paramMap   参数Map(采用LinkedHashMap,采用HashMap传递会导致自动排序，如果匹配XML内容)
     * @return
     */
    public static OMElement callWebServiceAxis2(String url, String nameSpace, String methodName, Map<String, Object> paramMap) throws Exception {
        OMElement result = null;
        try {
            ServiceClient serviceClient = new ServiceClient();
            //创建WebService的URL
            EndpointReference targetEPR = new EndpointReference(url);
            Options options = serviceClient.getOptions();
            options.setTo(targetEPR);
            //确定调用方法（ 命名空间地址 (namespace) 和 方法名称）
            options.setAction(nameSpace + methodName);
            OMFactory fac = OMAbstractFactory.getOMFactory();
            OMNamespace omNs = fac.createOMNamespace(nameSpace, "");
            OMElement method = fac.createOMElement(methodName, omNs);
            // 遍历传入方法的参数
            for (String key : paramMap.keySet()) {
                OMElement element = fac.createOMElement(key, omNs);
                Object obj = paramMap.get(key);
                if (obj != null) {
                    element.setText(paramMap.get(key).toString());
                }
                method.addChild(element);
            }
            method.build();
            log.info("请求的内容为" + method.toStringWithConsume());
            //调用接口
            result = serviceClient.sendReceive(method);
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        return result;
    }

    /**
     * 解析axis WebService请求返回内容
     *
     * @param url        接口地址
     * @param nameSpace  命名空间
     * @param methodName 方法名
     * @param paramMap   参数Map
     * @return
     */
    public static String callWebServiceAxis2Text(String url, String nameSpace, String methodName, Map<String, Object> paramMap) throws Exception {
        OMElement element = callWebServiceAxis2(url, nameSpace, methodName, paramMap);
        String resultTexe = "";
        if (element != null) {
            Iterator iterator = element.getChildElements();
            //据测试：解析第一层，从<soapenv:Body>往下一层开始解析
            while (iterator.hasNext()) {
                //获取第一层下面的XML
                OMElement omElement = (OMElement) iterator.next();
                Iterator iterator1 = omElement.getChildElements();
                //根据实际情况，短信接口需要解析第二层
                while (iterator1.hasNext()) {
                    //获取到第二层的XML格式对象
                    OMElement omElement2 = (OMElement) iterator1.next();
                    //打印XML标签名
                    System.out.println(omElement2.getLocalName());
                    //打印XML属性名
                    System.out.println(omElement2.getText());
                    //可以做业务处理进行返回
                }
                //如果下一层只有一个对象，可以用getFirstElement直接获取内容，无需迭代
//                OMElement omElement1 = omElement.getFirstElement();
//                String s1 = omElement1.getText();
            }
//            resultTexe = element.getFirstElement().getText();
        }
        return resultTexe;
    }

    //针对callWebServiceAxis2Text方法AXIS返回内容解析
    //以http://www.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx?wsdl接口为参考说明解析方式（略有点繁琐）
    //返回内容为：
    // <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
    //   <soap:Body>
    //      <getCountryCityByIpResponse xmlns="http://WebXml.com.cn/">
    //         <getCountryCityByIpResult>
    //            <string>?</string>
    //            <string>IP地址错误（IP应由 . 和数字组成）！请输入标准IP格式：*.*.*.*，http://www.webxml.com.cn</string>
    //         </getCountryCityByIpResult>
    //      </getCountryCityByIpResponse>
    //   </soap:Body>
    //</soap:Envelope>

    /*
        接口返回的element返回内容为Xml<soap:body>以下的XML文本 为：
       <getCountryCityByIpResponse xmlns="http://WebXml.com.cn/">
           <getCountryCityByIpResult>
             <string>?</string>
             <string>IP地址错误（IP应由 . 和数字组成）！请输入标准IP格式：*.*.*.*，http://www.webxml.com.cn</string>
         </getCountryCityByIpResult>
        </getCountryCityByIpResponse>
    */

    /*
        对element进行迭代查询，omElement为下一级菜单，内容为<getCountryCityByIpResult>下的标签（包括getCountryCityByIpResult标签）：
             <getCountryCityByIpResult>
                <string>?</string>
                <string>IP地址错误（IP应由 . 和数字组成）！请输入标准IP格式：*.*.*.*，http://www.webxml.com.cn</string>
             </getCountryCityByIpResult>
    */

    /*
        由于要获取的内容是3级菜单，需要再上次的内容下进行下一次迭代查询，三级菜单中包含2个标签，可以判断标签的LocalName是否是我们需要的参数名，如果是取Text()为内容：
             <string>?</string>
             <string>IP地址错误（IP应由 . 和数字组成）！请输入标准IP格式：*.*.*.*，http://www.webxml.com.cn</string>
    */
}
