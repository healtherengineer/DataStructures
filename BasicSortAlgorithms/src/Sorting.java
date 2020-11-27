
import java.util.Arrays;

public class Sorting {

    int[] arr;

    public Sorting(int[] array) {
        this.arr = array;
    }

    public void bubbleSort() {

        int temp = 0;
        System.out.println("Unordered array : " + Arrays.toString(arr));
        boolean insideIf = true;// optimization
        for (int i = 0; i < arr.length && insideIf; i++) {

            insideIf = false; // optimization

            for (int j = 0; j < arr.length - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    insideIf = true;// optimization
                }
            }
            System.out.println(i + "-" + Arrays.toString(arr));
        }
        infoMessage();

    }

    public void selectionSort() {

        int temp = 0;
        int minimum;
        System.out.println("Unordered array : " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            minimum = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minimum]) {

                    minimum = j;
                }
            }

            if (i != minimum) {
                temp = arr[minimum];
                arr[minimum] = arr[i];
                arr[i] = temp;

            }

            System.out.println(i + "-" + Arrays.toString(arr));

        }
        infoMessage();

    }

    public void insertionSort() {
        int temp = 0;
        int j;
        System.out.println("Unordered array : " + Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i - 1; j >= 0 && temp < arr[j]; j--) { // This is most important line in this method !!! 

                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp; //döngünün içeri sokmayan son j değeri döneceğinden j+1 e yolluyoruz !!!
            System.out.println(i + "-" + Arrays.toString(arr));
        }
        infoMessage();
    }

    public void infoMessage() {
        System.out.print("Last state :: Ordered array =>");
        System.out.println(Arrays.toString(arr));
    }

}
