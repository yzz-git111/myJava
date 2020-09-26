package 对象的上转型对象;

//用子类创建一个对象  并把这个对象的引用放到父类的对象中

//上转型对象不可操作新增的成员变量和成员方法
//上转型对象可以访问子类继承或者隐藏（通过重写）的成员变量/方法
//如果子类重写了父类的某个实例方法 那么上转型对象调用这个实例方法一定调用的是  子类重写的实例方法

public class main
{
    public static void main(String args[])
    {
        monkeyandhuman monkey = new monkeyandhuman();  //父类创建了一个对象 monkey
        people zhang = new people();                //子类创建了一个对象zhang
        monkey = zhang;             //将子类创建的对象 的引用赋给父类创建的对象
                            //此时 monkey（父类的对象）就是zhang（子类的对象）的上转型对象（理解为:zhang是monkeyandhuman）
        monkey.cryspeak("i love this game!");  //等价于 zhang.cryspeak("i love this game!");
        //monkey作为上转型对象  调用cryspeak时一定调用的是子类重写的

        //monkey.computer(10,10)会报错 因为computer是子类新增的方法

        people people = (people)monkey;     //将上转型对象强制转为子类的对象
        people.computer(10,10);     //这时的people是 people类的对象  可以调用people类新增的成员方法
    }
}

class monkeyandhuman
{
    void cryspeak(String s)
    {
        System.out.println(s);
    }
}
class people extends monkeyandhuman
{
    void computer(int a,int b)
    {
        int c = a * b;
        System.out.println(c);
    }
    void cryspeak(String s)  //子类重写cryspeak 子类重写了父类的某个实例方法 那么上转型对象调用这个实例方法一定调用的是  子类重写的实例方法
    {
        System.out.println("====="+s+"=====");
    }
}