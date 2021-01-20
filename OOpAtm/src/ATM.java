
import java.util.Scanner;

public class ATM {

    public void calistir(Hesap hesap) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bankamıza Hoş Geldiniz ...");
        System.out.println("**************************************");
        System.out.println("Kullanıcı Paneli");
        System.out.println("**************************************");
        Login login = new Login();
        int giris_hakki = 3;
        while (true) {
            if (giris_hakki <= 0) {
                System.out.println("Giriş Hakkınız doldu . Sistem Kendini 3 saniye içerisinde bloke edecek !!!");
                Thread.sleep(3000);
                System.out.println("Sistem Kapatıldı.");
                return;

            }
            if (login.login(hesap)) {
                System.out.println("Giriş Başarılı...");

                break;
            } else {
                System.out.println("Giriş Başarısız ...");

                System.out.println("Kalan Giriş Hakkı : " + --giris_hakki);
            }

        }
        String islemler = "1-Hesap Bilgisini göster ... \n"
                + "2-Para Çek...\n"
                + "3-Para Yatır...\n"
                + "q- Atm'den Çık ...\n";
        while (true) {
            System.out.println(islemler);
            System.out.print("Yapmak istediğiniz işlemi seçiniz  : ");
            String islem = scanner.nextLine();

            if (islem.equals("1")) {
                hesap.bakiyeBilgi();
            } else if (islem.equals("2")) {
                System.out.print("Çekmek istediğiniz miktarı giriniz  : ");
                int miktar = scanner.nextInt();
                scanner.nextLine(); // dummy
                hesap.paraCek(miktar);
            } else if (islem.equals("3")) {
                System.out.print("Yatırmak istediğiniz miktarı giriniz  : ");
                int miktar = scanner.nextInt();
                scanner.nextLine(); // dummy
                hesap.paraYatir(miktar);
            } else if (islem.equalsIgnoreCase("q")) {
                System.out.println("Bizi tercih ettiğiniz için teşekkürler ...");
                Thread.sleep(3000);
                return;
            } else {
                System.out.println("Geçersiz bir işlem seçtiniz ...");
            }

        }

    }
}
