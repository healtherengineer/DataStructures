
public class Main {

    public static void main(String[] args) {

        //   int[] arr1 = {59, 66, 18, 92, 37, 17, 18, 4, 76, 20};
        int[] arr2 = {12, 44, 2, 15, 16, 37, 1}; // I create this array to understand Insertion Sort
        Sorting sort = new Sorting(arr2);

        //sort.bubbleSort();
        // sort.selectionSort();
        sort.insertionSort();

    }

}
