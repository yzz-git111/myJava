package 子类与父类;

public class Student extends people   //Student继承people  Student作为子类 people作为父类
{
    int num;    //继承了父类的成员变量 age hand leg
    void tellNumber()
    {
        System.out.println("学号:"+num);
    }
    int add(int x,int y)
    {
        return x+y;
    }
}