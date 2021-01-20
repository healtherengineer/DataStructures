
public class Kuyruk {

     int es;
    Customer[] musteriler;
    private int head;
    int tail;
    int totalSure;

    public Kuyruk(int boyut) {
        this.es = 0;
        this.musteriler = new Customer[boyut];
        this.head = 0;
        this.tail = 0;
        totalSure = 0;
    }

    public void insert(Customer yeni) {

        if (!this.isFull()) {
            if (this.tail == this.musteriler.length) {
                this.tail = 0;
            }
            this.musteriler[this.tail++] = yeni;
            totalSure += yeni.islemSüresi;
            this.es++;

        } else {
            System.out.println("Kuyruk Dolu ..! ");
        }

    }

    public Customer remove() {
        if (this.head == this.musteriler.length) {
            this.head = 0;
        }
        if (!this.isEmpty()) {
            this.es--;
            this.totalSure -= this.musteriler[head].islemSüresi;
            return this.musteriler[head++];

        } else {
            System.out.println("Queue  boş remove işlemi uygulanamadı..!");
            return null;
        }
    }

    public boolean isEmpty() {
        return this.es == 0;
    }

    public boolean isFull() {
        return this.es == musteriler.length;
    }

    public void print() {
        System.out.print("[");
        for (int i = head; i < this.head + this.es; i++) {
            System.out.print(musteriler[i % this.musteriler.length] + ",");

        }
        System.out.print("] \n");

    }
}
