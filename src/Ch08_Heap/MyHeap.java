package Ch08_Heap;

public interface MyHeap<T> {
    void insert(T val);

    boolean contains(T val);

    T pop();
    T peek();

    int size();
}
