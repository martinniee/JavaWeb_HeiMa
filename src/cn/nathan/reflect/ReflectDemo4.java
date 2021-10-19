package cn.nathan.reflect;

import cn.nathan.domain.Person;

import java.lang.reflect.Constructor;

/**
 * @author nathan
 * @create 2021-10-10-20:47
 **/
public class ReflectDemo4 {

    public static void main(String[] args) throws Exception {

        // 1、无论是获取字段还是方法,第一步先要获取class对象
        // 以类的属性方式获取class对象为例
        Class personClass = Person.class;


        /**
         *  2、获取构造方法
         *  格式: Constructor<T> getConstructor(类<?>... parameterTypes)
         */
        Constructor constructor = personClass.getConstructor(String.class,int.class);
        System.out.println("The object of constructor: " + constructor);

        /**
         *  3、创建对象
         *  格式: constructor对象.newInstance(<参数列表>);
         */
        Object person = constructor.newInstance("张三", 23);
        System.out.println("The 'person': " + person);
        System.out.println("----------------");

        // 创建对象(传递空参)
        // .1.创建构造器对象
        Constructor constructor1 = personClass.getConstructor();
        System.out.println("The constructor1: " + constructor1);
        // .2.使用构造器创建对象实例
        Object person1 = constructor1.newInstance();
        System.out.println("The person1': " + person1);

        // 也可直接使用class对象创建对象
        Object o = personClass.newInstance();
        System.out.println("The o: " + o);


    }
}
