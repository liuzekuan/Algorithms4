package ex1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 构建链表结构
 * @author liuzk
 * @version 1.0
 * @create 2022-02-25 22:09
 */
public class Ex19_ListNode<Item> implements Iterable<Item> {
    public Node first;
    private int size;

    /**
     * 定义链表的节点
     */
    public class Node {
        Node next;
        Item item;
    }
    @Override
    public Iterator<Item> iterator() {

        return new ListIterator();
    }

    /**
     * 链表的长度
     * @return
     */
    public int size() {
        return size;
    }
    /**
     * 判断链表是否为空
     */
    public boolean isEmpty() {
        return size==0;
    }
    /**
     * 新增数据
     */
    public void add(Item item) {
        if (isEmpty()) {
            Node newNode=new Node();
            newNode.item=item;
            first = newNode;
        } else {
            Node current=first;
            while(current.next!=null){
                current=current.next;
            }
            Node newNode=new Node();
            newNode.item=item;
            current.next=newNode;
        }
        size++;
    }
    /**
     * 链表迭代
     */
    private class ListIterator implements Iterator {
        private Node current;

        public ListIterator() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size() == 1) {
            first=null;
        }else{
            Node current=first;
            int count=1;
            while (count!=size()-1) {
                current=current.next;
                count++;
            }
            current.next=null;
        }
        size--;
    }

    public static void main(String[] args) {
        Ex19_ListNode<String> strList = new Ex19_ListNode<>();
        strList.add("1212");
        System.out.println("size===="+strList.size());
        strList.removeLast();
        System.out.println("size===="+strList.size());
        for (String str : strList) {
            System.out.println(str);
        }
    }

}
