package 实例成员与类成员;

public class main
{
    public static void main(String args[])
    {
        bianliang a = new bianliang(1.1f);
        bianliang b = new bianliang(2.2f);
        System.out.println("a的x="+a.x+" y="+bianliang.y);  //y是类成员 所以可以直接通过类名来调用
        System.out.println("b的x="+b.x+" y="+bianliang.y);   //对于不同的类 其类成员都是一样的  因为类成员只对应一个空间


        fangfa c,d;
        c = new fangfa();
        d = new fangfa();
        c.A(5);
        d.A(6);  //A作为实例方法  对于每次传递的参数的不同而不同
        fangfa.B();
        fangfa.C();  //作为类方法   不需要操作任何的实例变量  通过类名直接调用


        System.out.println( "100+100=" + test.add(100,100));  //test类的add方法是静态方法  可以通过类名直接调用
        // 且静态方法可以传递参数作为局部变量
        //当某个方法不涉及类的实例变量 就可以将其定义为静态方法

        fangfa test = new fangfa();
        System.out.println(test);   //这里会自动调用fangfa类的toString()方法
        //其实每个类都有一个从Object继承的toString()方法  但是这个方法是“空”  所以不对toString重写就System.out.println(test);只能输出空串

    }
}
