package main;

public class Queue {

    private Node first, last;

    public void enqueue(Object data) {

        Node node = new Node(data, null);

        if (first == null) {
            first = last = node;
        } else {
            last.setNext(node);
            last = node;
        }
    }

    public Node dequeue() {
        if (first != null) {
            Node node = first;
            first = first.getNext();
            return node;
        }
        return null;
    }
}
