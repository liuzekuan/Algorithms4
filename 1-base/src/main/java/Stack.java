/**
 * @author liuzk
 * @version 1.0
 * @create 2022-02-17 21:20
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author liuzk
 * @version 1.0
 * @create 2022-02-13 14:45
 */
public class Stack<Item> implements Iterable<Item>{
    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public void push(Item item) {
        Node newNode = new Node();
        newNode.next = first;
        newNode.item = item;
        first = newNode;
        n++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }
    public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return first.item;
    }
    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator iterator() {
        return new NodeIterator();
    }

    /**
     * 迭代器，遍历栈
     */
    private class NodeIterator implements Iterator<Item>{
        private Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item=current.item;
            current=current.next;
            return item;
        }
    }
}

