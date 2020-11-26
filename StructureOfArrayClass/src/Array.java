
import java.util.Arrays;

public class Array {

    int totalNumberOfElements;
    int index;
    int[] arr;

    public Array(int sizeOfArray) {
        this.totalNumberOfElements = sizeOfArray;
        this.arr = new int[sizeOfArray];
        index = 0;
    }

    public void add(int a) {
        if (index < this.totalNumberOfElements) {
            this.arr[this.index++] = a;

        } else {
            System.err.println("Array is Full . You cannot add any elements! ");
        }

    }

    public int find(int a) {
        int index = -1;
        for (int i = 0; i < this.index; i++) {
            if (a == this.arr[i]) {
                index = i;
            }
        }

        return index;
    }

    public void delete(int a) {
        int toDeleted = find(a);

        if (toDeleted != -1) {
            for (int i = toDeleted; i < this.index - 1; i++) {
                this.arr[i] = this.arr[i + 1];
            }
            this.index--;
            System.out.println("'" + a + "'" + " was deleted ...");
        } else {
            System.err.println("Element you want to delete is not in the Array !");
        }

    }

    public void update(int current, int newValue) {
        int index = find(current);

        this.arr[index] = newValue;
        System.out.println(current + " is updated as " + newValue + " .");
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < index; i++) {

            System.out.print(this.arr[i] + ", ");

        }
        System.out.print("]\n");
        System.out.println(Arrays.toString(arr));
    }

}
