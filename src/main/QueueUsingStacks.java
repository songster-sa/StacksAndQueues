package main;

/**
 * Queue (FIFO)  using 2 stacks (LIFO)
 */

public class QueueUsingStacks {

    private Stack incoming = new Stack();
    private Stack outgoing = new Stack();

    public void push(Object data) {
        incoming.push(data);
    }

    public Object pop() {
        if (outgoing.isEmpty()) {
            reCreateOut();
        }
        return outgoing.pop();
    }

    private void reCreateOut() {
        // will be called only when outgoing is empty - we can add a check if required
        if (outgoing.isEmpty() && !incoming.isEmpty()) {
            while (incoming.peek() != null) {
                outgoing.push(incoming.pop());
            }
        }
    }

}
