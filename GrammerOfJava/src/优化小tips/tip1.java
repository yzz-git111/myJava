package 优化小tips;

public class tip1
{
    public void qiuhe()
    {
        long sum = 0L;
        int jishu = 8;
        int item = jishu;
        for(int i=0;i <=11;i++)
        {
            sum = sum + item;
            item = item * 10 + jishu;  //每次保存上一次的乘以10之后的值  从而形成下一个加数  类似与动态规划  记录下数值而避免重复计算
            System.out.println("sum = "+sum+" item = "+item+" ");
        }
        System.out.println("8+88+888...的和="+sum);
    }
}
