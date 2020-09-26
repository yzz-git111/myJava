package test;

/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

public class test
{
/*    public static void main(String args[])
    {
        int []a = {10,20,30,40};
        int []b[] = {{1,2},{4,5,6,7}};
        b[0] = a;
        b[0][1] = b[1][3];
        System.out.println(a[1]);
    }*/

/*    int a = 10;
    public void fun()
    {
        System.out.println("fun");
    }

    protected void fun0()
    {
        System.out.println("fun0");
    }*/

/*    public static void main(String[] args) throws IOException
    {
        BufferedReader bf=new BufferedReader(new FileReader("D:\\JAVA_CODE\\AlgorithmsByBook\\DataForTest\\tinyUF.txt"));
        String textLine;
        String str = "2";
        while((textLine = bf.readLine()) != null)
        {
            str+=""+textLine;
        }
        String[] numbers=str.split("	");
        int []number=new int[numbers.length];
        for (int i = 1; i < numbers.length; i++)
        {
            number[i]=Integer.parseInt(numbers[i]);
            //double []number=new double[numbers.length];
            //number[i]=Double.parseDouble(numbers[i]);
            System.out.println(number[i]);
        }
        bf.close();*/
       /* String s = "4 3";
        char c = s.charAt(1);
        System.out.println((int)c);*/




// The buffering makes the program more than 20 times faster.
    public static void main(String[] a) throws IOException
    {
        sumfile("D:\\JAVA_CODE\\AlgorithmsByBook\\DataForTest\\tinyUF.txt");
    }


    static void sumfile(String filename) throws IOException
    {
        FileReader file = new FileReader(filename);
        Reader r = new BufferedReader(file);
        StreamTokenizer stok = new StreamTokenizer(r);
        stok.parseNumbers();
/*        double sum = 0;*/
        int sum = 0;
        stok.nextToken();
        while (stok.ttype != StreamTokenizer.TT_EOF)
        {
            System.out.println((int)stok.nval);
            System.out.println(stok.sval);
            if (stok.ttype == StreamTokenizer.TT_NUMBER)
                sum += stok.nval;
            else
                System.out.println("Nonnumber: " + stok.sval);
            stok.nextToken();
        }
        System.out.println("The file sum is " + sum);
    }
}
