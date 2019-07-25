package com.example.demo.domin;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.context.annotation.Bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class Person {

    public String name;

    public String age;

    public String sex;

    public Map getPersonInfo() {
        Map map = new HashMap();
        map.put("name", name);
        map.put("age", age);
        map.put("sex", sex);
        return map;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge("11");
        System.out.println(beanToMap(person));
        Map<String,String> map = beanToMap(person);
        Person person1 = new Person();
        mapToBean(map,person1);
        System.out.println(person1.getAge());
    }

    /**
     * 将对象装换为map
     * @param bean
     * @return
     */
    public static <T> Map<String, String> beanToMap(T bean) {
        Map<String, String> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            Field[] fs = bean.getClass().getDeclaredFields();
            for (Object key : beanMap.keySet()) {
                for (Field f:fs
                     ) {
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
