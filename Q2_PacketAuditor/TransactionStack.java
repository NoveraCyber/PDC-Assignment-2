package Q2_PacketAuditor;

public class TransactionStack {
    private char[] stackArray;
    private int top;
    private int capacity;

    public TransactionStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new char[capacity];
        this.top = -1;
    }

    public void push(char c) {
        if (top < capacity - 1) stackArray[++top] = c;
    }

    public char pop() {
        return !isEmpty() ? stackArray[top--] : '\0';
    }

    public char peek() {
        return !isEmpty() ? stackArray[top] : '\0';
    }

    public boolean isEmpty() {
        return top == -1;
    }
}