
public class Main {

    public static void main(String[] args) {

        String[] dizi = {"Sezaver", "Haluk", "Haldun", "Ayse", "Aysegul", "Osman", "Pinar", "Necati", "Nevzat",
            "Selda", "Asiye", "Gülhan", "Asena", "Harun", "Aliye", "Abidin", "Ali", "Ciğdem", "yarensu", "Çiğdem", "Alim",
            "Ramazan", "Ahmet", "Xamer", "Zeynep", "aysima"};

        Sorting s = new Sorting(dizi);

        s.radix();
        s.printArray(dizi);

    }
}
