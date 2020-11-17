
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Array arr = new Array(5);

        System.out.println("...........WELCOME TO ARRAY PROGRAM..............");
        String informations = "1 - ADD \n"
                + "2- DELETE \n"
                + "3 - UPDATE \n"
                + "4 - SEARCH \n"
                + "5 - PRINT \n"
                + "0- QUIT ";

        int deger = 0;
        int control = 0 ;
        String choice = "";
        do {
            System.out.println(informations);
            System.out.print("---> Choose a selection : ");
            choice = br.readLine();
            if (choice == "") {
                choice = "12";
                // choice variable can anyvalues 12,43,213,412,-2... 
                // I thought that user might push enter key two or more times . Just a defensive programming code.
            }
            switch (choice) {
                case "1":
                    System.out.print("Enter the value that you want to add : ");
                    deger = Integer.parseInt(br.readLine());
                    arr.add(deger);
                    break;
                case "2":
                    System.out.print("Enter the value that you want to delete : ");
                    deger = Integer.parseInt(br.readLine());
                    arr.delete(deger);
                     control = arr.find(deger);
                    if (control != -1) {
                        System.out.println("'" + deger + "'" + " was deleted ...");
                    }

                    break;
                case "3":
                    System.out.print("Enter the value that you want to update : ");

                    deger = Integer.parseInt(br.readLine());
                    control = arr.find(deger);
                    if (control != -1) {
                        System.out.print("Enter a new value :  ");
                        int guncel = Integer.parseInt(br.readLine());
                        arr.update(deger, guncel);
                    } else {
                        System.out.println("Element you want to update does NOT exist .");
                    }
                    break;
                case "4":
                    System.out.print("Enter the value that you want to search :   ");
                    deger = Integer.parseInt(br.readLine());
                    int indis = arr.find(deger);
                    if (indis != -1) {
                        System.out.println("Element you search is in  " + indis + ".th index ...");
                    } else {
                        System.out.println("Element you want to search does NOT exist ...");
                    }
                    break;
                case "5":
                    arr.print();
                    break;
                case "0":
                    System.out.println("Program is stopping by you . ");

                    return;
                default:
                    System.out.println("Something went wrong .You may push enter key two times . Try to choice again :)...");
                    break;

            }

        } while (choice != "0");

    }

}
