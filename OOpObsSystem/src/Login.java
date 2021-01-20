
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public boolean login() {

        Scanner scanner = new Scanner(System.in);
        boolean ctrl = false;
        Main main = new Main();
        ArrayList<Student> students1 = new ArrayList<Student>();
        students1 = main.students;
        System.out.print("Öğrenci Numaranızı giriniz : ");
        String id = scanner.nextLine();
        System.out.println("Departmanınızı giriniz   : ");
        String department = scanner.nextLine();
        for (Student std : students1) {
            if (std.getId().equals(id) && std.getDepartment().equalsIgnoreCase(department)) {
                ctrl = true;
            }
        }
        return ctrl;

    }

}
