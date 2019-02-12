package main;

/**
 * Sort a stack (biggest on top).. using more stacks.
 * Example:
 * 1 - 1
 * 1,2,3 - 1,2,3
 * 4,2,5,6,9,8 - 2,4,5,6,8,9
 */
public class SortStack {

    private Stack result = new Stack();
    private Stack placeholder = new Stack();
    private int count;

    public void solutionOne(Stack input) {

        if (input.isEmpty()) {
            return;
        }
        int min = (int) input.pop();

        while (!input.isEmpty()) {
            Object data = input.pop();
            if ((int) data < min) {
                count++;
                placeholder.push(min);
                min = (int) data;
            } else {
                count++; // so we know how many more elements we have to sort
                placeholder.push(data);
            }
        }

        result.push(min);

        while (!placeholder.isEmpty()) {
            input.push(placeholder.pop());
        }

        solutionOne(input);
    }

    public void solutionTwo(Stack input) {
        if (input.isEmpty()) {
            return;
        }

        while (!input.isEmpty()) {
            Object data = input.pop();

            // add to result stack

            if (result.isEmpty()) {
                result.push(data);
                continue;
            }

            Object top = result.peek();
            if ((int) top <= (int) data) {
                result.push(data);
                continue;
            } else {
                // need to push in middle somewhere
                count = 0;
                while (top != null && (int) top > (int) data) {
                    count++;
                    input.push(result.pop());
                    top = result.peek();
                }
                result.push(data);
                while (count > 0) {
                    count--;
                    result.push(input.pop());
                }
            }
        }
    }

    public Stack getResult() {
        return result;
    }
}
