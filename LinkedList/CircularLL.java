package LinkedList;

public class CircularLL {
    private Node head;
    private Node tail;
    int size = 0;

    public CircularLL(){
        this.size = 0;
    }

    public int  CycleDetectionWithLength(){
        Node temp = head;
        Node slow = temp;
        Node fast = temp;
        int count = 0 ;
        if(head == null){
            return count;
        }
//        do{
//            slow =  slow.next;
//            fast = fast.next.next;
//        }while(slow != fast);
//
//        if(slow == fast){
//            slow = slow.next;
//            count =1;
//            while(slow != fast){
//                slow = slow.next;
//                count++;
//            }
//        }


        while(fast != null && fast.next != null){
            slow =  slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                do{
                    slow = slow.next;
                    count++;
                }while (slow!=fast);
                return count;
            }
        }
        return count;
    }

    public boolean CycleDetection(){
       Node temp = head;
       Node slow = temp;
      Node fast = temp;
        if(head == null){
            return false;
        }
        while(fast != null && fast.next != null){
            slow =  slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
     public Node CycleDetectionWithPosition(){
         Node temp = head;
         Node slow = temp;
         Node fast = temp;
         if(head == null){
             return null;
         }
         while(fast != null && fast.next != null){
             slow =  slow.next;
             fast = fast.next.next;
             if(slow == fast){
                fast = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
             }
         }
         return null;
     }

    public void DelAtPosition(int index)
    {
        if(index < 0 || index >= size){
            System.out.println("Invalid Index");
            return;
        }
        if(index == 0){
            DelAtFirst();
            return;
        }
        if(index == size-1 ){
            DelAtEnd();
            return;
        }
        Node temp = head;
        for(int i = 1;i < index; i++){
            temp =  temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }



    public void DelAtEnd(){
        if(head==null){
            System.out.println(" No Node is found !!!");
            return;
        }
        if (head == tail) {
            head = tail =null;
            size--;
            return;
        }
        Node temp = head;
        while(temp.next!=tail){
            temp = temp.next;
        }
        tail = temp;
        tail.next = head;

        size--;
    }
    public void DelAtFirst(){
        if(head==null){
            System.out.println(" No Node is found !!!");
            return;
        }
        if (head == tail) {
            head = tail =null;
            size--;
            return;
        }
        head = head.next;
        tail.next = head ;
        size--;
    }
    public void InsertAtPosition(int val,int index){
        if(index < 0 || index > size){
            System.out.println("Invalid Index");
            return;
        }
        if(index == 0){
            InsertAtFirst(val);
            return;
        }
        if(index == size ){
            InsertAtEnd(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;
        for(int i = 1;i < index; i++)
        {
            temp =  temp.next;
        }
        node.next = temp.next;
        temp.next = node;

        size++;
    }
    public void InsertAtEnd(int val){
        if(head == null){
            InsertAtFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        tail.next = head;

        size++;
    }
    public void InsertAtFirst(int val){
        Node node = new Node(val);
        if(head == null){
            head = tail = node;
            tail.next = head;
        }else {
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
    }
    public void display(){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp.next != head ){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.val + " -> ");
        System.out.println(" Head ");
    }
    public class Node{
        public int val;
        Node next;

        private Node(int val){
            this.val = val;
            this.next = null;
        }

    }
}
