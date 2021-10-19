package cn.nathan.domain;

/**
 * @author nathan
 * @create 2021-10-07-21:21
 **/
public class Person {
    private String name;
    private  int age;
    public String a ; // 用于测试getFields()方法的限制

    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat (){
        System.out.println("eating.......");
    }
    public void eat(String food){
        System.out.println("eating " +food );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                '}';
    }
}
