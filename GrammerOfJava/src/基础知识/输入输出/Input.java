package 基础知识.输入输出;
import java.util.Scanner;  //import数据包来调用输入函数

public class Input
{
    public void info()
    {
        System.out.println("请输入若干个数");
        System.out.println("最后输入的数为0则结束。");
    }

    Scanner reader = new Scanner(System.in);   //Scanner是系统包中的一个类 申明一个类的对象reader
    double sum = 0;

    public double qiuhe()
    {
        double x = reader.nextDouble();
        while(0 != x)
        {
            sum = sum + x;
            x = reader.nextDouble();
        }
        return sum;
    }
    public void out()
    {
        System.out.println("sum = "+qiuhe());
    }
}

//java可以print 可以println  可以printf
//其中 print不换行 println换行  printf和c/c++用法一样
