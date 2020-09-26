package 继承与多态;

//多态性就是指 父类的某个方法被子类重写时  可以各自产生自己的功能行为
//即不同的子类可以有不同的方法

public class main
{
    public static void main(String args[])
    {
        dog.cry();      //cry方法不需要具体的成员变量  在类加载到内存的时候就可以直接通过"类名."调用
        cat.cry();      // 将cry定义为static 的好处就是可以不用创建对象就可以调用成员变量/函数
        //cry()可以定义为static  是因为它不使用任何的实例变量  且static修饰的方法可以有参数
    }
}

//animal是一个抽象的概念 但是animal都具有cry的方法  且不同的子类有不同的cry的方法  运用多态可以完美的解决
//这与抽象类/接口的思想类似

class animal
{
    static void cry()
    {

    }
}

final class dog extends animal
{
   static void cry()        //dog 继承了 animal  可以实现自己的cry
    {
        System.out.println("汪汪汪");
    }
}

final class cat extends animal
{
    static void cry()       //cat 继承了 animal  可以实现自己的cry
    {
        System.out.println("喵喵喵");
    }
}