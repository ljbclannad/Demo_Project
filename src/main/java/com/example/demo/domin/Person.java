package com.example.demo.domin;

import com.example.demo.reflect.BeanWithMap;
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
import java.util.*;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge("11");
        System.out.println(BeanWithMap.beanToMap(person));
        Map<String, String> map = BeanWithMap.beanToMap(person);
        Person person1 = new Person();
        BeanWithMap.mapToBean(map, person1);
        System.out.println(person1.getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    //尝试重写了equals方法
    @Override
    public boolean equals(Object obj) {
        Person person = new Person("lejb");
        if(person.getName().equals("lejb")){
            return false;
        }else {
            return true;
        }
    }

//    @Override
//    public int hashCode() {
//        return new Random().nextInt(10);
////        return super.hashCode();
//    }
}
