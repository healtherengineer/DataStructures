
public class Node {

    int key;
    Node right;
    Node left;

    public Node(int key) {
        this.key = key;
        this.right = null;
        this.left = null;
    }

    @Override
    public String toString() {
        return "[" + key + "," + (left == null ? "-" : left) + "," + (right == null ? "-" : right) + "]";
    }

//    @Override
//    public String toString() {
//        return "[" + key + "]";
//    }
}
