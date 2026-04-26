package LinkedList;

public class DoubleLL {
    private Node head;
    private Node tail;
    public int size;

    public DoubleLL(){
        this.size=0;
    }

    public void DelAtEnd(){
        if(head ==  null){
            return;
        }
        if(tail==head){
            tail=head=null;
            return;
        }
        tail=tail.prev;
        tail.next=null;
        size--;
    }
    public void DelAtFirst(){
        if(head==null){
            return;
        }
        if(head==tail)
        {
            head=tail=null;
        }
        head=head.next;
        head.prev=null;
        size--;
    }
    public void DelAtPosition(int index){
        if(head==null){
            return;
        }
        if(index < 0 || index > size-1){
            System.out.println(" Invalid index ");
            return;
        }
        if(index==0){
            DelAtFirst();
            return;
        }
        if(index == size-1){
            DelAtEnd();
            return;
        }

        Node temp = head;
        for(int i=1;i < index;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;

        size--;

    }
    public void insertAtPosition(int val,int index){
        if(head==null){
            insertAtFirst(val);
            return;
        }
        if(size < index || index < 0){
            System.out.println("Invalid index");
            return;
        }
        if(index==0){
            insertAtFirst(val);
            return;
        }
        if(index==size){
            insertAtLast(val);
            return;
        }

        Node node =new Node(val);
        Node temp=head;
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        node.next=temp.next;
        node.prev=temp;
        temp.next.prev=node;
        temp.next=node;
        size+=1;

    }
    public void insertAtLast(int val){
        Node node = new Node(val);
        if(head==null){
            head=tail=node;
            return;
        }
        tail.next=node;
        node.prev= tail;
        tail=node;

        size+=1;
    }
    public void insertAtFirst(int val){
       Node node = new Node(val);
       if(head ==null){
           tail=head=node;
       }else {
           node.next = head;
          node.prev = node;
           head = node;
           size += 1;
       }
    }

    public void display(){
        if(head == null){
            return ;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp= temp.next;
        }
        System.out.println(" Null ");
    }

  public class Node{
        public int val;
        Node prev;
        Node next;
        private Node(int val){
            this.val=val;
            this.next=null;
            this.prev=null;
        }
    }

}
