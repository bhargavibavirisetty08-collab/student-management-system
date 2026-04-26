package LinkedList;

public class LLmain {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(9);
        list.insertLast(4);
        list.insertLast(7);
        list.Display();
        System.out.println("size  : "+list.size);
        System.out.println(list.CycleDetection());
    }
}
