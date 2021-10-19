package cn.nathan.reflect;

import cn.nathan.domain.Person;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author nathan
 * @create 2021-10-12-15:08
 **/
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // 1、创建类
//        Person p = new Person();
//        // 2、执行方法
//        p.eat();

        // 假如需要修改对象和执行的方法,虽然没有问题,但是不符合条件,失去了意义。
//        Student stu = new Student();
//        stu.sleep();


        /**
         * 使用反射框架的方式
         */
        //1.加载配置文件
            //1.1.创建Properties对象
        Properties pro = new Properties();
            //1.2.加载配置文件转化为集合
                //1.2.1.获取class目录下的配置文件使用类加载器
            // 创建一个类加载器,这个类加载器可以使用加载这个类的类加载器(类文件是由类加载器加载到内存中得)
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
                //1.2.2.使用类加载器加载指定配置文件转化为字节流
        InputStream is = classLoader.getResourceAsStream("pro.properties");
                //1.2.3.再使用Properties对象加载配置文件的字节流到内存,涉及到io需要异常处理。
        pro.load(is);


        //2.获取配置文件中的数据
            //2.1.获取配置文件中有关类名的数据
        String classname = pro.getProperty("className");
            //2.2.获取配置文件中有关方法名的数据
        String methodName = pro.getProperty("methodName");

        //3.加载类到内存
        Class cls = Class.forName(classname);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);

    }
}
