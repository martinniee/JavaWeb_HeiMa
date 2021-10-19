package cn.nathan.reflect;

import cn.nathan.domain.Person;

/**
 * @author nathan
 * @create 2021-10-07-21:18
 **/
public class ReflectDemo1 {

    public static void main(String[] args) throws Exception {
        //以 domain.Person类为研究类

        //1、使用方式1: Class.forName("全类名")
        Class cls = Class.forName("cn.nathan.domain.Person");
        System.out.println(cls);

        //2、使用方式2: 类名.class
        Class cls1 = Person.class;
        System.out.println(cls1);

        //3、使用方式3: 对象.getClass()
        Person p = new Person(); // 创建类对象
        Class cls2 = p.getClass(); // 获取class对象
        System.out.println(cls2);

        // 比较这三个 class对象是否相等
        System.out.println(cls == cls1); // true
        System.out.println(cls == cls2); // true
    }
}
