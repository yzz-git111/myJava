package final关键字;

//final只能用来保证原始数据类型的实例变量的不可变性 而无法用于引用类型的变量
//如果一个引用类型的实例变量含有修饰符final  该实例变量的值（某个对象的引用）就无法改变
//但是变量本身任然可变

import java.util.Vector;

public class specialcase
{
    public static void main(String args[])
    {
        double[] a = {3.0, 4.0};    //创建了一个2个元素的数组a
        Vector1 vector = new Vector1(a);  //用new自动调用构造方法  a和vector.coords都指向的是同一个引用
        System.out.println("a[0] = "+a[0] +" coords[0] = "+ vector.coords[0]);
    }
}

class Vector1
{

    protected final double[] coords;  //double数组coords是Vector1的final成员变量  理论是不可以修改的
    //double[] a = {3.0, 4.0};    //创建了一个2个元素的数组a
    public Vector1(double[] a)
    {
        coords = a;       //构造方法来初始化final修饰的成员变量
        a[0] = 0.0;  //这样同时改变了a和final修饰的成员变量coords  同时改为0.0
        //虽然coords被final修饰  相当于一个常量  但是通过对它的一个引用来修改引用的值而改变本身的值 相当于c中操作指针
   }
/*    public String toString()
    {
        return "a[0] = "+a[0] +" coords[0] = "+coords[0];
    }*/
}
