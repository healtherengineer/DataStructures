
import java.util.Arrays;

public class Queue {

    private int elementCount;
    private int[] array;
    private int head;
    private int tail;

    public Queue(int boyut) {
        this.elementCount = 0;
        this.array = new int[boyut];
        this.head = 0;
        this.tail = 0;
    }

    public void insert(int yeni) {

        if (!this.isFull()) {
            if (this.tail == this.array.length) {
                this.tail = 0;
            }
            this.array[this.tail++] = yeni;
            this.elementCount++;

        } else {
            System.out.println("Quee is Full ..!" + yeni + " was not added by the program ...");
        }

    }

    public int remove() {
        if (this.head == this.array.length) {
            this.head = 0;
        }
        if (!this.isEmpty()) {
            this.elementCount--;
            return this.array[head++];

        } else {
            System.out.println("Quee is Empty..!");
            return -1;
        }
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    public boolean isFull() {
        return this.elementCount == array.length;
    }

    public void print() {
        System.out.print("[");
        for (int i = head; i < this.head + this.elementCount; i++) {
            System.out.print(array[i % this.array.length] + ",");

        }
        System.out.print("] \n");
        System.out.println(">" + Arrays.toString(array));
    }

}
