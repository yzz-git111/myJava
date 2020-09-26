package 优化小tips;

public class tip2
{
    public void qiuhe()
    {
        //求 1 + 1/（2!） + 1/(3!) + 1/(4!) ...
        double base = 1.0;
        double sum = 0.0;
        for(int i=1;i<=4;i++)
        {
            base = base/i;         //每次base都更新为i的阶乘  那么下一次只需要除以i+1 即可得到i+1的阶乘  而不需要每次都计算i的阶乘
            System.out.println(" sum = "+sum+" base = "+base);
            sum = sum + base;
        }
        System.out.println("计算的值是:"+sum);
    }
}
