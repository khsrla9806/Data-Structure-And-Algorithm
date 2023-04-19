package Ch03_Stack;

public class MyStackClass<T> implements MyStack<T> {

    private int size;
    private Node head;

    public MyStackClass() {
        this.size = 0;
        this.head = new Node(null);
    }
    @Override
    public void push(T data) {
        Node node = new Node(data, this.head.next);
        this.head.next = node; // Head의 Next는 항상 최신의 노드를 가리키게된다.
        this.size++;
    }

    @Override
    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        Node curr = this.head.next;
        this.head.next = curr.next;
        curr.next = null;
        this.size--;
        return curr.data;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.head.next.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean isEmpty() {
        return this.head.next == null;
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
