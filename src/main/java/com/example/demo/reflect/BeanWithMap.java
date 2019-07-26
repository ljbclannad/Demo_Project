package com.example.demo.reflect;

import com.google.common.collect.Maps;
import org.springframework.cglib.beans.BeanMap;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author ：lejb
 * @date ：Created in 2019/7/26 8:34
 * @Description :Bean和Map处理类
 */

public class BeanWithMap {

    /**
     * 将对象装换为map
     * @param bean
     * @return
     */
    public static <T> Map<String, String> beanToMap(T bean) {
        Map<String, String> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            //获取属性名
            Field[] fs = bean.getClass().getDeclaredFields();
            for (Object key : beanMap.keySet()) {
                for (Field f:fs
                ) {
                    //如果属性名相同并不为空 则添加到map中
                    if(key.equals(f.getName()) && beanMap.get(key) != null ){
                        map.put(key+"", beanMap.get(key).toString());
                        break;
                    }
                }
            }
        }
        return map;
    }

    /**
     * 将map装换为javabean对象
     *
     * @param map
     * @param bean
     * @return
     */
    public static <T> T mapToBean(Map<String, String> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}
