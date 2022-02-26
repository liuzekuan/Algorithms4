package ex1_3; /**
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
public class Stack<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("123");
        stack.push("179");
        stack.push("1hfas");
        Stack<String> copy = Stack.copy(stack);
        for (String str : stack) {
            System.out.println("org="+str);
        }
        for (String str : copy) {
            System.out.println("copy="+str);
        }
    }
    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    /**
     * copy栈
     * 注意与原先的栈保持一直的顺序
     * 所以要循环两次
     * @param stack
     * @return
     */
    public static Stack<String> copy(Stack<String> stack){
        Stack<String> copyStack=new Stack<>();
        Stack<String> tempStack=new Stack<>();
        //实现了Iterable接口 可以使用增加for循环
        for (String item : stack) {
            tempStack.push(item);
        }
        Iterator<String> iterator = tempStack.iterator();
        //再遍历一次使其与原先的入栈顺序一致
        while (iterator.hasNext()) {
           copyStack.push(iterator.next());
        }
        return copyStack;
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
    private class NodeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

