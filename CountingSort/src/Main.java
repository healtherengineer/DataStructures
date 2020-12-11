
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 8, 9, 4, 1, 7, 1, 9, 10};

        CountingSort counting = new CountingSort(arr);
        System.out.println(Arrays.toString(arr));

        counting.sort();
        System.out.println(Arrays.toString(arr));

    }

}
