package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeQueueInbuilt {
    public static void main(String[] args) {
        Deque<Integer>deque = new ArrayDeque<>();
         deque.add(3);
         deque.addFirst(4);
         deque.addLast(2);
         deque.contains(4);
        System.out.println(deque.element());
        System.out.println(deque.iterator());
        deque.offer(3);
        System.out.println(deque.offerFirst(2));
        System.out.println(deque.offerLast(3));
        System.out.println(deque.remove(9));
        System.out.println(deque.removeLastOccurrence(3));
        deque.add(0);
    }
}
