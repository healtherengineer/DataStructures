
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Person p1 = new Person("1111", "a", "+", false, false);
//        Person p2 = new Person("1211", "0", "-", false, false);
//        Person p3 = new Person("1521", "b", "-", false, false);
//        Person p4 = new Person("1261", "ab", "-", false, false);
//        Person p5 = new Person("1301", "ab", "+", false, false);
//        Person p6 = new Person("1453", "0", "-", true, false);
//        Person p7 = new Person("2153", "a", "-", false, false);
//        Person p8 = new Person("5661", "ab", "-", false, false);

        Graph g = new Graph(100);
        Graph g2 = new Graph(100);
        BloodGraph blood = new BloodGraph(8);
        Kan k1 = new Kan("0+");
        Kan k2 = new Kan("0-");
        Kan k3 = new Kan("A+");
        Kan k4 = new Kan("B+");
        Kan k5 = new Kan("A-");
        Kan k6 = new Kan("B-");
        Kan k7 = new Kan("AB+");
        Kan k8 = new Kan("AB-");
        blood.addEdge(0, k1);//  0+
        blood.addEdge(0, k1);
        blood.addEdge(0, k3);
        blood.addEdge(0, k4);
        blood.addEdge(0, k7);

        blood.addEdge(1, k2); //0-
        blood.addEdge(1, k1);
        blood.addEdge(1, k3);
        blood.addEdge(1, k4);
        blood.addEdge(1, k5);
        blood.addEdge(1, k2);
        blood.addEdge(1, k6);
        blood.addEdge(1, k7);
        blood.addEdge(1, k8);

        blood.addEdge(2, k3);//A+
        blood.addEdge(2, k3);//A+
        blood.addEdge(2, k7);//A+

        blood.addEdge(3, k5);//A-
        blood.addEdge(3, k3);//A-
        blood.addEdge(3, k7);//A-
        blood.addEdge(3, k8);//A-
        blood.addEdge(3, k5);//A-

        blood.addEdge(4, k4); // B+
        blood.addEdge(4, k4); // B+
        blood.addEdge(4, k7); // B+

        blood.addEdge(5, k6);//B-
        blood.addEdge(5, k4);//B-
        blood.addEdge(5, k7);//B-
        blood.addEdge(5, k8);//B-
        blood.addEdge(5, k6);//B-

        blood.addEdge(6, k7);//AB+
        blood.addEdge(6, k7);//AB+

        blood.addEdge(7, k8);//AB-
        blood.addEdge(7, k8);//AB-
        blood.addEdge(7, k7);//AB-

        String talimatlar = "----------Kan Bağış Merkezi----------"
                + "\n1 - Kişi Ekleme."
                + "\n2 - İki kişinin aralarındaki kan bağış ilişkisini kontrol Etme."
                + "\n3 - Kan grubu ve RH’a göre kan bağışı ilişkisini gösteren genel çizge'yi Yazdır."
                + "\n4 - Kan Bağış Merkezinde kayıtlı herkesin kan bağış ilişkisini gösteren çizgeyi Yazdır."
                + "\n5 - Kan Bağışında aciliyet durumuna göre sıralanmış Kuyruğu Yazdır."
                + "\n6 - 2.Seçenek ile oluşan Eşleşme Çizgesini Yazdır. "
                + "\nÇıkış için q 'ya basınız."
                + "\n---------------------------------------------------------------------------------------------------";

        String choice = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(talimatlar);
            System.out.print("İşleminizi giriniz : ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("1")) {
                //        Person p8 = new Person("5661", "ab", "-", false, false);
                System.out.print("TC nizi giriniz : ");
                String tc = scanner.nextLine();
                System.out.print("Kan Grubunuzu giriniz (Örnek:(A,B,AB,0)) : ");
                String kan = scanner.nextLine();
                System.out.print("Rh durumunuzu giriniz (+ veya -) : ");
                String rh = scanner.nextLine();
                System.out.println("Hepatit Hastalığınız var mı ? (evet ise 1 , hayır ise  0 giriniz) : ");
                String answer = scanner.nextLine();
                boolean hepatit = false;
                if (answer.equalsIgnoreCase("1")) {
                    hepatit = true;
                }
                System.out.println("HIV Hastalığınız var mı ? (evet ise 1 , hayır ise  0 giriniz) : ");
                String ans2 = scanner.nextLine();
                boolean hiv = false;
                if (ans2.equalsIgnoreCase("1")) {
                    hiv = true;
                }
                g.addEdge(new Person(tc, kan, rh, hiv, hepatit));

            } else if (choice.equalsIgnoreCase("2")) {
                // 2 tc gir there metoduyla kontrol et ismatch le kontrol et birbirlerine kan verebiliyorlar mı ? 
                System.out.println("1. nin Tc sini giriniz (Vericinin TC'si): ");
                String tc1 = scanner.nextLine();
                System.out.println("2. nin Tc sini giriniz ( Alıcının TC'si):");
                String tc2 = scanner.nextLine();
                if (!g.isBasvuran(tc1) || !g.isBasvuran(tc2)) {
                    System.out.println("Girilen kayıtlardan en az bir tanesi bulunmamaktadır . Bu yüzden eşleşme yapılamadı.");
                    continue;
                } else {
                    Person tmp1;
                    Person tmp2;
                    if (g.getP(tc1).bagisciMi) {
                        tmp1 = g.getP(tc1);
                        tmp2 = g.getP(tc2);

                    } else {
                        tmp1 = g.getP(tc2);
                        tmp2 = g.getP(tc1);
                    }

                    if (tmp1 == null || tmp2 == null) {
                        System.out.println("Elemana ulaşamadık  hata!");
                    } else {
                        if (tmp1.isMatch(tmp2)) {
                            System.out.println("Başarılı eşleşme ...");
                            System.out.println(tmp1.tc + " Tc'li ve " + tmp1.kan + " gruplu kişi " + tmp2.tc + " Tc'li "
                                    + tmp2.kan + " gruplu kişiye kan verebilir.");
                            g2.addEdge(tmp1);
                            g2.addEdge(tmp2);

                            if (g2.c) {

                                System.out.println("Eşleşme Çizgisine eklendi . Bu eşleşme Çizgisini Yazdırmak için 6'ya basınız. ");
                            } else {
                                System.out.println("Maalesef Eşleşme Çizgisine eklenemedi ... Eşleşme Çizgisini Yazdırmak için 6'ya basınız. ");
                            }

                        } else {
                            System.out.println("Başarısız eşleşme!!!");
                            System.out.println(tmp1.tc + "'li ve " + tmp1.kan
                                    + " gruplu kişi " + tmp2.tc + "'li " + tmp2.kan
                                    + " gruplu kişiye kan Veremez.");

                        }
                    }

                }
            } else if (choice.equalsIgnoreCase("3")) {
                System.out.println("Vericiler ilk sirada bulunur .Çizge Komşuluk listesi olarak oluşturulmuştur");
                blood.printGraph();
            } else if (choice.equalsIgnoreCase("4")) {
                if (!g.basvurular.isEmpty()) {
                    System.out.println("---Kan Merkezindeki kayıtlı olan bağışçılar ve alıcıların Çizgesi ---");
                    System.out.println("Vericiler ilk sirada bulunur .Çizge Komşuluk listesi olarak oluşturulmuştur");
                    System.out.println("Toplam " + g.basvurular.size() + " adet kayıt bulunmaktadır.");
                    g.printGraph();
                } else {
                    System.out.println("Çizge de kayıtlı kimse yoktur.");
                }

            } else if (choice.equalsIgnoreCase("5")) {

                g.kuyruk2.printQueue();

            } else if (choice.equalsIgnoreCase("6")) {
                if (g2.basvurular.size() <= 1) {
                    System.out.println("Eşleşme Çizgesini oluşturmak için en az 1 başarılı eşleşme gerekli . "
                            + "\n1' basarak kişi ekleyip eşleşmelerinizi 2 'ye basarak gerçekleştirebilirsiniz. ");
                } else {
                    System.out.println("Eşleşme Çizgesi ;");
                    g2.printGraph();
                }

            } else if (choice.equalsIgnoreCase("q")) {
                System.out.println("Program sonlandırıldı...");
                return;
            } else {
                System.out.println("Yanlış bir seçim yaptınız . Lütfen aşağıdaki talimatlara uygun seçim yapınız .");
            }

        }

    }

}
