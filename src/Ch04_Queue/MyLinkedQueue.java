package Ch04_Queue;

import Ch03_Stack.MyStackClass;

public class MyLinkedQueue<T> implements MQueue<T> {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedQueue() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = this.head;
    }

    @Override
    public void offer(T data) {
        Node node = new Node(data);
        this.tail.next = node;
        this.tail = this.tail.next;
        this.size++;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        Node node = this.head.next;
        this.head.next = node.next;
        node.next = null;
        this.size--;
        return node.data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return this.head.next.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.tail = this.head;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.tail.next == null;
    }

    private class Node {
        T data;
        Node next;

        Node (T data) {
            this.data = data;
        }

        Node (T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
