package LinkedList;

public class MiddleOfList {
    private Node head;
    private Node tail;
    public int size;

    public MiddleOfList(){

        this.size=0;
    }

    public Node MiddleNode(){
        Node temp = head;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public class Node{
        int val;
        Node next;
        private Node(int val){
            this.val=val;
            this.next=null;
        }
        private Node(int val, Node next){
            this.val=val;
            this.next=next;
        }

    }
}
