package com.example.demo.domin;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.beans.BeanMap;

import java.lang.reflect.Field;
import java.util.Map;

@Getter
@Setter
public class Student extends Person {

    private String number;

    @Override
    public Map getPersonInfo() {

        return super.getPersonInfo();
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge("11");
//        System.out.println(beanToMap(student));
        Map<String,String> map = beanToMap(student);
        Student student1 = new Student();
        mapToBean(map,student1);
        System.out.println(student1.toString());
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
            System.out.println(beanMap);
            Field[] fs = bean.getClass().getDeclaredFields();
            for (Object key : beanMap.keySet()) {
                for (Field f:fs
                ) {
                    System.out.println(f.getName());
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

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
