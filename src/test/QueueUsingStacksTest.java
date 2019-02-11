package test;

import main.QueueUsingStacks;

public class QueueUsingStacksTest {

    public static void main(String arg[]) {
        QueueUsingStacks obj = new QueueUsingStacks();

        System.out.println(obj.pop());
        obj.push(1);
        System.out.println(obj.pop());
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        obj.push(4);
        System.out.println(obj.pop());
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());

    }
}
