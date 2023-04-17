package Ch07_Tree;

import java.util.ArrayList;
import java.util.List;

public class MyBinarySearchTree<T extends Comparable<T>> implements MyTree<T> {

    private Node root;
    private int size;

    public MyBinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public T min() {
        return this.minNodeData(this.root);
    }

    private T minNodeData(Node node) {
        T minData = node.data;
        while (node.left != null) {
            node = node.left;
            minData = node.data;
        }
        return minData;
    }

    public T max() {
        return this.maxNodeData(this.root);
    }

    private T maxNodeData(Node node) {
        T maxData = node.data;
        while (node.right != null) {
            node = node.right;
            maxData = node.data;
        }
        return maxData;
    }

    @Override
    public void insert(T val) {
        this.root = insertNode(this.root, val);
        this.size++;
    }

    private Node insertNode(Node node, T val) {
        if (node == null) {
            return new Node(val);
        }
        if (val.compareTo(node.data) < 0) {
            node.left = insertNode(node.left, val);
        } else if (val.compareTo(node.data) > 0) {
            node.right = insertNode(node.right, val);
        }

        return node;
    }

    @Override
    public void delete(T val) {
        this.deleteNode(this.root, val);
    }
    private Node deleteNode(Node node, T val) {
        if (node == null) return null;
        if (val.compareTo(node.data) < 0) {
            node.left = deleteNode(node.left, val);
        } else if (val.compareTo(node.data) > 0) {
            return deleteNode(node.right, val);
        } else {  // 삭제할 노드를 찾은 경우
            this.size--;
            // 삭제할 노드가 자식을 1개만 가지고 있거나, 아무것도 가지지 않는 경우
            if (node.left == null) {
                return node.right; // 오른쪽도 null 이면 해당 노드만 삭제되고 끝남
            } else if (node.right == null) {
                return node.left;
            }

            // 삭제할 노드가 자식을 2개 가지고 있는경우
            // 오른쪽 트리의 최솟값을 가져오는 방법으로 구현
            node.data = this.minNodeData(node.right);
            // 오른쪽 트리의 최솟값을 삭제해줘야 중복이 되지 않는다.
            node.right = deleteNode(node.right, node.data);
        }
        return node;
    }

    @Override
    public boolean contains(T val) {
        return this.containsNode(this.root, val);
    }
    private boolean containsNode(Node node, T val) {
        if (node == null) {
            return false;
        }
        int compare = val.compareTo(node.data);
        if (compare == 0) {
            return true;
        }
        if (compare < 0) {
            return containsNode(node.right, val);
        }
        return containsNode(node.left, val);
    }

    @Override
    public int size() {
        return this.size;
    }

    public List<T> preorder() {
        return this.preorderTree(this.root, new ArrayList<>());
    }

    // 전위 탐색
    private List<T> preorderTree(Node node, List<T> visited) {
        if (node == null) {
            return visited;
        }
        visited.add(node.data); // 노드를 먼저 방문
        preorderTree(node.left, visited); // 왼쪽 서브 트리 탐색
        preorderTree(node.right, visited); // 오른쪽 서브 트리 탐색

        return visited;
    }
    public List<T> inorder() {
        return this.inorderTree(this.root, new ArrayList<>());
    }

    // 중위 탐색
    private List<T> inorderTree(Node node, List<T> visited) {
        if (node == null) {
            return visited;
        }
        preorderTree(node.left, visited); // 왼쪽 서브 트리 탐색
        visited.add(node.data); // 노드를 중간에 방문
        preorderTree(node.right, visited); // 오른쪽 서브 트리 탐색

        return visited;
    }
    public List<T> postorder() {
        return this.postorderTree(this.root, new ArrayList<>());
    }

    // 후위탐색
    private List<T> postorderTree(Node node, List<T> visited) {
        if (node == null) {
            return visited;
        }
        preorderTree(node.left, visited); // 왼쪽 서브 트리 탐색
        preorderTree(node.right, visited); // 오른쪽 서브 트리 탐색
        visited.add(node.data); // 노드를 마지막에 방문

        return visited;
    }

    private class Node {
        T data;
        Node left;
        Node right;

        Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(T data) {
            this.data = data;
        }
    }
}
