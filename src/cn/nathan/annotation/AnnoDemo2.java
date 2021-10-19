package cn.nathan.annotation;


/**
 * @author nathan
 *  * @create 2021-10-14-11:44
 * 了解3种
 *
 * - @Override: 检测被该注解标注的方法是否继承其父类
 *
 * - @Deprected: 被该注解的标注的内容表示已经过时(只是建议不使用,并非不能使用)
 *
 * - @SuppressWarnings: 压制警告,被该注解标注的内容不会被编译器提示警告
 *
 *
 */
@SuppressWarnings("all")
public class AnnoDemo2 {
    // 任何类都默认继承Object类的toString()方法
    @Override
    public String toString() {
        return super.toString();
    }

    /*
     说明此时的show1方法过时,不建议使用
     ⚠️ 不要删除这个show1方法,因为这样就不兼容低版本了
     */
    @Deprecated
    public  void show1(){
        // 有缺陷,不建议使用
    }
    @MyAnno(show = "", value = 0, show1 = 0, show2 = "", per = Person.p1, anno2 = @MyAnno2, strs = {})
    public void show2(){
        // 替代show1的show2方法
    }
    // 当强行使用被标注@Deprecated的方法时,方法会使用删除线标明


    public void test(){
        show1();
    }

}
