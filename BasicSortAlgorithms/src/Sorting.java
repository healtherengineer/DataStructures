
import java.util.Arrays;

public class Sorting {

    int[] dizi;

    public Sorting(int[] dizi) {
        this.dizi = dizi;
    }

    public void bubbleSort() {

        int temp = 0;
        System.out.println("Sırasız dizi : " + Arrays.toString(dizi));
        boolean girdiMi = true;// iyileştirme
        for (int i = 0; i < dizi.length && girdiMi; i++) {

            girdiMi = false; // iyileştirme

            for (int j = 0; j < dizi.length - 1; j++) {

                if (dizi[j] > dizi[j + 1]) {

                    temp = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = temp;

                    girdiMi = true;// iyileştirme
                }
            }
            System.out.println(i + "-" + Arrays.toString(dizi));
        }

    }

    public void selectionSort() {

        int temp = 0;
        int min;
        System.out.println("Sırasız dizi : " + Arrays.toString(dizi));

        for (int i = 0; i < dizi.length; i++) {
            min = i;
            for (int j = i + 1; j < dizi.length; j++) {

                if (dizi[j] < dizi[min]) {

                    min = j;
                }
            }

            if (i != min) {
                temp = dizi[min];
                dizi[min] = dizi[i];
                dizi[i] = temp;

            }

            System.out.println(i + "-" + Arrays.toString(dizi));

        }

    }

    public void insertionSort() {
        int temp = 0;
        int j;
        System.out.println("Sırasız dizi : " + Arrays.toString(dizi));

        for (int i = 1; i < dizi.length; i++) {
            temp = dizi[i];
            for (j = i - 1; j >= 0 && temp < dizi[j]; j--) { // önemli olan bu satır !!!

                dizi[j + 1] = dizi[j];
            }
            dizi[j + 1] = temp; // döngünün içeri sokmayan son j değeri döneceğinden j+1 e yolluyoruz !!!
            System.out.println(i + "-" + Arrays.toString(dizi));
        }
    }

}
