
import java.util.Arrays;

public class Main {

    public static int binarySearch(int[] arr, int l, int m, int r, int x) {

        if (arr[m] == x) {
            return m;
        } else if (l == r) {
            return -1;

        }
        if (arr[m] > x) {
            r = m - 1;

        } else {
            l = m + 1;
        }
        m = (l + r) / 2;
        return binarySearch(arr, l, m, r, x);

    }

    public static void main(String[] args) {

        // assuming the array as sorted or enter a sorted array directly
        int[] array = {11, 22, 55, 88, 121, 122, 132};
        System.out.println(Arrays.toString(array));
        //Arrays.sort(array);
        //System.out.println(Arrays.toString(array));
        int result = binarySearch(array, 0, ((array.length - 1) / 2), array.length - 1, 22);
        if (result == -1) {
            System.out.println("The element is not found in the array");
        } else {
            System.out.println("Index of the element is = " + result);
        }

    }

}
