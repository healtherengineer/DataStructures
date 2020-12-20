
public class Node {

    String value;
    Node left;
    Node right;

    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "[" + value + "," + (left == null ? "-" : left) + "," + (right == null ? "-" : right) + "]";
    }

    public String tString() {
        return "[" + value + "]";
    }

}
