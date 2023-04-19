package Ch04_Queue;

public interface MQueue<T> {
    void offer(T data);
    T poll();
    T peek();
    int size();
    void clear();
    boolean isEmpty();
}
