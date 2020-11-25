
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //iterative Factorial 
//         System.out.print("Enter any number to calculate its Factorial : ");
//        int n = scanner.nextInt();
//        int sum = 1;
//        
//        for(int i = 1 ; i<=n; i++){
//            sum *=i;
//        }
//        System.out.println(n+"! is equal to " + sum);
        //RECURSION FACTORIAL 
        System.out.print("Enter any number to calculate its Factorial : ");

        int n = scanner.nextInt();

        int result = fact(n);

        System.out.println(n + "! is equal to " + result);
    }

    public static int fact(int n) {

        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

}
