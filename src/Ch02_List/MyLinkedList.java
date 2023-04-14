package Ch02_List;

import javax.swing.*;

public class MyLinkedList<T> implements MyList<T> {
    private int size;
    private Node head; // 더미 노드

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(null); // 더미노드
    }

    @Override
    public void add(T t) {
        Node curr =  this.head;
        while (curr.next != null) { // null이 아닌 곳까지 찾아가야 한다.
            curr = curr.next;
        }
        curr.next = new Node(t);
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node prev = this.head;
        Node curr = prev.next;
        int i = 0;
        while (i++ < index) {
            prev = prev.next;
            curr = curr.next;
        }
        Node node = new Node(t, curr);
        prev.next = node;
        this.size++;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.size = 0;
    }

    @Override
    public boolean delete(T t) {
        Node prev = this.head;
        Node curr = prev.next;
        while (curr != null) {
            if (curr.data.equals(t)) {
                prev.next = curr.next;
                curr.next = null;
                this.size--;
                return true;
            }
            prev = prev.next;
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= this.size) { // this.size와 같으면 curr이 null이 될 수 있다.
            throw new IndexOutOfBoundsException();
        }
        Node prev = this.head;
        Node curr = prev.next;

        int i = 0;
        while (i++ < index) {
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = curr.next;
        curr.next = null;
        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node curr = this.head.next;
        int i = 0;
        while (i++ < index) {
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public int indexOf(T t) {
        Node curr = this.head.next;
        int index = 0;
        while (curr.next != null) {
            if (curr.data.equals(t)) {
                return index;
            }
            curr = curr.next;
            index++;

        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null ? true : false;
    }

    @Override
    public boolean contains(T t) {
        Node curr = this.head.next;
        while (curr.next != null) {
            if (curr.data.equals(t)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("LinkedList = [");
        Node curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
            builder.append(curr.data).append(curr.next == null ? "" : ", ");
        }
        builder.append("]");
        return builder.toString();
    }
}
