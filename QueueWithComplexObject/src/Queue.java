
public class Queue {

    private int elementcount;
    private Car[] cars;
    private int head;
    private int tail;

    public Queue(int dimension) {
        this.elementcount = 0;
        this.cars = new Car[dimension];
        this.head = 0;
        this.tail = 0;
    }

    public void insert(Car car) {

        if (!this.isFull()) {
            if (this.tail == this.cars.length) {
                this.tail = 0;
            }
            this.cars[this.tail++] = car;
            this.elementcount++;

        } else {
            System.out.println("Queue is Full...! " + car.getBrand() + " " + car.getModel() + " was not added in Queue");
        }

    }

    public Car remove() {
        if (this.head == this.cars.length) {
            this.head = 0;
        }
        if (!this.isEmpty()) {
            this.elementcount--;
            return this.cars[head++];

        } else {
            System.out.println("Remove procces was not iplemented because of empty Queue . ");
            return null;
        }
    }

    public boolean isEmpty() {
        return this.elementcount == 0;
    }

    public boolean isFull() {
        return this.elementcount == cars.length;
    }

    public void print() {
        System.out.print("[");
        for (int i = head; i < this.head + this.elementcount; i++) {
            System.out.print(cars[i % this.cars.length].getCar() + ",");

        }
        System.out.print("] \n");

    }

}
