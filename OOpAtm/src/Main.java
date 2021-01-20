
public class Main {
    public static void main(String[] args) throws InterruptedException {
      
        ATM atm = new ATM();
        Hesap hesap = new Hesap("Ege Barisan", "456", 3000);
        atm.calistir(hesap);
        System.out.println("3 saniye içinde Atm Kapatılacaktır ...");
        Thread.sleep(3000);
        System.out.println("Barisan Bank İyi Günler Diler");
    }
    
}
