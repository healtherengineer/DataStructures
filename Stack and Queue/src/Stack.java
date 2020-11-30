
import java.util.Arrays;

public class Stack {

    int elementCount;
    int[] array;

    public Stack(int stackSize) {

        this.elementCount = 0;
        this.array = new int[stackSize];
    }

    public void push(int yeni) {

        if (!this.isFull()) {
            this.array[elementCount++] = yeni;
        } else {
            System.out.println("Stack is Full ! " + yeni + " was not added by the program ...");
        }
    }

    public int pop() {
        if (!this.isEmpty()) {
            int temp = this.array[elementCount - 1];
            this.elementCount--;
            return temp;

        } else {
            System.out.println("Stack is Empty ..!");
            return -1;
        }

    }

    public boolean isEmpty() {
        return elementCount == 0;

    }

    public boolean isFull() {
        return elementCount == this.array.length;

    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < elementCount; i++) {
            System.out.print(array[i] + ",");

        }
        System.out.print("] \n");
        System.out.println(">" + Arrays.toString(array));

    }

    public int peek() {
        if (!this.isEmpty()) {
            int tmp = this.array[elementCount - 1]; // Peek method return top value of the stack without removing .!.
            // here is difference between peek and pop methods 

            return tmp;

        } else {
            System.out.println("There is no element in the Stack");
            return -1; // invalid value for this project it depends on project
        }
    }

}
