package cn.nathan.junit;

/**
 * @author nathan
 * @create 2021-10-01-21:32
 **/
public class CalculatorTest {
    // 在main方法中进行测试

    public static void main(String[] args) {
        // 1、创建对象
        Calculator c = new Calculator();
        // 2、调用方法
//        int result = c.add(1, 2);
//        System.out.println(result);
        int result = c.sub(1,1);
        System.out.println(result);
    }
}
