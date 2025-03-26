public class BinaryTree<K extends Comparable<K>, V>{
    private Node<K,V> root;

    public void add(K key, V value) {
        root = insertNode(root, key, value);
    }

    private Node<K, V> insertNode(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = insertNode(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insertNode(node.right, key, value);
        }
        return node;
    }

    public V get(K key){
        return search(root, key);
    } 
    
    private V search(Node<K, V> node, K key){
        if (node == null) {
            return null; 
        }
        if (key.compareTo(node.key) == 0) {
            return node.value;  
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public void inOrder(){
        traversal(root);
    }

    private void traversal(Node<K, V> node){
        traversal(node.left);
        System.out.println("LLave: " + node.key + "| producto: " + node.value);
        traversal(node.right);
    }
}