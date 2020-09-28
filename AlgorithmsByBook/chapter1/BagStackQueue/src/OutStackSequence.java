public class OutStackSequence
{
    public static void fun1(int []a)
    {
        Stack<Integer> sequence = new Stack<Integer>();
        int n = a.length;
        int i = 0,j = 0;
        while(i<n && j<=n)
        {
            if(!sequence.isEmpty() && sequence.peek()==a[i])
            {
                System.out.print(sequence.pop()+"  ");
                i++;
            }
            else
            {
                if(j<n)     //防止第十个元素进去
                {
                    sequence.push(j);
                }
                j++;
            }
        }
        System.out.println("还剩"+sequence.size()+"个元素");
    }

    public static void main(String args[])
    {
        int []a1 = {4,3,2,1,0,9,8,7,6,5};
        int []a2 = {4,6,8,7,5,3,2,9,0,1};
        //Stack<Integer> sequence;
        //OutStackSequence.fun1(a1);
        OutStackSequence.fun1(a2);

    }
}
