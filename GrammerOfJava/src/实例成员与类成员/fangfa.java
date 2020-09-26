package 实例成员与类成员;

public class fangfa
{
    float A(int a)           //实例方法  只有创建了类的对象 才能调用实例方法
    {
        System.out.println("a = "+a);
        return 1.1f;
    }

    static float B()       //类方法（静态方法）  可以直接类名.方法()来调用
    {
        System.out.println("BBBBBB");
        return  2.2f;
    }

    static void C()     //类方法
    {
        System.out.println("CCCCCC");
    }


    static int Year()
    {
        return 2020;
    }
    static double MonthDay()
    {
        return 9.20;
    }

    //对任何一个类  都是Object类的子类 所以每个类都继承了Object的getClass() toString() equals()  hashCode() 方法
    //但是我们通常会加载新类的toString()等方法  因为Object类的默认实现一般是无法提供所需要的行为
    //toString(): 返回表示 Integer 值的 String 对象。
    //toString(int i): 返回表示指定 int 的 String 对象。
    //当连接运算符的一个操作数是字符串时  java会把另一个操作数也变为字符串类型

    //  ===========当类名/对象名 作为输出函数的参数时  会自动调用该类的toString()方法===========

    public String toString()    //这里就是对toString()的重写
    {
        return "date = "+fangfa.Year() + " " + fangfa.MonthDay();
    }
}

//如果一个方法不需要操作类中的任何的实例变量 则考虑将这个方法设计成为一个类方法
class test
{
    static int add(int x,int y)
    {
        return x + y;
    }
}