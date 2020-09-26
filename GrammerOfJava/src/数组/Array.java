package 数组;
//import java.util.*;
public class Array
{
    public static void main(String args[])
    {
        int []Array1  = new int[3];  //申明数组方法1

        int []Arrary2;
        Arrary2 = new int[4];       //方法2  声明的时候不要指明数组大小


        Array1[0] = 5;
        Array1[1] = 42;
        System.out.println("Array1[0] = "+Array1[0]+"Array1[1] = "+Array1[1]);
        System.out.println("Array1的引用是"+Array1);   //引用即首地址
        for(int i=0;i<Array1.length;i++)   //length为数组元素的个数
        {
            System.out.print("  Array1[i] = "+Array1[i]);
        }

        int myarr[][] = new int[3][];     //二维数组  先申明行数:3
        myarr[0] = new int[4];          //在依次声明列数
        myarr[1] = new int[2];
        myarr[2] = new int[6];

        int size = 4;
        int []Array3 = new int[size];  //java允许用int的变量指定数组的值的个数  c不可以

        //对于char类型的数组 System.out.println(a);输出的a数组的全部元素而不是a的引用
        char []a = {'彭','于','晏'};
        System.out.println(a);   //输出结果是彭于晏
        System.out.println(""+a);   //输出结果才是a的引用
    }
}
