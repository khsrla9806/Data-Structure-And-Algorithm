package Ch07_Tree;

public interface MyTree<T> {
    void insert(T val);
    void delete(T val);
    boolean contains(T val);
    int size();
}
