
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Student> students = new ArrayList<Student>();

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        students.add(new Student("Ege", "Bilgisayar", "02180201064"));
        students.add(new Student("mustafa", "Bilgisayar", "02180201066"));
        System.out.println("**********************************************");
        System.out.println("Öğrenci Bilgi Sistemimize Hoş Geldiniz ...");
        System.out.println("**********************************************");

        System.out.println("*************Kullanıcı Girişi ************");

        int giris_hakki = 3;
        while (true) {
            if (giris_hakki <= 0) {
                System.out.println("Giriş hakkınız doldu ... Sistem kendini bloke ediyor...");
                return;
            }
            Login login = new Login();
            if (login.login()) {
                System.out.println("Giriş Başarılı ...");
                break;
            } else {
                System.out.println("Giriş Başarısız...");
                System.out.println("Kalan giriş hakkı : " + --giris_hakki);
            }

        }
        String description = "1- Öğrenci listesini görüntüle ...\n"
                + "2-Öğrenci Ara...\n "
                + "3-Dersleri Görüntüle ...\n"
                + "4-Öğrenci Ekle ...\n"
                + "5-Öğrenci Sil...\n"
                + "6-Öğrenci Güncelle\n"
                + "q- Çıkış Yap .";
        while (true) {
            StudentOperations operations = new StudentOperations();

            System.out.println(description);
            System.out.print("Yapmak istediğiniz işlemin numarasını giriniz : ");
            String islem = scanner.nextLine();
            if (islem.equals("1")) {
                System.out.println("Toplam " + students.size() + " adet Öğrenci mevcut");
                operations.giveStudentsList(students);
            } else if (islem.equals("2")) {
                int indx = operations.searchStudent(students);
                if (indx == -1) {
                    System.out.println("**********************************************************");
                    System.out.println("Öğrenci Bulunamadı ...");

                } else {
                    System.out.println("**********************************************************");
                    System.out.println("Öğrenci Bulundu ... \n\nArdağınız öğrencinin bilgileri yükleniyor ;");
                    Thread.sleep(3000);
                    System.out.println("Öğrencinin Bilgileri ; ");
                    operations.giveStudentInfo(students.get(indx));
                }

            } else if (islem.equals("3")) {
                System.out.println(Student.CLASSES);

            } else if (islem.equals("4")) {
                System.out.print("Eklemek istediğiniz Öğrencinin ismini giriniz :");
                String n1 = scanner.nextLine();
                System.out.print("Eklemek istediğiniz Öğrencinin bölümünü giriniz :");

                String b2 = scanner.nextLine();
                System.out.print("Eklemek istediğiniz Öğrencinin okul numarasını giriniz :");
                String no1 = scanner.nextLine();
                students.add(new Student(n1, b2, no1));

            } else if (islem.equals("5")) {
                int indx = operations.searchStudent(students);
                if (indx == -1) {
                    System.out.println("Öğrenci bulunamadı ...");
                } else {
                    System.out.println(students.get(indx).getName() + " isimli Öğrenci listeden siliniyor ... ");
                    students.remove(indx);
                }

            } else if (islem.equals("6")) {
                System.out.println("Güncellemek istediğiniz Öğrenciyi Bulunuz ...");
                Thread.sleep(3000);
                int indx = operations.searchStudent(students);
                System.out.println("Güncellemek istediğiniz Öğrencinin bilgileri  ; ");
                Thread.sleep(2000);
                operations.giveStudentInfo(students.get(indx));
                while (true) {
                    System.out.println("Güncelleme Paneline Hoş Geldiniz ...");
                    String islemler2 = "0-İsim Güncelle\n"
                            + "1-Numara Güncelle...\n"
                            + "2-Bölüm Güncelle..\n"
                            + "q-Güncelleme Panelinden çıkın ...\n";
                    System.out.println(islemler2);
                    System.out.print("Seçim Yapınız : ");
                    String islem2 = scanner.nextLine();
                    if (islem2.equals("0")) {
                        System.out.println("İsim giriniz : ");
                        String name1 = scanner.nextLine();
                        students.get(indx).setName(name1);
                        System.out.println("Yeni isim : " + students.get(indx).getName());
                    } else if (islem2.equals("1")) {
                        System.out.println("Numara Giriniz : ");
                        String numara = scanner.nextLine();
                        students.get(indx).setId(numara);
                        System.out.println("Güncel Numara : " + students.get(indx).getId());

                    } else if (islem2.equals("2")) {
                        System.out.println("Bölüm Giriniz : ");
                        String bolum = scanner.nextLine();
                        students.get(indx).setId(bolum);
                        System.out.println("Güncel Departman : " + students.get(indx).getDepartment());

                    } else if (islem2.equalsIgnoreCase("q")) {
                        System.out.println("Ana Ekrana Dönülüyor ...");
                        Thread.sleep(3000);
                        break;

                    } else {
                        System.out.println("Geçersiz İşlem ...");
                    }
                }

            } else if (islem.equalsIgnoreCase("q")) {
                System.out.println("Sistem 3 saniye içerisinde kapatılacaktır...");
                Thread.sleep(3000);
                System.out.println("Sistem iyi günler diler...");
                return;

            } else {
                System.out.println("Geçersiz bir işlem girdiniz ...");
            }
        }

    }
}
