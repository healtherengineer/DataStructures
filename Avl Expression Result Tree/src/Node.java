
class Node {

    String operand;
    String firstElement;
    String secondElement;
    double result;
    Node left;
    Node right;
    int height;

    public Node(String operand, String firstElement, String secondElement) {
        this.operand = operand;
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.left = null;
        this.right = null;
        this.height = 1;
        if (this.operand.equals("+")) {
            this.result = Double.parseDouble(this.firstElement) + Double.parseDouble(this.secondElement);

        } else if (this.operand.equals("-")) {
            this.result = (double) Double.parseDouble(this.firstElement) - (double) Double.parseDouble(this.secondElement);

        } else if (this.operand.equals("*")) {
            this.result = (double) Double.parseDouble(this.firstElement) * (double) Double.parseDouble(this.secondElement);

        } else {
            this.result = (double) Double.parseDouble(this.firstElement) / (double) Double.parseDouble(this.secondElement);

        }
    }

    @Override
    public String toString() {
        return "[" + result + "," + (left == null ? "-" : left) + "," + (right == null ? "-" : right) + "]";
    }

}
