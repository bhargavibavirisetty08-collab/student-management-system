package StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePredefined {
    public static void main(String[] args) {
        Queue<Integer>queue = new LinkedList<>();
        queue.add(3);
        queue.add(6);
        queue.add(8);
        queue.add(15);
        System.out.println(queue.remove());
        queue.peek();
        System.out.println(queue.element());
        System.out.println(queue.poll());
        System.out.println(queue.offer(3));
    }
}
