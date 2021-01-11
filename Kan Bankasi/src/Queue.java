
public class Queue {

    Person[] array;
    int index;
    int size;

    public Queue() {
        this.array = new Person[100];
        this.index = 0;
        this.size = array.length;
    }

    public void swap(int a, int b) {
        Person temp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = temp;

    }

    public void heapify(int indis) {
        boolean c = true;
        for (int i = indis; indis >= 0 && c;) {
            c = false;
            if (this.array[indis].aciliyet > this.array[(indis - 1) / 2].aciliyet) {
                c = true;

                swap(indis, (indis - 1) / 2);

                indis = (indis - 1) / 2;

            }

        }

    }

    public void insert(Person x) {

        if (isEmpty()) {
            this.array[index] = x;
            this.index++;
        } else {
            if (!isFull()) {
                this.array[index] = x;
                heapify(index);

                index++;
            } else {
                System.out.println("Your Heap is full . Could not added ");
            }

        }

    }

    // deletion proccesing
    public Person delete() {
        if (!isEmpty()) {
            Person tmp = this.array[0];
            this.array[0] = this.array[this.index - 1];
            this.index--;
            heapifyDown();

            return tmp;
        } else {
            System.out.println("Your Heap is empty .Could not delete process");
            return null;
        }

    }

    public void heapifyDown() {
        boolean c = true;
        for (int i = 0; i < this.index && c;) {
            c = false;
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < this.index && r < this.index) {
                if (this.array[i].aciliyet < this.array[l].aciliyet || this.array[i].aciliyet < this.array[r].aciliyet) {
                    c = true;
                    if (this.array[l].aciliyet < this.array[r].aciliyet && this.array[i].aciliyet < this.array[r].aciliyet) {
                        swap(i, r);
                        i = 2 * i + 2;
                    } else if (this.array[r].aciliyet < this.array[l].aciliyet && this.array[i].aciliyet < this.array[l].aciliyet) {
                        swap(i, l);
                        i = 2 * i + 1;
                    }
                }

            } else if (l < this.index) {
                c = true;
                if (this.array[i].aciliyet < this.array[l].aciliyet) {
                    swap(i, l);
                }
                i = 2 * i + 1;

            } else if (r < this.index) {
                c = true;
                if (this.array[i].aciliyet < this.array[r].aciliyet) {
                    swap(i, r);
                    i = 2 * i + 2;
                }

            }

        }

    }

    public boolean isFull() {
        return this.index == this.size;
    }

    public boolean isEmpty() {
        return this.index == 0;
    }

    public void printQueue() {
        System.out.print("[");
        for (int i = 0; i < this.index; i++) {
            System.out.print(this.array[i] + "," + " ");
        }
        System.out.print("]");
        System.out.println("");
    }

}
