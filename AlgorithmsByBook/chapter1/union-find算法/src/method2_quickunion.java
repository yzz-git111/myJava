import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
public class method2_quickunion
{
    public static void shuchu()
    {
        System.out.println("方法二  quick-find算法");
    }
}

class UF2 extends UF
{
    private int[]id;    //以触点作为索引
    private int count;

    public UF2(int N)   //构造方法 用于初始化触点
    {
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++)
        {
            id[i] = i;
        }
    }

    public int getCount()  //用于返回private成员count 即连通分量的数目
    {
        return count;
    }

    public boolean connected(int p,int q)   //判断触点p和q是否在同一连通分量内
    {
        return find(p)==find(q);
    }

    public int find(int p)  //返回p的连通分量
    {
        while(p != id[p])
        {
            p = id[p];
        }
        return p;
    }

    public void union(int p,int q)  //将触点p和q连接到统一连通分量
    {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)  //p,q已经统一连通分量  空操作
        {
            return;
        }
        id[pRoot] = qRoot;  //直接连接到根触点下
        count--;    //一次union  count自减1
    }

    public void draw()
    {
        System.out.print("i ");
        for (int i=0;i<id.length;i++)
        {
            System.out.print("  "+i);
        }
        System.out.println();
        System.out.print("id");
        for (int i=0;i<id.length;i++)
        {
            System.out.print("  "+find(i));
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }


    public static void main(String args[]) throws IOException
    {
        method2_quickunion.shuchu();
        sumfile("D:\\JAVA_CODE\\AlgorithmsByBook\\DataForTest\\tinyUF.txt");
    }


    static void sumfile(String filename) throws IOException
    {
        int p=0,q=0,N=0;
        FileReader file = new FileReader(filename);
        Reader reader = new BufferedReader(file);
        StreamTokenizer stok = new StreamTokenizer(reader);
        stok.parseNumbers();
        /* double sum = 0;*/
/*        if(stok.ttype != StreamTokenizer.TT_EOF)
        {
            if (stok.ttype == StreamTokenizer.TT_NUMBER)
            {
                N = (int)stok.nval;
            }
        }*/
        stok.nextToken();
        //stok.nextToken();
        N = (int)stok.nval;
        UF2 uf2 = new UF2(N);
        while (stok.ttype != StreamTokenizer.TT_EOF)
        {
            if (stok.ttype == StreamTokenizer.TT_NUMBER)
            {
                stok.nextToken();
                p = (int)stok.nval;

                stok.nextToken();
                q = (int)stok.nval;
            }
            System.out.println("p = "+p+" q = "+q);
            uf2.union(p,q);
            uf2.draw();
        }
    }
}
