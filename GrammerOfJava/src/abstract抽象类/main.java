package abstract抽象类;

//1 abstract修饰的类不可以用new创建该类的对象

//2 abstract修饰的方法只允许声明而不允许实现  不可以调用
// 且不可以用final和abstract修饰同一个类/方法 （因为如果一个非抽象类是某个抽象类的子类 那么他就必须重写父类的抽象方法 就要给出方法体）
// 也不允许static修饰abstract  即abstract必须是实例方法（对象才能调用的方法）
//abstract类中可以也可以没有abstract方法

//3 若干一个非abstract类是abstract类的子类  那么它必须重写父类的abstract方法 即去掉abstract关键词而给出方法体
//如果一个abstract类是abstract类的子类  那么它可以重写父类的abstract方法 也可以继承

//4 尽管abstract类不可以new对象   但是它可以成为子类对象的上转型对象  那么这个对象就可调用子类重写的方法
public class main
{
    public static void main(String argsp[])
    {
        GirlFriend girl = new ChinaGirlFriend();  //girl是上转型对象 ： 将ChinaGirlFriend（子类）的对象赋值给Girlfriend（父类）的对象
        Boy boy = new Boy();
        boy.setGirlFriend(girl);
        boy.showGirlFriend();
        girl = new AmericanGirlFriend();   //girl是上转型对象
        boy.setGirlFriend(girl);
        boy.showGirlFriend();
    }
}

abstract class GirlFriend
{
    abstract void speak();   //abstract修饰某一成员方法  只给出函数的声明  而不给出具体的函数体
    abstract void cooking();
}

class ChinaGirlFriend extends GirlFriend
{   //若干一个非abstract类是abstract类的子类  那么它必须重写父类的abstract方法 即去掉abstract关键词而给出方法体
    void speak()
    {
        System.out.println("你好");
    }
    void cooking()
    {
        System.out.println("我会烧饭");
    }
}

class AmericanGirlFriend extends GirlFriend
{   //若干一个非abstract类是abstract类的子类  那么它必须重写父类的abstract方法 即去掉abstract关键词而给出方法体  不实现会报错
    void speak()
    {
        System.out.println("Hello");
    }
    //static void cooking()不可以
    //static修饰的方法不能因为继承被覆盖；父类，子类可有相同名、同参数的方法，两者可共存，不构成覆盖；也就是说这两者形成两个不同的“类方法”。
    //由此可推断，static修饰的方法属于类，而与子父类的继承无关；
    //得出结论：static修饰的方法不存在继承性，这与abstract修饰的方法相矛盾。
    void cooking()
    {
        System.out.println("I can cook food");
    }
}

class Boy
{
    GirlFriend friend;
    void setGirlFriend(GirlFriend f)
    {
        friend = f;
    }
    void showGirlFriend()
    {
        friend.speak();
        friend.cooking();
    }
}