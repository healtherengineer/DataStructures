
public class Node {

    Node next;
    Node prev;
    Araba araba;

    public Node(Araba araba) {
        this.araba = araba;
        this.next = null;
        this.prev = null;
    }

}
