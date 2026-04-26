package StackAndQueues;

public class MyQueue {
    int[] stack1;
    int[] stack2;
    int top1 = -1;
    int top2 = -1;

    public MyQueue() {
        stack1 = new int[10];
        stack2 = new int[10];
    }

    public void push(int x) {
        top1++;
        stack1[top1] = x;
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        move();
        int removed = stack2[top2];
        top2--;
        move();
        return removed;
    }

    public int peek() {
        if (empty()) {
            return -1;
        }
        move();
        int peek =  stack2[top2];
        move();
        return peek;
    }

    public boolean empty() {

        return top1 == -1 && top2 == -1;
    }

    public void move() {
        if (top2 == -1) {
            while (top1 != -1) {
                top2++;
                stack2[top2] = stack1[top1];
                top1--;
            }
        } else if(top1 == -1) {
            while (top2 != -1) {
                top1++;
                stack1[top1] = stack2[top2];
                top2--;
            }
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(9);
        q.push(7);
        q.push(8);
        System.out.println(q.peek());
        System.out.println(q.pop());
    }
}

