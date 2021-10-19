package cn.nathan.test;

import cn.nathan.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author nathan
 * @create 2021-10-01-21:46
 **/

// 是测试类

public class CalculatorTest {

    /**
     * 初始化方法: 用于资源申请,所有测试方法杂执行之前都会先执行该方法。
     *
     */
    @Before
    public void init(){
        System.out.println("init()...");
    }

    /**
     * 释放资源的方法: 在所有测试方法执行完,都会自动自动执行该方法
     *
     */
    @After
    public void close(){
        System.out.println("close()...");
    }




    /**
     * 测试add方法
     *
     */

    @Test
    public void Testadd(){
//        System.out.println("我被执行了");
    // 1、创建计算器对象
        Calculator c = new Calculator();
//        2、调用add方法
        int result = c.add(1,2);
//        System.out.println(result);
        System.out.println("testadd()...");
        // 3、断言: 在在此处我断言输出的结果是多少,和实际输出进行对比
        Assert.assertEquals(3,result);
    }



}
