
public class Main {

    public static void main(String[] args) {

        Queue kuyruk = new Queue(5);

        //Queue boşken direk remove larsam 
        kuyruk.remove();
        kuyruk.print();

        //Queue yi dolduruyorum
        kuyruk.insert(new Car("Toyota", "Corolla", 2010));
        kuyruk.print();
        kuyruk.insert(new Car("Honda", "Cıvıc", 2014));
        kuyruk.print();
        kuyruk.insert(new Car("Renault", "Kangoo", 2012));
        kuyruk.print();
        kuyruk.insert(new Car("Fiat", "Linea", 2008));
        kuyruk.print();
        kuyruk.insert(new Car("Wolkswagen", "Amarok", 2016));
        kuyruk.print();
        kuyruk.insert(new Car("Audi", "A8", 2017));
        kuyruk.print();

        System.out.println("--------------------------------------------");
        //Queue is emptying  ... 
        kuyruk.remove();
        kuyruk.print();
        kuyruk.insert(new Car("Tesla", "Model S", 2019));
        kuyruk.print();
        // We can add this end of the queue because We have enough space for Tesla 
        kuyruk.remove();
        kuyruk.print();
        kuyruk.remove();
        kuyruk.print();
        kuyruk.remove();
        kuyruk.print();
        kuyruk.remove();
        kuyruk.print();
        kuyruk.remove();
        kuyruk.print();
    }
}
