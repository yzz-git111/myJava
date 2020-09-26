package final关键字;

//final修饰的类不能被继承
// final修饰的常量不能被改变  在声明的时候就要初始化一个值
//final修饰的方法不允许继承的子类重写  即 不允许子类隐藏继承的final类


public class main
{
    public static void  main(String args[])
    {
        A a = new A();
        System.out.println("area = "+ a.getArea(1));

        B b = new B();
        b.getArea(0);  //B继承了A 所以B也有getArea;
        System.out.println("area = "+ b.getArea(0));
        System.out.println("area = "+ b.getperimeter(1));

        b.speak();

        //特例

    }
}

class A
{
    final double PI = 3.14;  //PI作为一个常数  完全可以将PI设置为final
    final double getArea(double r)
    {
        r = r + 1; //合法
        double area = PI * r * r;
        return area;
    }
    public void speak()
    {
        System.out.println("not final can be changed");
    }
}

class B extends A
{
    final double getperimeter(final double r)
    {
        //r = r + 1   非法 因为r被final修饰了  r是一个常数
        double perimeter = 2 * PI * r;
        return  perimeter;
    }
    public final void speak()
    {
        System.out.println("final can not be changed!");
        super.speak();
    }
}