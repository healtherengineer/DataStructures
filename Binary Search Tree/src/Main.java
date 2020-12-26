
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Bst bst = new Bst();

        // Build tree
        bst.insert(10); // root değeri 
        bst.insert(6);
        bst.insert(9);
        bst.insert(12);
        bst.insert(5);
        bst.insert(2);
        bst.insert(25);
        bst.insert(40);
        bst.insert(10);
        bst.insert(11);

        //System.out.println(bst.search(5));  // ağaçta olmayanı aratırsan bulmaz null döner .
        // System.out.println(bst.search(15)); // 15 bir leaf miş search yaptığımızda recursive çalıştığından dipten çağırır bizim çağırdığımız yere kadar
        // System.out.println(bst.search(6)); // 15 bir leaf miş search yaptığımızda recursive çalıştığından dipten çağırır bizim çağırdığımız yere kadar
        //    System.out.println(bst.search(6)); // yaptığımızda 6 olan düğümü yazdırmaya çalışıyoruz toString metodu yüzünden recursive altındakiler de geliyor
        // toString metodunu düzenlediğimizde artık sadece değer döner oldu Gördüğünüz gibi.
        // Find Min Max 
//        System.out.println("The greatest key is : " + bst.getMax(bst.root));
//        System.out.println("The smallest key is : " + bst.getMin(bst.root));
        //Deletion
//        bst.printTree();
//        bst.delete(8); // leaf
//        bst.printTree();
//        bst.printTree();
//        bst.delete(15); // one child
//        bst.printTree();
//        bst.printTree();
//        bst.delete(6); // two child
//        bst.printTree();
//        bst.printTree();
//        bst.delete(10);  // deleting root
//        bst.printTree();
        //  System.out.println(bst.search(45)); // tree de olmadığı için null yani boş döner .
        bst.printTree();

        bst.inorder();
        System.out.println("");
        bst.preOrder();
        System.out.println("");
        bst.postOrder();
        
    }

}
