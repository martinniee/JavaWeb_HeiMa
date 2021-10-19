package cn.nathan.reflect;

import cn.nathan.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author nathan
 * @create 2021-10-10-20:47
 **/
public class ReflectDemo3 {

    public static void main(String[] args) throws Exception {

        // 1、无论是获取字段还是方法,第一步先要获取class对象
        // 以类的属性方式获取class对象为例
        Class personClass = Person.class;

        /**
         * 2、获取成员方法们
         * Method[] getMedthods()
         * Method getMethod(String name,类<?>...parameterTypes)
         *
         * Method[] getDeclaredMedthods()
         * Method getDeclaredMethod(String name,类<?>...parameterTypes)
         */
        // 以获取指定名称的方法为例 getMethod(String name,类<?>...parameterTypes)
        // 2.1.获取方法的对象
        Method eat_method = personClass.getMethod("eat");
        System.out.println("The 'eat_method': " + eat_method);
        Person p = new Person();
        /**
         * 2.2.执行方法
         * 格式: 方法对象.invoke(<参数列表>)
         *
         */
//        System.out.print("The 'p':");
//        eat_method.invoke(p);

        // 获执行带参数的方法对象
        Method eat_method_withArg = personClass.getMethod("eat", String.class);
        System.out.print("The 'p':");
        eat_method_withArg.invoke(p,"fish");

        System.out.println("-----------");
        // 获取所有的public修饰的方法
//        Method[] methods = personClass.getMethods();
//        for(Method method :methods){
//            System.out.println("The method: " + method);
//        }

        /**
         * 获取方法名
         * 格式: 方法对象.getName();
         */
        Method[] methods1 = personClass.getMethods();
        for(Method method: methods1){
            System.out.println("The method of methods1: " + method);
            String name = method.getName();
            System.out.println("The name: " + name);

        }
        /**
         * 获取类名
         * 格式: class对象.getName*();
         */
        String className = personClass.getName();
        System.out.println("The 'className': " + className);


    }
}
