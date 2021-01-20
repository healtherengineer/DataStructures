
public class Araba {

     String marka;
     int yil;

    public Araba(String marka, int yil) {
        this.marka = marka;
        this.yil = yil;
    }

    @Override
    public String toString() {
        return "[" + this.yil + "--" + this.marka + "]"; //To change body of generated methods, choose Tools | Templates.
    }

}
