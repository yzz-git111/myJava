package 子类与父类;

public class main
{
    public static void main(String args[])
    {
        Student zhang = new Student();
        zhang.age = 17;
        zhang.num = 1001011;
        zhang.showPeopleMess();  //继承的父类的方法
        zhang.tellNumber();     //子类新定义的实例方法
        int x=9,y=25;
        System.out.println("会做加法");
        int result1 = zhang.add(x,y);   //子类新定义的实例方法
        System.out.printf("%d + %d = %d\n",x,y,result1);
        universityStu geng = new universityStu();
        geng.age = 21;
        geng.num = 6609;
        geng.showPeopleMess();
        geng.tellNumber();
        System.out.println("会做加法");
        int result2 = geng.add(x,y);
        System.out.printf("%d + %d = %d\n",x,y,result2);
        System.out.println("会做乘法");
        int result3 = geng.Multiple(x,y);
        System.out.printf("%d * %d = %d\n",x,y,result3);
    }
}

//public class people  一个java源文件中只能有一个public类  可以在新建一个类将每个类都修饰为public




