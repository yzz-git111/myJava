import java.io.*;


public class method3_加权quickunion
{
    public static void shuchu()
    {
        System.out.println("算法三 加权quickunion");
    }
}

class WeightedQuickUnionUF extends UF
{
    private int[]id;    //以触点作为索引
    private int[]size;   //根节点对应的分量的大小
    private int count;

    public WeightedQuickUnionUF(int N)   //构造方法 用于初始化触点
    {
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++)
        {
            id[i] = i;  //初始化每个触点都是根节点
        }
        size = new int[N];
        for(int j=0;j<N;j++)
        {
            size[j] = 1;    //初始化每个根节点对应的连通分量大小都是1
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
        if(size[pRoot]<size[qRoot]) //将小的树连接到大的树上
        {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot]; //大的树的size增大
        }
        else
        {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
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
        System.out.print("sz");
        for (int i=0;i<size.length;i++)
        {
            System.out.print("  "+size[i]);
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
        method3_加权quickunion.shuchu();
        sumfile("D:\\JAVA_CODE\\AlgorithmsByBook\\DataForTest\\tinyUF.txt");
    }


    static void sumfile(String filename) throws IOException
    {
        int p=0,q=0,N=0;
        FileReader file = new FileReader(filename);
        Reader reader = new BufferedReader(file);
        StreamTokenizer stok = new StreamTokenizer(reader);
        stok.parseNumbers();
        stok.nextToken();
        N = (int)stok.nval;
        WeightedQuickUnionUF uf3 = new WeightedQuickUnionUF(N);
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
            uf3.union(p,q);
            uf3.draw();
        }
    }
}
