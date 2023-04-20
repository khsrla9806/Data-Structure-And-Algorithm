package Ch05_Hash;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedHashTable<K, V> implements MyHashTable<K, V> {
    private static final int DEFAULT_BUCKET_SIZE = 1024;
    private List<Node>[] buckets;
    private int size;
    private int bucketSize;

    public MyLinkedHashTable() {
        this.buckets = new List[DEFAULT_BUCKET_SIZE];
        this.bucketSize = DEFAULT_BUCKET_SIZE;
        this.size = 0;
        Arrays.fill(this.buckets, new LinkedList<>());
    }

    public MyLinkedHashTable(int bucketSize) {
        this.buckets = new List[bucketSize];
        this.bucketSize = DEFAULT_BUCKET_SIZE;
        this.size = 0;
        Arrays.fill(this.buckets, new LinkedList<>());
    }

    @Override
    public void put(K key, V value) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for (Node node : bucket) { // 동일 key에 데이터가 들어오면 덮어쓴다.
            if (node.key.equals(key)) {
                node.data = value;
                return;
            }
        }
        Node node = new Node(key, value);
        bucket.add(node);
        this.size++;
    }

    @Override
    public V get(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.data;
            }
        }
        return null;
    }

    @Override
    public boolean delete(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                this.size--;
                return bucket.remove(node);
            }
        }
        return false;
    }

    @Override
    public boolean contains(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int hash(K key) {
        int hash = 0;
        for (Character ch : key.toString().toCharArray()) {
            hash += (int) ch;
        }
        return hash % this.bucketSize; // Bucket의 index 값으로 사용되기 때문에 bucketSize로 나눕니다.
    }

    private class Node {
        K key;
        V data;

        Node(K key, V data) {
            this.key = key;
            this.data = data;
        }
    }
}
