package LinkedList;

public class LL {
    private Node head;
    private Node tail;
   public int size;

    public LL(){

        this.size=0;
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

   public void InsertRec(int val,int index){

        head = InsertRec(val,index,head);
   }
    private Node InsertRec(int val,int index,Node node){
        if(index == 0){
            Node newNode = new Node(val,node);
            size++;
            return newNode;
        }
        node.next = InsertRec(val,index-1,node.next);
        return node;
    }

    public void delAtPosition(int index){
        if( head == null){
            return;
        }


        if(index == 0){
            delAtFirst();
            return;
        }

        if(index == size - 1){
            delAtLast();
            return;
        }

        if(size <= index || index <0){
            System.out.println("Invalid index");
            return;
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
//        Node nextNode = temp.next;
        temp.next=temp.next.next;
        size--;
    }
    public void delAtLast(){
        if(head == null){
            return;
        }
        if(head==tail){
            head=null;
            tail=null;
            size--;
            return;
        }
        Node temp = head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;

        size--;
    }
    public void delAtFirst(){

        if(head == null){
            return;
        }
        head = head.next;
        size -- ;
        if(head == null){
            tail=null;
            return;
        }

    }
    public void insertAtPosition (int val,int index){

        if(index < 0 || index > size){
            System.out.println("invalid index");
            return;
        }

        if(index==0){
            insertFirst(val);
            return;
        }

        if(index==size){
            insertLast(val);
            return;
        }

        int count=0;
        Node node = new Node(val);
        Node temp = head;

        for(int i=1 ; i<index ; i++){  // temp  points where we want to insert at index before node
            temp=temp.next;
        }
       node.next = temp.next;
        temp.next=node;

        size+=1;

    }
    public void insertLast(int val){
        Node node = new Node(val);
        if(head == null)
        {
            head = node;
            tail = node;
            return;
        }
//        Node temp = head;
//        while(temp.next!=null){
//            temp=temp.next;
//        }
//        temp.next=node;
//        tail=node;

        tail.next=node;
        tail=node;

        size+=1;
    }
    public void insertFirst(int val)
    {
        Node node = new Node(val);
        node.next=head;
        head=node;
        if(tail == null)
        {
            tail=head;
        }

        size+=1;
    }
    public void Display(){
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.println("Null");
    }
    public class Node{
        int val;
        Node next;
        private Node(int val){
            this.val=val;
            this.next=null;
        }
        private Node(int val,Node next){
            this.val=val;
            this.next=next;
        }

    }

}
