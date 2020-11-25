
public class Main {

    public static void main(String[] args) {
        Araba a1 = new Araba("Linea", 2010);
        Araba a2 = new Araba("Toyota", 2014);
        Araba a3 = new Araba("Aston-Martin", 2008);
        Araba a4 = new Araba("Audi", 2019);
        Araba a5 = new Araba("Saaba", 1995);
        Araba a6 = new Araba("Renault", 1994);
        Araba a7 = new Araba("Sandero", 2020);
        Araba a8 = new Araba("Tesla", 2012);

        Liste list = new Liste();
        list.add(a1);
        list.print();
        list.add(a2);
        list.print();
        list.add(a3);
        list.print();
        list.add(a4);
        list.print();
        list.add(a5);
        list.print();
        list.add(a6);
        list.print();
        list.add(a7);
        list.print();
        list.add(a8);
        list.print();

    }
}
