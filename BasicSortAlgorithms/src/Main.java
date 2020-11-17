
public class Main {

    public static void main(String[] args) {

        //   int[] dizi = {59, 66, 18, 92, 37, 17, 18, 4, 76, 20};
        int[] dizi = {12, 44, 2, 15, 16, 37, 1}; // insertion ı anlamak için kendim dizi oluşturmuştum .
        Sorting sirala = new Sorting(dizi);

        //sirala.bubbleSort();
        // sirala.selectionSort();
        sirala.insertionSort();

    }

}
