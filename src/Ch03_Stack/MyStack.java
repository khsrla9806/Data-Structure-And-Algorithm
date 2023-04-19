package Ch03_Stack;

public interface MyStack<T> {
    void push(T data);
    T pop();
    T peek();
    int size();
}
