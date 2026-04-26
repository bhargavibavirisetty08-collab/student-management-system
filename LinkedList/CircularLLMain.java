package LinkedList;

public class CircularLLMain {
    public static void main(String[] args) {
        CircularLL list = new CircularLL();
        list.InsertAtFirst(6);
        list.InsertAtFirst(7);
        list.InsertAtEnd(8);
        list.InsertAtEnd(3);
        list.InsertAtEnd(9);
        System.out.println(list.CycleDetection());
        System.out.println(list.CycleDetectionWithLength());
        list.display();

    }
}
