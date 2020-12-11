



public class Main {
    public static void main(String[] args) {
        int[] arr = {41,12,3,2,15,66,88,12,33,1};
        RadixSort radix = new RadixSort(arr);
        radix.printArray();
        radix.sort();
        System.out.println("");
       radix.printArray();

    }
}
