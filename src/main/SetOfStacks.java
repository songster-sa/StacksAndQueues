package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Question 3 : add new stack when exceeds capacity
 * push and pop should work just like a normal stack
 */
public class SetOfStacks {

    private Stack top;

    public void push(Object data) {
        if (top == null) {
            Stack stack = new Stack(5);
            top = stack;
        } else if (!top.hasCapacity()) {
            Stack stack = new Stack(5);
            top.setNext(stack);
            top = stack;
        }
        top.push(data);
    }

    public Object pop() {
        if (top == null) {
            return null;
        } else if (top.pop() == null) {
            top = top.getNext(); // previous stack
        }
        return top.pop();
    }

    public Object popAt(int stackNo) {
        // stackNo is 0 for top... and 1 for next to top.. and so on..

        if (top == null) {
            return null;
        }
        Stack curr = top;

        while (stackNo != 0) {
            curr = curr.getNext();
            stackNo--;
        }

        return curr.pop();
    }

}
