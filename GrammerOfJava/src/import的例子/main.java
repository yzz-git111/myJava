package import的例子;
import java.util.Date;   //java,util包含实用类
                        //import java.util.Date 表示只引入java.util包中的Data类

public class main
{
    public static void main(String args[])
    {
        Date data = new Date();
        System.out.println("本机的时间：");
        System.out.println(data.toString());
    }
}
