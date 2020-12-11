
import java.util.Arrays;

public class RadixSort {

    int[] array;

    public RadixSort(int[] array) {
        this.array = array;
    }

    public void countSort(int exp) {
        int max = 10, i;
        int[] output = new int[array.length];
        int[] count = new int[max];

        for (i = 0; i < array.length; i++) {
            count[(array[i] / exp) % 10]++;
        }
        for (i = 1; i < max; i++) {
            count[i] += count[i - 1];
        }

        for (i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

    public void sort() {
        int m = getMax() + 1;

        for (int exp = 1; (m / exp) > 0; exp *= 10) {
            countSort(exp);
        }

    }

    public int getMax() {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public void printArray() {

        for (int i = 0; i < this.array.length; i++) {
            System.out.print(this.array[i] + ",");
        }
    }

}
