package 方法重写;

public class main
{
    public static void main(String args[])
    {
        B b = new B();
        double result =  b.computer(8,9);  //这里调用的是B对继承的成员方法的重构  从而隐含了父类的computer方法
        System.out.println(result);
        int m = b.g(12,8);    //B类的对象b调用继承的方法 g
        System.out.println(m);


        BB bb = new BB();
        Integer t = bb.get();
        System.out.println(t.intValue());
    }
}

class A
{
    float computer(float x, float y)
    {
        return x+y;
    }
    public int g(int x, int y)
    {
        return x+y;
    }
}

class B extends A  //B继承A
{
    float computer(float x ,float y)  //B对A的computer方法进行重写
                                        //重写时方法的类型（返回值）要和父类的方法的类型一致
    {
        return x*y;
    }
}


//重写的注意点
//重写方法的类型必须可以是父类方法的子类型
class AA
{
    Object get()       //Object类是所有类的祖先类（个人理解为对象类）  如果把所有类的继承关系看作一棵树 那么Object类就是树根
    {
        return null;  //返回一个空对象
    }
}
class BB extends AA
{
    Integer get()   //父类的方法的类型是Object的  子类重写的方法的类型是Integer的  Integer是Object的子类  所以完全正确
    {
        return new Integer(100);
    }
}
