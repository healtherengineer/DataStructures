
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Kiosk kiosk = new Kiosk();
        Vezne v1 = new Vezne();
        Vezne v2 = new Vezne();
        Vezne v3 = new Vezne();
        Vezne v4 = new Vezne();
        Vezne[] vezneler = new Vezne[4];

        vezneler[0] = v1;
        vezneler[1] = v2;
        vezneler[2] = v3;
        vezneler[3] = v4;

        Bank bank = new Bank(kiosk, vezneler);

        String talimatlar = "---------Bankamıza Hoşgeldiniz --------\n"
                + "Şu anda Kiosk un Önündesiniz\n"
                + "Sıra Numarası almak için 1'e basınız...\n"
                + "Çıkış için 0'a tıklayınız";

        String choice = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(talimatlar);
            System.out.print("Seçim Yap : ");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("İşlem süresi gir : ");
                kiosk.siraVer(new Customer(scanner.nextInt()));
                scanner.nextLine();// dummy

                while (kiosk.list.first != null) {
                    if (veznelerFullMi(bank.vezneler)) {
                        System.out.println("Tüm veznelerimiz full ...");
                        break;
                    } else {
                        int uygunind = uygunVezneBul(bank.vezneler);
                        int ctrl = vezneler[uygunind].vezneYeEkle(kiosk.list.first.customer);
                        if (ctrl == 1) {
                            System.out.println((uygunind + 1) + " . vezneye eklendi .\n");
                            System.out.println(("Bu vezne de toplam  : " + vezneler[uygunind].kuyruk.es + " adet müşteri vardır." + vezneler[uygunind].kuyruk.tail) + ". Sıradasınız .");
                            bank.anlıkVezneDurum();

                            kiosk.list.first = kiosk.list.first.next;
                        } else {
                            break;
                        }

                    }

                }

            } 
            else if(choice.equals("0")){
                System.out.println("Program sonlandırıldı ...");
                return;
            }
            
            else {
                System.out.println("Geçersiz bir işlem girdiniz . Tekrar deneyiniz ...");
             
            }
        }

    }

    public static boolean veznelerFullMi(Vezne[] vezneler) {
        for (int i = 0; i < vezneler.length; i++) {
            if (!vezneler[i].isFull()) {
                return false;
            }
        }
        return true;
    }

    public static int uygunVezneBul(Vezne[] vezneler) {
        int min = 0;
        for (int i = 0; i < vezneler.length; i++) {

            if (!vezneler[i].isFull()) {
                if (vezneler[i].kuyruk.totalSure < vezneler[min].kuyruk.totalSure) {
                    min = i;
                }

            }
        }
        return min;

    }

}
