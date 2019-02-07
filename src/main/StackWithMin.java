package main;

// Question 2 : implement a stack to return min element. push, pop, min should all operate in O(1)
public class StackWithMin {

    private Node top;
    private int min;

    public Object pop() {
        if (top != null) {
            Node temp = top;
            top = top.getNext();
            return temp.getData();
        }
        return null;
        // TODO how to get new min when a min is popped
    }

    public void push(Object data) {
        min = min <= (int) data ? min : (int) data;
        Node node = new Node(data, top);
        top = node;
    }

    public Object peek() {
        return top.getData();
    }

    public int getMin() {
        return min;
    }
}
