
public class CountingSort {

    int[] array;

    public CountingSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        int[] count;
        int[] tempArray = new int[array.length];
        int dimension = findMax() + 1;

        count = new int[dimension];

        for (int i = 0; i < array.length; i++) {
            count[array[i]] += 1;
        }

        for (int i = 1; i < dimension; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < array.length; i++) {
            tempArray[--count[array[i]]] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tempArray[i];
        }

    }

    public int findMax() {

        int max = this.array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;

    }

}
