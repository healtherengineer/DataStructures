
import java.util.Scanner;

public class Login {

    public boolean login(Hesap hesap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kullanıcı Adı  : ");
        String k_adi = scanner.nextLine();
        System.out.println("Parola  : ");
        String parola = scanner.nextLine();
        if (k_adi.equals(hesap.getKullanici_adi()) && parola.equals(hesap.getParola())) {
            return true;
        } else {
            return false;
        }

    }

}
