package 对象数组;

public class main
{
    public static void main(String args[])
    {
        Student stu[] = new Student[10];   //创建了一个长度为10的对象数组
                                            //对象数组即数组的元素是对象
                                        //这里只是申明了一个对象数组
        for(int i=0;i<stu.length;i++)
        {
            stu[i] = new Student();     //这里要创建对象数组的每个元素（Student类的对象）
            stu[i].number = 101 + i;
        }
/*        for (int j=0;j<stu.length;j++)
        {
            System.out.println(stu[j].number);
        }
        for (int k=0;k<stu[0].zifu.length;k++)
        {
            stu[0].zifu[k] = k;
        }
        for(int m:stu[0].zifu)
        {
            System.out.printf("%4c",stu[0].zifu[m]);
        }
        //System.out.println(""+(char)(65));*/
    }
}

class Student
{
    int number;
}


