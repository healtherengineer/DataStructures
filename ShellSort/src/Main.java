
public class Main {

    public static void main(String[] args) {

        int[] arr = {9, 3, 6, 1, 5, 4, 3, 8, 2};

        ShellSorting shell = new ShellSorting(arr);
        shell.printArray();
        shell.sort();
        System.out.println("");
        shell.printArray();

    }

}
