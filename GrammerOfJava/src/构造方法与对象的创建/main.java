package 构造方法与对象的创建;

public  class main
{
    public static void main(String args[])
    {
        xiyourenwu zhubajie = new xiyourenwu();   //创建一个xiyourenwu类的对象 zhubajie

        xiyourenwu sunwukong;  //方法二  先声明一个对象
        sunwukong = new xiyourenwu();   //然后为对象分配变量
    }
}

class Gouzafangfa
{
    int i,j;

    Gouzafangfa()  //构造方法
    {
        i = 1;
        j = 1;
    }
    Gouzafangfa(int m, int n)  //构造方法的方法重载  通过参数的不同而调用不同的构造方法
    {                           //系统默认一个无参数 无操作的构造方法
        i = m;
        j = n;
    }

    void Gouzafangfa()
    {
        //这只是返回值为void 的函数 不是对构造方法 的重载
    }
}

class xiyourenwu
{
    float height,weight;
    String head,ear;
    void speak(String s)        //类中的一个方法
    {
        System.out.println(s);
    }
}