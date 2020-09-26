package 子类与父类;

public class universityStu extends Student  //universityStu 继承 Student  universityStu 作为 people的子孙类
{
    int Multiple(int x,int y)       //继承父类 祖父类的 所有的非private修饰的成员变量和方法  包括num age..变量  showpeoplemess..方法
    {
        return x*y;
    }
}
