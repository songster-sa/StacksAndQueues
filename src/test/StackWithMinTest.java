package test;

import main.StackWithMin;

public class StackWithMinTest {
    public static void main(String args[]) {
        StackWithMin obj = new StackWithMin();

        System.out.println(obj.getMin());
        obj.push(10);
        System.out.println(obj.getMin());
        obj.push(4);
        System.out.println(obj.getMin());
        obj.push(5);
        System.out.println(obj.getMin());
        obj.push(2);
        System.out.println(obj.getMin());
        obj.push(1);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
