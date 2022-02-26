package ex1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 基于动态数组的队列实现
 * @author liuzk
 * @version 1.0
 * @create 2022-02-20 16:50
 */
public class ResizingArrayQueue<Item> implements Iterable<Item>{
    //定义数组
    private Item[] arr;
    //定义头指针
    private int head;
    //定义尾指针
    private int tail;
    public ResizingArrayQueue() {
        //默认数组初始化大小是10
        arr = (Item[]) new Object[10];
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return tail==head;
    }
    //从队列中取出元素
    public Item deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空");
        }
        if (size() ==arr.length/4) {
            //缩小至原来数组的1/2,为了增加元素时不用再扩容
            resize(arr.length/2);
        }
        return arr[head++];
    }
    public int size() {
        return tail-head;
    }
    //向队列中添加元素
    public void enQueue(Item item) {
        if (size() == arr.length) {
            //扩容至原来数组的两倍
            resize(2*arr.length);

        }
        arr[tail++] = item;

    }

    /**
     * 重定义数组长度
     * @param length
     */
    private void resize(int length) {
        Item[] newArr=(Item[]) new Object[length];
        for (int i=head,j=0;i<tail;i++,j++) {
            newArr[j] = arr[i];
        }
        tail=tail-head;
        head=0;
        arr=newArr;
    }

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    public class QueueIterator implements Iterator{
        private Item[] copyArr=arr;
        private int copyHead=head;
        private int copyTail=tail;
        @Override
        public boolean hasNext() {
            return copyTail!=copyHead;
        }

        @Override
        public Item next() {
            return copyArr[copyHead++];
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> test = new ResizingArrayQueue();
        test.enQueue("test");
        test.enQueue("2");
        test.enQueue("3");
        test.enQueue("4");
        test.enQueue("8");
        test.enQueue("9");
        test.enQueue("10");
        test.enQueue("11");
        test.enQueue("12");
        test.enQueue("13");
        test.enQueue("19");
        System.out.println(test.deQueue());
        System.out.println(test.deQueue());
        System.out.println(test.deQueue());
        System.out.println(test.deQueue());
        System.out.println(test.deQueue());
        System.out.println(test.deQueue());
        System.out.println(test.deQueue());
        for (String str : test) {
            System.out.println(str);
        }
        Object[] arr1 = test.arr;
        System.out.println(arr1.length);
    }
}
