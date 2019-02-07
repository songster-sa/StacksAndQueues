package test;

import main.SetOfStacks;

public class SetOfStacksTest {

    public static void main(String args[]) {
        SetOfStacks obj = new SetOfStacks();

        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.push(6);
        obj.push(7);
        obj.push(8);
        obj.push(9);
        obj.push(10);
        obj.push(11);

        System.out.println(obj.pop());
        //System.out.println(obj.pop());
        System.out.println(obj.popAt(0)); // top
        System.out.println(obj.popAt(1));

    }
}
