package 访问权限修饰符;
import test.test;  //要调用别的包的类 需要import

public class main
{
    public static void main(String args[])
    {
        Jerry jerry = new Jerry();
        jerry.g();

        test test = new test();
        /*test.fun();*/
        //test.fun0();  fun0()是被protected修饰的  不能被调用

        //被public修饰的在不同的包都可以调用  但是需要import包
        //修饰符的权限由高到低是: public > protected > 友好的 > private
    }
}

class Tom
{
    private float weight;               //private修饰符
    private float f(float a,float b)
    {
        return a+b;
    }
    protected int fun()
    {
        System.out.println("function1");
        return 1;
    }
    static protected void fun2()
    {
        System.out.println("function2");
    }
}

class Jerry
{
    void g()  //不用private，public，protected修饰的为友好变量/友好方法
                //作用范围也是同一个包中
    {
        Tom cat = new Tom();  //在Jerry类创建了一个Tom类的对象cat
        //cat.weight();  or  cat.f()都是非法的 因为成员变量weight和成员方法f都是被private修饰的  只可以在Tom类被引用
        cat.fun();      //protected修饰的成员在同一个包（这里是packet 访问权限修饰符）中可以调用
        Tom.fun2();  //fun2是静态方法  所以可以直接用Tom调用

        Helen girl = new Helen();  //同一个包下面
        girl.a = 2;
        girl.fun3();  //protected的范围仅限于同一个包下
    }
}