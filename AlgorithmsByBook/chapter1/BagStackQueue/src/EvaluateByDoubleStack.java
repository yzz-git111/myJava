import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class EvaluateByDoubleStack
{
    //private static datastructures.Bag<Object> StdIn;
    //String expression = (1+(2+3)*(4*5));
    //Evaluate test1 = new Evaluate();
    // ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )

    public static void main(String args[])
    {
        ResizingArrayStack<Character> ops = new ResizingArrayStack<Character>(20);
        ResizingArrayStack<Double> val = new ResizingArrayStack<Double>(20);
        String expression = Readexpression.ReadFile("D:\\JAVA_CODE\\AlgorithmsByBook\\DataForTest\\DijkstraDoubleStack.txt");
        char s;
        for(int i=0;i<expression.length();i++)
        {
            s = expression.charAt(i);
            if(s == '(');
            else if(s =='+')  {ops.push(s);}
            else if(s == '-')  {ops.push(s);}
            else if(s == '*')  {ops.push(s);}
            else if(s == '/')  {ops.push(s);}
            else if(s == ')')
            {
                char op = ops.pop();
                double v = val.pop();
                if(op == '+') {v = val.pop() + v;}
                else if(op == '-') {v = val.pop() - v;}
                else if(op == '*') {v = val.pop() * v;}
                else if(op == '/') {v = val.pop() / v;}
                val.push(v);
            }
            else
            {
                val.push(Double.parseDouble(""+s));
            }
        }
        System.out.println("表达式的值是:"+val.pop());


        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个字符串");
        while(scanner.hasNext())
        {
            String str = null;
            str = scanner.next();
            System.out.println(str);
        }

    }


}

class Readexpression
{
    public static String ReadFile(String filepath)
    {
        String result = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filepath));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null)
            {//使用readLine方法，一次读一行
                result = result + s;
            }
            br.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}


