package blackredtree;

class Node<K extends Comparable<K>, V> {

    private Node<K,V> left;
    private Node<K,V> right;
    private Node<K,V> parent;
    private boolean red;
    private K key;
    private V value;
    
    Node(){ //constructor for sentinel
        
        red=false;
    }

    Node(K key, V value, Node<K, V> parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
        left = null;
        right = null;
        red = true;
    }

    public Node<K,V> getLeft() {
        return left;
    }

    public void setLeft(Node<K,V> left) {
        this.left = left;
    }

    public Node<K,V> getRight() {
        return right;
    }

    public void setRight(Node<K,V> right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed() {
        this.red = true; 
    }
    public void setBlack() {
        this.red = false;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
   
}


