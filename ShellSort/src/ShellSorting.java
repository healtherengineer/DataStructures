
public class ShellSorting {

    int[] array;

    public ShellSorting(int[] arr) {
        this.array = arr;

    }

    public void sort() {

        int n = array.length;

        for (int gap = n / 2; gap >= 1; gap /= 2) {

            for (int i = gap; i < n; i++) {
                int j;
                for (j = i - gap; j >= 0; j -= gap) {
                    if (array[j + gap] < array[j]) {
                        swap((j + gap), j);
                    }
                }
            }

        }

    }

    public void swap(int a, int b) {
        int temp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = temp;
    }

    public void printArray() {
      
        for (int i = 0; i < this.array.length; i++) {
            System.out.print(this.array[i] + ",");
        }
    }

}
