package LinkedList;

public class DoubleLLMain {
    public static void main(String[] args) {
        DoubleLL list = new DoubleLL();
        list.insertAtFirst(18);
        list.insertAtFirst(12);
        list.insertAtFirst(6);
        list.insertAtFirst(11);
        list.insertAtLast(1);
        list.insertAtLast(23);
        list.insertAtPosition(100,2);
       list.DelAtEnd();
        list.DelAtFirst();
        list.DelAtPosition(2);
        list.display();

    }
}
