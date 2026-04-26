package LinkedList;

public class RemoveDuplicatedFromSortedList {
    Node head;
    Node tail;
    int size;
    public RemoveDuplicatedFromSortedList(){
        this.size=0;
    }
    public void RemoveDuplicate(){
        Node temp = head;
        while( temp.next != null){
            if(temp.val == temp.next.val ){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
    }

    public void mergeLists(Node list1,Node list2){
     Node newList = new Node(-1);
     Node temp = newList;
     while(list1 != null || list2!=null){

         if(list1.val <= list2.val ){
             temp.next = list1;
             list1 = list1.next;
         }
           else{
               temp.next = list2;
               list2 = list2.next;
         }
           temp = temp.next;
     }
     if(list1 == null){
         temp.next = list2;
     } else if (list2 == null) {
          temp.next = list1;
     }


//        Node temp1 = list1;
//        Node temp2 = list2;
//        Node curr = null;
//        while(temp1.next!=null || temp2.next!=null){
//            curr = temp2.next;
//            temp2.next = temp1.next;
//            temp1.next = temp2;
//            temp2  = curr;
//            temp1 = temp1.next.next;
//        }
//        if(temp1.next == null){
//            temp1.next = curr;
//        }
//        else{
//            temp2.next = temp1;
//        }
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
        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }
}
