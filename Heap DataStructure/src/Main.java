
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] givenArray = new int[10];
        Heap hp = new Heap(givenArray);
//        {30,20,10,40,50,25,60};
        hp.insert(20);
        System.out.println(Arrays.toString(givenArray));

        hp.insert(30);
        System.out.println(Arrays.toString(givenArray));
        hp.insert(25);
        System.out.println(Arrays.toString(givenArray));
        hp.insert(10);
        System.out.println(Arrays.toString(givenArray));
        hp.insert(40);
        System.out.println(Arrays.toString(givenArray));
        hp.insert(5);
        System.out.println(Arrays.toString(givenArray));
        hp.insert(50);
        System.out.println(Arrays.toString(givenArray));
        hp.insert(2);
        System.out.println(Arrays.toString(givenArray));

        hp.insert(13);
        System.out.println(Arrays.toString(givenArray));
        hp.insert(27);
        System.out.println(Arrays.toString(givenArray));
        // System.out.println("index : "  + hp.index);
        hp.delete();
        System.out.println(Arrays.toString(givenArray));
        hp.delete();
        System.out.println(Arrays.toString(givenArray));
        System.out.println("index : " + hp.index);
        hp.printHeap();
    }

}
