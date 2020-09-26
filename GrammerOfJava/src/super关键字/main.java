package super关键字;

public class main
{
    public static void main(String args[])
    {
        //super操作被隐藏的成员变量和成员方法
        average ave = new average();
        ave.n = 100;
        //float result1 = ave.f();   //（1+2+。。。+100）/100
        float result2 = ave.g();    //（1+2+。。。+100）/2
        float result1 = ave.f();   //（1+2+。。。+100）/100
        System.out.println("result1 = "+ result1);
        System.out.println("result2 = "+result2);


        //super操作父类的构造方法
        //用子类的构造方法创建一个子类的对象的时候 子类的构造方法总是先调用父类的构造方法
        //如果子类的构造方法没有明显的指出使用父类的哪个构造方法  那么默认的调用无参数的构造方法
        universitystu zhang = new universitystu(9901,"和晓玲",false);
    }
}

class sum
{
    int n;
    float f()
    {
        float sum = 0;
        //for(int i:n)   foreach not applicable to type 'int'  foreach 用于数组
        for(int i=1;i<=n;i++)
        {
            sum = sum + i;
        }
        return sum;
    }
}

class average extends sum
{
    int n;   //average 继承了 sum 同时在average中有定义了一个int 的n  即重写了成员变量n 并且隐藏了继承的n 此时子类继承的父类的成员变量n归关键字super
    float f()
    {
        float c;
        super.n = n;        //要通过"super."来调用被隐藏的成员变量  将自己的n赋值给父类的n  父类在子类创建的同时也被创建了
        c = super.f();      //通过“super.”调用父类的成员方法
        return c/n;
    }
    float g()
    {
        float c;
        c = super.f();      //调用父类的成员方法f（）  计算和
        return c/2;
    }

}
/*float result2 = ave.g();
    float result1 = ave.f();   //（1+2+。。。+100）/100 */
