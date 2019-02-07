package main;

// Question 2 : implement a stack to return min element. push, pop, min should all operate in O(1)
public class StackWithMin {

    // at each push, we need to maintain the min so that when its popped we can use it
    // update Node class itself, or maintain in a separate stack / array / DS

    private Node top;
    private Stack minStack = new Stack();

    public Object pop() {
        if (top != null) {
            Node temp = top;
            top = top.getNext();
            minStack.pop();
            return temp.getData();
        }
        return null;
    }

    public void push(Object data) {
        if (minStack.peek() == null) {
            minStack.push(data);
        } else {
            int min = (int) minStack.peek();
            min = min <= (int) data ? min : (int) data;
            minStack.push(min);
        }
        Node node = new Node(data, top);
        top = node;
    }

    public Object peek() {
        return top.getData();
    }

    public int getMin() {
        return minStack.peek() == null ? -1 : (int) minStack.peek();
    }
}
