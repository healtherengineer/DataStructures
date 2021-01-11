
public class Person {

    String tc;
    boolean bagisciMi;
    boolean aliciMi;
    String kanGrubu;
    String rh;
    String kan;
    boolean hiv;
    boolean hepatitB;
    int aciliyet;
    String[] alabildikleri;
    String[] verebildikleri;

    public Person(String tc, String kanGrubu, String rh, boolean hiv, boolean hepatitB) {
        this.tc = tc;
        this.kanGrubu = kanGrubu;
        this.rh = rh;
        this.hiv = hiv;
        this.hepatitB = hepatitB;
        this.kan = this.kanGrubu.trim().toUpperCase() + this.rh.trim().toUpperCase();
        this.aliciMi = true;
        if (this.hiv == true || this.hepatitB == true) {
            this.bagisciMi = false;

        } else {
            this.bagisciMi = true;

        }
        if (this.kan.equalsIgnoreCase("0+")) {
            alabildikleri = new String[2];
            alabildikleri[0] = "0+";
            alabildikleri[1] = "0-";
            verebildikleri = new String[4];
            verebildikleri[0] = "0+";
            verebildikleri[1] = "A+";
            verebildikleri[2] = "B+";
            verebildikleri[3] = "AB+";
            this.aciliyet = 4;

        } else if (this.kan.equalsIgnoreCase("0-")) {
            alabildikleri = new String[1];
            alabildikleri[0] = "0-";
            verebildikleri = new String[8];
            verebildikleri[0] = "AB+";
            verebildikleri[1] = "0-";
            verebildikleri[2] = "A+";
            verebildikleri[3] = "A-";
            verebildikleri[4] = "B+";
            verebildikleri[5] = "B-";
            verebildikleri[6] = "0+";
            verebildikleri[7] = "AB-";
            this.aciliyet = 10;

        } else if (this.kan.equalsIgnoreCase("A+")) {
            alabildikleri = new String[4];
            alabildikleri[0] = "0+";
            alabildikleri[1] = "0-";
            alabildikleri[2] = "A-";
            alabildikleri[3] = "A+";
            verebildikleri = new String[2];
            verebildikleri[0] = "A+";
            verebildikleri[1] = "AB+";
            this.aciliyet = 2;

        } else if (this.kan.equalsIgnoreCase("A-")) {
            alabildikleri = new String[2];
            alabildikleri[0] = "0-";
            alabildikleri[1] = "A-";
            verebildikleri = new String[4];
            verebildikleri[0] = "A+";
            verebildikleri[1] = "A-";
            verebildikleri[2] = "AB+";
            verebildikleri[3] = "AB-";
            this.aciliyet = 4;

        } else if (this.kan.equalsIgnoreCase("B+")) {
            alabildikleri = new String[4];
            alabildikleri[0] = "0+";
            alabildikleri[1] = "0-";
            alabildikleri[2] = "B-";
            alabildikleri[3] = "B+";
            verebildikleri = new String[2];
            verebildikleri[0] = "B+";
            verebildikleri[1] = "AB+";
            this.aciliyet = 2;

        } else if (this.kan.equalsIgnoreCase("B-")) {
            alabildikleri = new String[2];
            alabildikleri[0] = "0-";
            alabildikleri[1] = "B-";
            verebildikleri = new String[4];
            verebildikleri[0] = "B+";
            verebildikleri[1] = "B-";
            verebildikleri[2] = "AB+";
            verebildikleri[3] = "AB-";
            this.aciliyet = 4;

        } else if (this.kan.equalsIgnoreCase("AB+")) {
            alabildikleri = new String[8];
            alabildikleri[0] = "0+";
            alabildikleri[1] = "0-";
            alabildikleri[2] = "B-";
            alabildikleri[3] = "B+";
            alabildikleri[4] = "A+";
            alabildikleri[5] = "A-";
            alabildikleri[6] = "AB+";
            alabildikleri[7] = "AB-";
            verebildikleri = new String[1];
            verebildikleri[0] = "AB+";
            this.aciliyet = 1;

        } else if (this.kan.equalsIgnoreCase("AB-")) {
            alabildikleri = new String[4];
            alabildikleri[0] = "0-";
            alabildikleri[1] = "A-";
            alabildikleri[2] = "B-";
            alabildikleri[3] = "AB-";
            verebildikleri = new String[2];
            verebildikleri[0] = "AB-";
            verebildikleri[1] = "AB+";
            this.aciliyet = 2;

        } else {
            System.out.println("Geçersiz kan grubu !.");
        }
    }

    public boolean isMatch(Person p) {
        if (this.bagisciMi) {
            if (p.aliciMi) {
                for (String i : this.verebildikleri) {
                    if (i.equalsIgnoreCase(p.kan)) {
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }

        } else {
            //alici
            if (p.bagisciMi) {
                for (String i : p.verebildikleri) {
                    if (i.equalsIgnoreCase(this.kan)) {
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }

        }
    }

    @Override
    public String toString() {
        return "[" + this.tc + "," + this.kan + "," + (this.bagisciMi == true ? "Verici" : "Alıcı") + "]";
    }

}
