
public class QuickSort {

    int array[];

    public QuickSort(int[] array) {
        this.array = array;
    }

    public void quickSort(int low, int high) {
        //low --> Starting , high --> arr.length-1
        if (low < high) {
            int pivot = partition(low, high);

            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);

        }
    }

    public int partition(int low, int high) {
        int piv = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (this.array[j] < piv) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;

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
