import java.util.NoSuchElementException;
import java.util.Iterator;

public class datastructures
{
}

/*------------    实现字符串类型的容量固定的栈             -------------*/
class FixedCapacityStackOfStrings
{
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int capacity)
    {
        a = new String[capacity];
        N = 0;
    }

    public boolean isEmpty()
    {
        return N==0;
    }

    public int size()
    {
        return N;
    }

    public void push(String s)
    {
        a[N++] = s;
    }

    public String pop()
    {
        return a[--N];   //N是字符串的个数   下标要减一
    }
}

/*------------         实现泛型的容量固定的栈          -------------*/

class FixedCapacityStack<Item>
{
    private Item[] a;
    private int N;

    public FixedCapacityStack(int capacity)
    {
        //a = new Item[capacity];   不可以这样
        a = (Item[]) new Object[capacity];  //创造泛型数组要这样
        //先创建一个Object对象的数组Object[],并强转为Item[]
        N = 0;
    }

    public boolean isEmpty()
    {
        return N==0;
    }

    public  int size()
    {
        return N;
    }

    public  void push(Item s)
    {
        a[N++] = s;
    }

    public  Item pop()
    {
        return a[--N];   //N是字符串的个数   下标要减一
    }
}

/*------------         实现可以调整大小且有迭代方法的栈          -------------*/

class ResizingArrayStack<Item> implements Iterable<Item>
{
    //private int init_capacity = 8;
    private Item[] a;
    private int N;

    public ResizingArrayStack(int capacity)
    {
        //a = new Item[capacity];   不可以这样
        a = (Item[]) new Object[capacity];  //创造泛型数组要这样
        //先创建一个Object对象的数组Object[],并强转为Item[]
        N = 0;
    }

    public boolean isEmpty()
    {
        return N==0;
    }

    public  int size()
    {
        return N;
    }

    public void push(Item s)
    {
        if(a.length>=N)
        {
            resize(a.length<<1);
        }
        a[N++] = s;
    }

    public  Item pop()
    {
        if(isEmpty())
            throw new NoSuchElementException("Stack underflow");
        Item temp = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length>>2)
            resize(a.length>>1);
        return temp;   //N是字符串的个数   下标要减一
    }

    private void  resize(int cap)
    {
        //assert cap >=N;

        Item[] temp = (Item[])new Object[cap];
        for(int i=0;i<N;i++)
        {
            temp[i] = a[i]; //将原来数组的每个元素都复制
        }
        a = temp;   //只将引用赋值给a  效率很高
    }

    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }
    //返回一个迭代器ReverseArrayIterator
    //是一个要实现hasNext和next方法的类的对象

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i;

        public ReverseArrayIterator()
        {
            i = N-1;
        }

        public boolean hasNext()
        {
            return i >= 0;
        }

        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }
}

/* --------------------     实现可以调整大小且有迭代方法的队列              ------------------------------*/

class ResizingArrayQueue<Item> implements Iterable<Item>
{
    // initial capacity of underlying resizing array
    //private static final int INIT_CAPACITY = 8;

    private Item[] q;       // 队列元素
    private int n;          // 队列元素个数
    private int first;      // 队头元素指针(下标)
    private int last;       // index of next available slot 队尾元素指针(下标)

    public ResizingArrayQueue(int capacity)
    {
        q = (Item[]) new Object[capacity];
        n = 0;
        first = 0;
        last = 0;
    }
    public boolean isEmpty()
    {
        return n == 0;
    }

    public int size()
    {
        return n;
    }

    private void resize(int cap)
    {
        //assert cap >= n;
        Item[] copy = (Item[]) new Object[cap];
        for (int i = 0; i < n; i++) {
            copy[i] = q[(first + i) % q.length];
        }
        q = copy;
        first = 0;
        last  = n;
    }

    public void enqueue(Item item)
    {
        // double size of array if necessary and recopy to front of array
        if (n == q.length) resize(q.length<<1);   // double size of array if necessary
        q[last++] = item;                        // add item
        if (last == q.length)
            last = 0;          // wrap-around
        n++;
    }

    public Item dequeue()
    {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item item = q[first];
        q[first] = null;                            // to avoid loitering
        n--;
        first++;
        if (first == q.length) first = 0;           // wrap-around
        // shrink size of array if necessary
        if (n > 0 && n == q.length>>2)
            resize(q.length>>1);
        return item;
    }

    public Item peek()
    {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        return q[first];
    }

    public Iterator<Item> iterator()
    {
        return new ArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item>
    {
        private int i = 0;
        public boolean hasNext()
        {
            return i < n;
        }
        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }
}

//===================================以上用数组实现====================================

//===================================下面用链表实现====================================


/* --------------------     实现Stack              ------------------------------*/
class Stack<Item> implements Iterable<Item>
{
    private Node<Item> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty stack.
     */
    public Stack()
    {
        first = null;
        n = 0;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size()
    {
        return n;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(Item item)
    {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public Item pop()
    {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public Item peek()
    {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
        {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<Item> iterator()
    {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item>
    {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first)
        {
            current = first;
        }

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}


/* --------------------     实现Queue              ------------------------------*/
class Queue<Item> implements Iterable<Item>
{
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty queue.
     */
    public Queue()
    {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size()
    {
        return n;
    }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Item peek()
    {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    public void enqueue(Item item)
    {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue()
    {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
        {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()
    {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item>
    {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first)
        {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}



/* --------------------     实现Bag              ------------------------------*/
class Bag<Item> implements Iterable<Item>
{
    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag

    // helper linked list class
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty bag.
     */
    public Bag()
    {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this bag is empty.
     *
     * @return {@code true} if this bag is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    public int size()
    {
        return n;
    }

    /**
     * Adds the item to this bag.
     *
     * @param  item the item to add to this bag
     */
    public void add(Item item)
    {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    public Iterator<Item> iterator()
    {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item>
    {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first)
        {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}