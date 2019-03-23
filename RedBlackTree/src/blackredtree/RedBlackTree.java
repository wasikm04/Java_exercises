package blackredtree;

public class RedBlackTree<K extends Comparable<K>, V> implements MapInterface<K, V> {

    public Node<K, V> getRoot() {
        return root;
    }

    private Node<K, V> sentinel = new Node<K, V>();
    private Node<K, V> root = null;

    RedBlackTree() {

        sentinel.setBlack();
        root = sentinel;
    }

    @Override
    public V getValue(K key) {
        Node<K, V> tmp = getRoot();

        while (tmp != sentinel) {
            int compare = key.compareTo(tmp.getKey());
            if (compare == 0) {
                return tmp.getValue();
            } else if (compare < 0) {
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        //   }
        return null;
    }

    @Override
    public void setValue(K key, V value) {
        root = setValueWithParent(key, value, getRoot());
        root.setBlack();
    }

    public Node<K, V> setValueWithParent(K key, V value, Node<K, V> parent) {
        if (parent == sentinel) {
            parent = new Node<K, V>(key, value, null);

            parent.setLeft(sentinel);
            parent.setRight(sentinel);
        } else {
            Node<K, V> newNode = new Node<K, V>(key, value, parent);
            newNode.setLeft(sentinel);
            newNode.setRight(sentinel);

            int compare = key.compareTo(parent.getKey());

            if (compare < 0) {
                newNode = setValueWithParent(key, value, parent.getLeft());
                parent.setLeft(newNode);
            } else if (compare > 0) {
                newNode = setValueWithParent(key, value, parent.getRight());
                parent.setRight(newNode);
            } else {
                parent.setValue(value);
            }

            if (parent.getRight().isRed() && parent.getRight().getLeft().isRed()) {
                parent.setRed();
                parent.getRight().getLeft().setBlack();
                parent.setRight(rightRotate(parent.getRight()));

                parent = leftRotate(parent);
            }
            if (parent.getLeft().isRed() && parent.getLeft().getRight().isRed()) {
                parent.setRed();
                parent.getLeft().getRight().setBlack();
                parent.setLeft(leftRotate(parent.getLeft()));
                parent = rightRotate(parent);
            }

            if (parent.getLeft().isRed() && parent.getLeft().getLeft().isRed()) {
                parent.setRed();
                parent.getLeft().setBlack();
                parent = rightRotate(parent);

            }
            if (parent.getRight().isRed() && parent.getRight().getRight().isRed()) {
                parent.setRed();
                parent.getRight().setBlack();
                parent = leftRotate(parent);
            }

        }
        fixRBTree(parent);
        return parent;
    }

    public void fixRBTree(Node<K, V> parent) {

        if ((parent.getRight() == sentinel) || (parent.getLeft() == sentinel)) {
            return;
        }

        if (!parent.isRed() && parent.getRight().isRed() && parent.getLeft().isRed()) { //1 przypadek
            if (parent == getRoot()) {
                parent.setBlack();
            } else {
                parent.setRed();
            }
            parent.getLeft().setBlack();
            parent.getRight().setBlack();
        }

    }

    private Node<K, V> leftRotate(Node<K, V> grand) { //grand(father) - węzeł przez który rotujemy
        Node<K, V> parent = grand.getRight();
        Node<K, V> leftChildOfParent = parent.getLeft();
        parent.setLeft(grand);
        grand.setRight(leftChildOfParent);
        return parent;

    }

    private Node<K, V> rightRotate(Node<K, V> grand) { //grand(father) - węzeł przez ktory rotujemy
        Node<K, V> parent = grand.getLeft();
        Node<K, V> RightChildOfParent = parent.getRight();
        parent.setRight(grand);
        grand.setLeft(RightChildOfParent);
        return parent;

    }

    public static void main(String[] args) {
        RedBlackTree<Integer, Double> tree = new RedBlackTree<Integer, Double>();
        // Węzły dodawane są w kolejności 8 > 18 > 5 > 15 > 17 > 25 > 40 > 80 
        tree.setValue(8, 1.0);
        tree.setValue(18, 2.0);
        tree.setValue(5, 3.0);
        tree.setValue(15, 4.0);
        tree.setValue(17, 5.0);
        tree.setValue(25, 6.0);
        tree.setValue(40, 7.0);
        tree.setValue(80, 8.0);
        
        System.out.println("Działanie drzewa na znanym przykładzie, węzły dodawane w kolejności 8 => 18 => 5 => 15 => 17 => 25 => 40 = 80 ");
        System.out.println("Korzeń " + tree.getRoot().getKey());
        System.out.println("--------------------------------------");
        System.out.println("Lewe " + tree.getRoot().getLeft().getKey());
        System.out.println("Lewe lewego " + tree.getRoot().getLeft().getLeft().getKey());
        System.out.println("Prawe lewego " + tree.getRoot().getLeft().getRight().getKey());
        System.out.println("--------------------------------------");
        System.out.println("Prawe " + tree.getRoot().getRight().getKey());
        System.out.println("Lewe prawego " + tree.getRoot().getRight().getLeft().getKey());
        System.out.println("Prawe prawego " + tree.getRoot().getRight().getRight().getKey());
    }

}
