
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        int[] givenArray = new int[10];
        Heap hp = new Heap(givenArray);
//        {30,20,10,40,50,25,60};
        hp.insert(20);
        hp.printHeap();

        hp.insert(30);
        hp.printHeap();
        hp.insert(25);
        hp.printHeap();
        hp.insert(10);
        hp.printHeap();
        hp.insert(40);
        hp.printHeap();
        hp.insert(5);
        hp.printHeap();
        hp.insert(50);
        hp.printHeap();
        hp.insert(2);
        hp.printHeap();

        hp.insert(13);
        hp.printHeap();
        hp.insert(27);
        hp.printHeap();
        // System.out.println("index : "  + hp.index);
        hp.delete();
        hp.printHeap();
        hp.delete();
        hp.printHeap();
        System.out.println("index : " + hp.index);
 
    }

}
