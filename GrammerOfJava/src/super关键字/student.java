package super关键字;

import org.omg.PortableServer.IdUniquenessPolicyValue;
import 子类与父类.Student;

public class student
{
    int num;
    String name;
    student()   //默认的构造方法  不可以省略  防止子类省略super是出现错误
    {

    }
    student(int num, String name)  //父类对构造方法的重写
    {
        this.num = num;
        this.name = name;
        System.out.println("我的名字是:" + name + " 学号是:" + num);  //输出写在构造方法里  调用构造方法时会自动输出
    }
}


class universitystu extends student  //There is no default constructor available in 'super关键字.student'
{                               //如果子类的构造方法没有明显的指出使用父类的哪个构造方法  那么默认的调用无参数的构造方法
                                //所以父类的默认的构造方法不可以省略
    boolean ifmarried;
    universitystu(int num,String name, boolean b)
    {
        super(num,name);  //在子类的构造方法中用super关键字来调用父类的构造方法  对num name成员变量进行赋值
        ifmarried = false;
        System.out.println("婚否 = "+b);
    }
}