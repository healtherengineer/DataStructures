
public class Sorting {

    String arr[];
    char[] alphabet = {'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'ğ', 'h', 'ı', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'ö', 'p', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'w', 'x', 'y', 'z', '?'};

    public Sorting(String[] arr) {
        this.arr = arr;
    }

    void sort(int ind) {
        int n = arr.length;
        String[] temp = new String[n];
        temp = addStar(); // copy array yıldızlanmış halinde bir kopya array oluşturduk

        String output[] = new String[n];

        int count[] = new int[32];
        for (int i = 0; i < 32; ++i) {
            count[i] = 0;
        }

        for (int i = 0; i < n; ++i) {
            ++count[whereInALphabet(temp[i].toLowerCase().charAt(ind))];
        }

        for (int i = 1; i <= 31; ++i) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[whereInALphabet(temp[i].toLowerCase().charAt(ind))] - 1] = arr[i];
            --count[whereInALphabet(temp[i].toLowerCase().charAt(ind))];
        }

        for (int i = 0; i < n; ++i) {
            arr[i] = output[i];
        }

    }

    public void radix() {

        int longestString = largestString();
        for (int i = longestString - 1; i >= 0; i--) {

            sort(i);
        }
    }

    public String[] addStar() {
        String[] temp = new String[arr.length];
        int largest = largestString();
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        for (int i = 0; i < temp.length; i++) {

            for (int j = 0; j < largest - arr[i].length(); j++) {
                temp[i] += "?";

            }

        }
        return temp;
    }

    public int whereInALphabet(char a) {
        int ind = 0;

        for (int i = 0; i < 31; i++) {
            if (alphabet[i] == a) {
                ind = i;
            }
        }
        return ind;

    }

    public int largestString() {
        int max = arr[0].length();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() > max) {
                max = arr[i].length();
            }
        }
        return max;
    }

    public void printArray(String[] arr) {
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }

    }

}
