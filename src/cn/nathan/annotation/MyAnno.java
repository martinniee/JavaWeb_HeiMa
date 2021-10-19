package cn.nathan.annotation;

/**
 * @author nathan
 * @create 2021-10-14-12:30
 **/
public @interface MyAnno {
    /*
    编写自定义的注解
     */
    public abstract String show();

    // void show(); // 注解中不允许void返回值方法存在

    int value();
//    String name() default "张三";

    //1. 基本数据类型
    int show1();
    //2.String
    String show2();
    //3.枚举
    Person per();
    //4.注解
    MyAnno2 anno2();
    //5.数以上类型的数组类型
    String[] strs();



}
