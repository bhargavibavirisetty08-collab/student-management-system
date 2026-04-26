package LinkedList;

public class Main {
    public static void main(String[] args) {
        RemoveDuplicatedFromSortedList list = new RemoveDuplicatedFromSortedList();
        RemoveDuplicatedFromSortedList list1 = new RemoveDuplicatedFromSortedList();
        RemoveDuplicatedFromSortedList list2 = new RemoveDuplicatedFromSortedList();
        RemoveDuplicatedFromSortedList list3 = new RemoveDuplicatedFromSortedList();
        list1.insertFirst(4);
        list1.insertFirst(2);
        list1.insertFirst(1);
        list1.Display();
        list2.insertFirst(4);
        list2.insertFirst(3);
        list2.insertFirst(1);
        list2.Display();
        list3.mergeLists(list1.head,list2.head);



        list3.Display();

    }
}
