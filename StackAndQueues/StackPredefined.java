package StackAndQueues;

import java.util.Stack;

public class StackPredefined {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
       // System.out.println(stack.pop());
        System.out.println("3 at "+ stack.search(3));
        System.out.println("4 at "+stack.search(4));
        System.out.println("5 at " + stack.search(5));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
       // System.out.println(stack.peek());
        if(stack.empty()){
            System.out.println("Stack is Empty");
        }
        else {
            System.out.println(stack.pop());
        }
        System.out.println(stack.search(2));
    }
}
