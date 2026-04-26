package LinkedList;

public class SortList {
    private Node head;
    private Node tail;
    public int size;

    public SortList(){

        this.size=0;
    }






    public Node getMid(Node head){
        Node temp = head;
       Node slow = head;
      Node fast = head;
        while( fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }





    public void getTail(){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        tail = temp;
    }





        public Node merge(Node list1,Node list2){
        Node curr = new Node(-1);
        Node temp = curr;
        Node temp1 = list1 ;
        Node temp2 = list2;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;

            } else {
                temp.next = temp2;
                temp2 = temp2.next;
               temp = temp.next;
            }
        }
        if(temp1 == null){
            while(temp2 != null){
              temp.next = temp2;
            }
        }else{
            while(temp1 != null){
                temp.next = temp1;
            }
        }
        return curr.next;
    }





    public  Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);
        return merge(left, right);
    }





    public void BubbleSort(){
        int temp = 0;
        Node end = null;
        Node j = null;
       while(end != head ){
            for( j = head ; j.next != end ; j = j.next){
                if(j.val > j.next.val){
                    temp = j.val;
                    j.val = j.next.val;
                    j.next.val = temp;
                }
            }
            end = j;
        }
    }





    public void BubbleSortRec(Node row,Node col){
        if(row == head){
            return;
        }
        if(row == col.next){
           BubbleSortRec(col,head);
        }else {
            if(col.val > col.next.val){
              int  temp = col.val;
                col.val = col.next.val;
                col.next.val = temp;
            }
            BubbleSortRec(row,col.next);
        }
    }





    public Node get(int index){
        if (index < 0 || index >= size){
            return null;
        }
        Node temp = head;
        for (int i = 0;i < index;i++){
            temp = temp.next;
        }
        return temp;
    }






    public void BubbleSortRec(){
        //BubbleSortRec(null,head);
        BubbleSortRec(size-1,0);
    }






    public void BubbleSortRec(int row,int col){
        if(row == 0){
            return;
        }
        if(col < row){
            Node first = get(col);
            Node second = get(col+1);
            if(first.val > second.val){
                if(first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }
                else if(second == tail){
                    Node prev = get(col-1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                }
                else{
                    Node prev = get(col-1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            BubbleSortRec(row,col+1);
        }
        else{
            BubbleSortRec(row-1,0);
        }
    }




    public void reverse(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }




   public Node  reverseList(Node head){
        if(head == null || head.next  == null){
            return head;
        }
        Node temp = head;
        Node prev = null;
        Node Next = null;
        while(temp != null){
            Next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = Next;
        }
       head = prev;
        return head;
   }





    public Node getIndex(int index){  // index starts with 1
        if (index <= 0 || index >= size){
            return null;
        }
        Node temp = head;
        for (int i = 1;i < index;i++){
            temp = temp.next;
        }
        return temp;
    }






   public Node ReverseListInApart(Node head,int left,int right){
        if(left==right){
            return head;
        }
      Node temp = head ;
       Node prev = null;
      for(int i = 0 ; temp != null && i< left-1 ; i++)
      {
          prev = temp;
          temp = temp.next;
      }
      Node last = prev;
      Node newEnd = temp;
      Node Next = null;
      for(int i = 0; temp!=null && i < right-left+1 ;i++ ) {
          Next = temp.next;
          temp.next = prev;
          prev = temp;
          temp = Next;

      }
      if(last != null){
          last.next = prev;
      }else{
          head = prev;
      }
      newEnd.next = temp;
      // System.out.println(head.val);
      return head;
   }







   public boolean Palindrome()
   {
      Node middle = getMid(head);
      Node secondHead = reverseList(middle);

      Node reverseHead = secondHead;

     Node temp = head;
      while(temp != null && secondHead != null){
          if(temp.val != secondHead.val){
              break;
          }
         temp = temp.next;
          secondHead = secondHead.next;
      }
       reverseList(reverseHead);


      if(temp == null || secondHead == null){
          return true;
      }
      return  false;
   }




   public void ReOrder(){
        Node Mid = getMid(head);
        Node end = reverseList(Mid);
       // Display(end);
        Node start = head;
        Node temp = null;
        while(start != null && end != null){
            Node temp1 = start.next;
            Node temp2 = end.next;
            start.next = end;
            end.next = temp1;
            start = temp1;
            end = temp2;
        }
   }




   public Node reverseKNodes(int k){
        if(head == null || k==1){
            return head;
        }
        int count =1 ;
        Node temp = head ;
        int left = 1;

        while(true) {
            Node check = temp;
            for (int i = 1;check != null && i < k; i++) {
                check = check.next;
            }
           // System.out.println(count);
            if(check == null){
                break;
            }
                if(count%2 == 1) {
                    head = ReverseListInApart(head, left, left + k - 1);
                }
                count++;
                 left = left + k;
                 temp = head;
                for (int i = 1;temp != null && i < left; i++) {
                 temp = temp.next;
                }

        }
        return head;
   }




   public Node rotateList(int k){
        if( k == 0 || head == null || head.next == null ){
            return head;
        }
        if(k < 0){
            return null;
        }
        Node newHead , newHead1 = null;
        if(k >= size)
        {
            int rem = k%size;
             newHead =  ReverseListInApart(head,1,size);
            Display(newHead);
           newHead1 = ReverseListInApart(newHead,1,rem);
            Display(newHead1);
            ReverseListInApart(newHead1,rem+1,size);
            Display(newHead1);
        }else {
            newHead = ReverseListInApart(head, 1, size);
            Display(newHead);
            newHead1 = ReverseListInApart(newHead, 1, k);
            Display(newHead1);
            ReverseListInApart(newHead1, k + 1, size);
            Display(newHead1);
        }
      return newHead1;
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
    public void Display(Node head){
        if (head == null){
            return;
        }
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
      private Node (){
      }
        private Node(int val){
            this.val=val;
            this.next=null;
        }
        private Node(int val, Node next){
            this.val=val;
            this.next=next;
        }

    }

    public static void main(String[] args) {
        SortList list = new SortList();
//        list.insertFirst(9);
//        list.insertFirst(8);
//        list.insertFirst(7);
    //    list.insertFirst(6);
        list.insertFirst(5);
      list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
       // System.out.println(list.tail.val);
        //list.Display(list.head);
      // list.BubbleSort();
      // list.BubbleSortRec();
        //list.reverse(list.head);
        list.Display(list.head);
      //Node newHead =  list.reverseList(list.head);

        //list.ReverseListInApart(2,4);
       // System.out.println( list.Palindrome());
       // list.ReOrder();
        //Node head1 = list.reverseKNodes(2);
       // list.rotateList(2);
       // list.Display(head1);
        list.rotateList(6);



    }
}
