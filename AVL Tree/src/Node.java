
public class Node {

    int key;
    Node right;
    Node left;
    int height;

    public Node(int key) {
        this.key = key;
        height = 1;
    }

    @Override
    public String toString() {
        return "[" + key + "," + (left == null ? "-" : left) + "," + (right == null ? "-" : right) + "]";
    }

}
