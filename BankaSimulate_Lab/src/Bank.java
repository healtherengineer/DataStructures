
public class Bank {

    Kiosk k;
    Vezne[] vezneler;

    public Bank(Kiosk k, Vezne[] vezneler) {
        this.k = k;
        this.vezneler = vezneler;
    }
   

    public void anlıkVezneDurum() {
        for (int i = 0; i < vezneler.length; i++) {
            int tmp = i;
            System.out.println((tmp + 1) + " . veznemizde " + vezneler[i].kuyruk.totalSure + " dakikalık işlem mevcuttur .");
        }
    }

}
