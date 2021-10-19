package cn.nathan.reflect;

import cn.nathan.domain.Person;

import java.lang.reflect.Field;

/**
 * @author nathan
 * @create 2021-10-10-20:47
 **/
public class ReflectDemo2 {

    public static void main(String[] args) throws Exception {

        // 1、无论是获取字段还是方法,第一步先要获取class对象
        // 以类的属性方式获取class对象为例
        Class personClass = Person.class;

        // 2、获取成员变量 getFields()
        Field[] fields = personClass.getFields();
        for (Field field : fields){
            // 当属性仅有private权限时,则getFiedls()没有值。
            System.out.println("The value of field:" +field); //  空
        }
        System.out.println("===============");
        // 3、指定获取某字段 getField
        Field a= personClass.getField("a");

        /*
        获取成员对象a的值
        格式: get(Object obj)
         */
        Person p = new Person();
        Object value = a.get(p);
        System.out.println("The value of 'value':"+value);

        /*
         设置a的值
         格式: 字段对象.set(类对象,值)
         实例: a.set(p,"张三")
         */
        a.set(p,"张三");
        System.out.println(p);

        // 4、 Field[] getDeclaredFields() 获取所有对象(成员变量)
        Field[] declaredFidles = personClass.getDeclaredFields();
        for(Field declaredField : declaredFidles){
            System.out.println("The value of decalredField: " + declaredField);
        }

        // 5、Field getDeclaredField(String name) 获取指定属性对象
        Field age = personClass.getDeclaredField("age");
        // 在获取private属性值之前,需要做的事情是:
        /*
         忽略访问权限修饰符的安全检查 ,也被称作暴力反射。
         格式: 字段对象.serAccessible(true)
         实例: age.setAccessible(true);
         */
        age.setAccessible(true);  // 暴力反射
        Object value2 = age.get(p);
        System.out.println("The value of 'value2': " + value2);





    }
}
