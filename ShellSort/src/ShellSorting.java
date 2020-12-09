
public class ShellSorting {

    int[] array;

    public ShellSorting(int[] arr) {
        this.array = arr;

    }

    public void sort() {

        int n = array.length;

        for (int gap = n / 2; gap < array.length; gap /= 2) {

            for (int i = gap; i < n; i++) {
                int j;
                for (j = i - gap; j >= 0; j -= gap) {
                    if (array[j + gap] < array[j]) {
                        swap(array[j + gap], array[j]);
                    }
                }
            }

        }

    }

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public void printArray() {
        for (int i = 0; i < this.array.length; i++) {
            System.out.print(this.array[i] + ",");
        }
    }

}
