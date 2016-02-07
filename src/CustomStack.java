/**
 * Custom Stack implementation in Java
 */
public class CustomStack {

    //Max Size
    private int maxSize;
    //Internal Array to hold the data
    private int[] dataArray;
    //Position pointer
    private int pos;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        dataArray = new int[this.maxSize];
    }

    public int push(int data) {
        if (isFull()) {
            System.out.println("Stack is full. so can't push the data :" + data);
            return -1;
        }
        dataArray[pos++] = data;
        return data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. so can't pop the data");
            return -1;
        }
        return dataArray[--pos];
    }

    public int peek() {
        return dataArray[pos - 1];
    }

    public boolean isEmpty() {
        return (pos == 0);
    }

    public boolean isFull() {
        return (pos == maxSize);
    }

    public int search(int data) {
        int findPos = -1;
        for(int i = 0; i < dataArray.length; i++){
            if(data == dataArray[i]){
                findPos = i;
                break;
            }
        }
        if (findPos >= 0) {
            return pos - findPos;
        }
        return -1;
    }

    public static void main(String[] args) {
        final int MAX_SIZE = 5;
        CustomStack customStack = new CustomStack(MAX_SIZE);
        for (int i = 1; i <= MAX_SIZE; i++) {
            System.out.println("Inserting data " + i * 100);
            customStack.push(i * 100);
        }
        System.out.println("Top element in the stack is:" + customStack.peek());
        System.out.println("Element distance is:" + customStack.search(100));
        //Print all the elements one by one by using pop.
        while (!customStack.isEmpty()) {
            System.out.println("Retrieving data one by one: LIFO");
            System.out.println(customStack.pop());
        }
        System.out.println(customStack.pop());
    }

}
