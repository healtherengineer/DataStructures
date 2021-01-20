
import java.util.ArrayList;
import java.util.Scanner;


public class StudentOperations {
   
    Scanner scanner = new Scanner(System.in);
    public void giveStudentsList(ArrayList<Student> students){
        for(int i = 0; i < students.size() ; i++) {
            System.out.println("************************************************");
            System.out.println( i +". Öğrenci : " +students.get(i).getName());
            System.out.println("--------------------------------------------------");
        }
    }
       public int searchStudent(ArrayList<Student> students){
      System.out.print("Aramak istediğiniz öğrencinin ismini giriniz : ");
      String name = scanner.nextLine();
  
      for (int i = 0 ; i<students.size() ; i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)){
              return i;
            }
        }
    
         return -1;
  }
   public void giveStudentInfo(Student std){
       
       System.out.println("Öğrencinin Adı : " +std.getName());
       System.out.println("Öğrencinin Numarası : " + std.getId());
       System.out.println("Öğrencinin Departmanı : " +std.getDepartment());
   }
       
  
    
}
