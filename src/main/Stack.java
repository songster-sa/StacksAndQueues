package main;

public class Stack {

    private Node top;

    public Object pop() {
        if (top != null) {
            Node temp = top;
            top = top.getNext();
            capacity++;
            return temp.getData();
        }
        return null;
    }

    public void push(Object data) {
        Node node = new Node(data, top);
        top = node;
        capacity--;
    }

    public Object peek() {
        return top != null ? top.getData() : null;
    }

    /****** for set of stack question ************/

    private Stack next;

    private int capacity;

    public Stack() {
        // default constructor
    }

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public Stack getNext() {
        return next;
    }

    public void setNext(Stack next) {
        this.next = next;
    }

    public boolean hasCapacity() {
        return capacity > 0;
    }
}
