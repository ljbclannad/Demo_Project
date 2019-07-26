package com.example.demo.reflect;

import com.example.demo.domin.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ：lejb
 * @date ：Created in 2019/7/25 14:30
 * @Description java反射测试类
 */

public class Reflect {

    /**
     * 通过反射获取class
     *
     * @throws Exception
     */
    private static void findClass() throws Exception {
        //getClass()获取
        Person person = new Person();
        Class c1 = person.getClass();
        System.out.println(c1.getSimpleName());
        //类名.class获取
        System.out.println(Person.class.getSimpleName());
        //Class.forName获取(包路径)
        System.out.println(Class.forName("com.example.demo.domin.Person").getSimpleName());
    }

    /**
     * 通过反射获取构造方法
     *
     * @throws Exception
     */
    private static void findConstructor() throws Exception {
        Class c1 = Class.forName("com.example.demo.domin.Person");
        //获取所有的构造方法
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors
        ) {
            System.out.println(constructor);
        }
        //获取入参为String类型的构造方法(getConstructor可以有多个入参,代表每个参数的类型)
        Constructor constructor = c1.getConstructor(String.class);
        //调用构造方法
        Object object = constructor.newInstance("lejb");
        System.out.println(object.toString());
    }

    /**
     * 获取成员变量
     *
     * @throws Exception
     */
    private static void findField() throws Exception {
        Class c1 = Class.forName("com.example.demo.domin.Person");
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields
        ) {
            System.out.println(field.getName() + field.getAnnotatedType().getType());
        }
    }

    /**
     * 获取main方法
     *
     * @throws Exception
     */
    private static void findMain() throws Exception {
        Class c1 = Class.forName("com.example.demo.domin.Person");
        Method method = c1.getMethod("main", String[].class);
        method.invoke(null, (Object) new String[]{});
    }

    public static void main(String[] args) throws Exception {
//        findClass();
//        findConstructor();
//        findField();
        findMain();
    }
}
