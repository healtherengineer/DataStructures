
public class Main {

    public static void main(String[] args) {

        int[] arr = {9, 3, 6, 1, 5, 4, 3, 8, 2};

        ShellSorting shell = new ShellSorting(arr);
        System.out.print("Unsorted Array : ");
        shell.printArray();
        shell.sort();
        System.out.println("");
        System.out.print("Sorted array : ");
        shell.printArray();

    }

}
