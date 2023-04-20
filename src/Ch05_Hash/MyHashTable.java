package Ch05_Hash;

public interface MyHashTable<K, V> {
    void put(K key, V value);
    V get(K key);
    boolean delete(K key);
    boolean contains(K key);
    int size();
}
