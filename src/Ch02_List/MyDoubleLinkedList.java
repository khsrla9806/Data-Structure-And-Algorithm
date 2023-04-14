package Ch02_List;

public class MyDoubleLinkedList<T> implements MyList<T> {

    private Node head;
    private Node tail;
    private int size;

    public MyDoubleLinkedList() {
        this.size = 0;
        head = new Node(null);
        tail = new Node(null);

        this.head.next = tail;
        this.tail.prev = head;
    }

    @Override
    public void add(T t) {
        Node last = this.tail.prev;
        Node node = new Node(t, last, this.tail);
        last.next = node;
        this.tail.prev = node;
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        Node prev = null;
        Node curr = null;

        int i = 0;
        if (index < this.size / 2) {
            prev = this.head;
            curr = this.head.next;

            while (i++ < index) {
                prev = prev.next;
                curr = curr.next;
            }
        } else {
            prev = this.tail.prev;
            curr = this.tail;

            while (i++ < (this.size - index)) {
                prev = prev.prev;
                curr = curr.prev;
            }
        }
        Node node = new Node(t, prev, curr);
        prev.next = node;
        curr.prev = node;
        this.size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = tail;
        this.tail.prev = head;
    }

    @Override
    public boolean delete(T t) {
        Node forward = this.head.next;
        Node backward = this.tail.prev;
        while (forward != backward && forward.prev != backward.next) {
            if (forward.data.equals(t)) {
                forward.prev.next = forward.next;
                forward.next.prev = forward.prev;
                forward.next = null;
                forward.prev = null;
                this.size--;
                return true;
            } else if (backward.data.equals(t)) {
                backward.prev.next = backward.next;
                backward.next.prev = backward.prev;
                backward.next = null;
                backward.prev = null;
                this.size--;
                return true;
            }
            forward = forward.next;
            backward = backward.prev;
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node prev = null;
        Node curr = null;
        Node next = null;

        int i = 0;
        if (index < this.size / 2) {
            prev = this.head;
            curr = this.head.next;
            while (i++ < index) {
                prev = prev.next;
                curr = curr.next;
            }

            prev.next = curr.next;
            curr.next.prev = prev;
            curr.next = null;
            curr.prev = null;
        } else {
            curr = this.tail.prev;
            next = this.tail;
            while (i++ < (this.size - index - 1)) {
                next = next.prev;
                curr = curr.prev;
            }
            next.prev = curr.prev;
            curr.prev.next = next;
            curr.next = null;
            curr.prev = null;
        }
        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size) { // 동일할 때도 확인해야 한다.
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node curr = null;
        if (index < this.size / 2) {
            curr = this.head.next;
            while (i++ < index) {
                curr = curr.next;
            }
        } else {
            curr = this.tail.prev;
            while (i++ < (this.size - index - 1)) {
                curr = curr.prev;
            }
        }
        return curr.data;
    }

    @Override
    public int indexOf(T t) {
        int index = 0;
        Node forward = this.head.next;
        Node backward = this.tail.prev;
        while (forward != backward && forward.prev != backward.next) {
            if (forward.data.equals(t) || backward.data.equals(t)) {
                return index;
            }
            forward = forward.next;
            backward = backward.prev;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == this.tail ? true : false;
    }

    @Override
    public boolean contains(T t) {
        Node forward = this.head.next;
        Node backward = this.tail.prev;
        while (forward != backward && forward.prev != backward) {
            if (forward.data.equals(t) || backward.data.equals(t)) {
                return true;
            }
            forward = forward.next;
            backward = backward.prev;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("DoubleLinkedList = [");
        Node curr = this.head.next;
        while (curr.next != null) {
            builder.append(curr.data);
            curr = curr.next;
            builder.append(curr.next == null ? "" : ", ");
        }
        builder.append("]");
        return builder.toString();
    }
}
