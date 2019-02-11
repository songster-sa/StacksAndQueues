package test;

import main.SortStack;
import main.Stack;

public class SortStackTest {

    public static void main (String arg[]){
         SortStack obj = new SortStack();

         Stack input = new Stack();
         obj.solutionOne(input);
         obj.getResult().printStack();

        input.push(1);
        obj.solutionOne(input);
        obj.getResult().printStack();

        input.push(1);
        input.push(2);
        obj.solutionOne(input);
        obj.getResult().printStack(); // prints top first

        input.push(4);
        input.push(2);
        input.push(5);
        input.push(6);
        input.push(9);
        input.push(8);
        obj.solutionOne(input);
        obj.getResult().printStack();

    }
}
