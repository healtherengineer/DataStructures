
public class Main {

    public static void main(String[] args) {

        AvlTree avl = new AvlTree();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        avl.insert(25);
        avl.insert(15);
        avl.insert(45);
        avl.insert(35);
        avl.insert(70);
        avl.insert(90);
        avl.insert(100);

        avl.preOrder();
        System.out.println("");

        avl.printTree();

        avl.delete(50);
        avl.printTree();
        avl.delete(30);
        System.out.println("");
        avl.printTree();
        avl.delete(40);
        System.out.println("");
        avl.printTree();
        System.out.println( avl.isThere(10)); 
    }

}
