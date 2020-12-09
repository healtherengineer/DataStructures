
public class Main {

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        QuickSort quick = new QuickSort(arr);
        System.out.print("Unsorted Array : ");
        quick.printArray();
        quick.quickSort(0, arr.length - 1);
        System.out.print("\nSorted Array : ");
        quick.printArray();
    }

}
