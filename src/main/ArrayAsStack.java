package main;

// Question 1  : use a single array to implement 3 stacks
public class ArrayAsStack {

    // start by giving some fixed space to each stack.
    // when full, then we add space and shift everything...
    // to avoid confusion - stack wont have -ve or 0s

    int n = 10; //  initial capacity
    private int[] array = new int[n * 3];
    int tops[] = new int[]{-1, -1, -1}; // index of the top element

    public void push(int stackNo, int data) {
        int minIndex = (stackNo * n);
        int maxIndex = ((stackNo + 1) * n) - 1;

        if (tops[stackNo] == -1) {
            array[minIndex] = data;
            tops[stackNo] = minIndex;
        } else {
            int topIndex = tops[stackNo];
            int next = topIndex + 1;
            if (next > maxIndex) {
                // TODO add more space
            } else {
                array[next] = data;
                tops[stackNo] = next;
            }
        }
    }

    public int pop(int stackNo) {
        if (tops[stackNo] == -1) {
            return -1;
        } else if (tops[stackNo] == 0) {
            tops[stackNo] = -1;
            int temp = array[0];
            array[0] = 0;
            return temp;
        } else {
            int temp = array[tops[stackNo]];
            array[tops[stackNo]] = 0;
            tops[stackNo] = tops[stackNo] - 1;
            return temp;
        }
    }

    public void printArray() {
        for (int val : array) {
            System.out.print(val + ",");
        }
        System.out.println();
    }
}
