package jiq.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        stack();
    }

    static void stack() {
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);

        System.out.println(integers);

        System.out.println(integers.pop());
        System.out.println(integers.peek());
        System.out.println(integers.pop());

        System.out.println(integers);
    }

    static void queue() {
        Queue<Integer> integers = new LinkedList<>();

    }

}
