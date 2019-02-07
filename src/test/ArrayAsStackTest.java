package test;

import main.ArrayAsStack;

public class ArrayAsStackTest {

    public static void main(String args[]) {
        ArrayAsStack obj = new ArrayAsStack();

        obj.printArray();
        obj.push(0, 100);
        obj.push(1, 200);
        obj.push(2, 300);
        obj.printArray();
        obj.push(0, 103);
        obj.push(0, 130);
        obj.printArray();
        obj.push(2, 332);
        obj.push(0, 140);
        obj.printArray();
        obj.push(1, 245);
        obj.push(1, 205);
        obj.printArray();

        System.out.println();
        obj.pop(0);
        obj.printArray();
        obj.push(2, 344);
        obj.push(0, 198);
        obj.pop(1);
        obj.printArray();
        obj.push(1, 278);
        obj.push(1, 211);
        obj.pop(2);
        obj.printArray();

        System.out.println();
        obj.pop(2);
        obj.pop(2);
        obj.printArray();
        obj.pop(2);
        obj.printArray();
    }
}
