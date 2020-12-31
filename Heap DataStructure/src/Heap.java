
public class Heap {

    int[] array;
    int index;
    int size;

    public Heap(int[] array) {
        this.array = array;
        this.index = 0;
        this.size = array.length;
    }

    public void swap(int a, int b) {
        int temp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = temp;

    }

    public void heapify(int indis) {
        boolean c = true;
        for (int i = indis; indis >= 0 && c;) {
            c = false;
            if (this.array[indis] > this.array[(indis - 1) / 2]) {
                c = true;

                swap(indis, (indis - 1) / 2);

                indis = (indis - 1) / 2;

            }

        }

    }

    public void insert(int x) {

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
    public void delete() {
        if (!isEmpty()) {
            this.array[0] = this.array[this.index - 1];
            this.index--;
            heapifyDown();

        } else {
            System.out.println("Your Heap is empty .Could not delete process");
        }

    }

    public void heapifyDown() {
        boolean c = true;
        for (int i = 0; i < this.index && c;) {
            c = false;
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < this.index && r < this.index) {
                if (this.array[i] < this.array[l] || this.array[i] < this.array[r]) {
                    c = true;
                    if (this.array[l] < this.array[r] && this.array[i] < this.array[r]) {
                        swap(i, r);
                        i = 2 * i + 2;
                    } else if (this.array[r] < this.array[l] && this.array[i] < this.array[l]) {
                        swap(i, l);
                        i = 2 * i + 1;
                    }
                }

            } else if (l < this.index) {
                 c = true;
                if (this.array[i] < this.array[l]) {
                    swap(i, l);
                }
                i = 2 * i + 1;

            } else if (r < this.index) {
                 c = true;
                if (this.array[i] < this.array[r]) {
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
    public void printHeap(){
        System.out.print("[");
        for(int i = 0 ; i < this.index ; i++){
            System.out.print(this.array[i] + ","+ " ");
        }
        System.out.print("]");
        System.out.println("");
    }

}
