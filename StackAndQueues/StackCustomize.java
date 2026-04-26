package StackAndQueues;

public class StackCustomize {
    public static  final int MAX_SIZE = 5;
   public int[] stack;
    int size = -1 ;
   public StackCustomize(){

       this(MAX_SIZE);
    }
    public StackCustomize(int size){

       this.stack = new int[size];
    }
    public boolean isFull(){

       return size == stack.length-1;
    }
    public boolean isEmpty(){

       return size == -1;
    }
    public void push(int key){
        if(isFull()){
            System.out.println("Stack is full !!!");
        }
        else{
            size++;
            stack[size] = key;
        }
    }
    public void pop() throws StackException{
       if(isEmpty()){
          throw new StackException("Stack is empty cant be pop");
       }
       else{
           int removed = stack[size];
           System.out.println(removed);
           size--;
       }
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }

        for(int i = size; i >= 0; i--){
            System.out.println(stack[i]);
        }
    }
//    public void display() throws StackException{
//        if(isEmpty()){
//            throw new StackException("Stack is empty cant display");
//        }
//       else {
//           for(int i = size ; i >= 0 ; i--){
//               System.out.println(stack[i]);
//           }
//       }
//    }
    public void peek() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is empty cant get peek");
        }
        else{
            System.out.println(stack[size]);
        }
    }
    public static void main(String[] args) throws StackException{
       DynamicStack s = new DynamicStack();
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(9);
        s.push(1);
        System.out.println(s.stack.length);
//        s.peek();
//        s.pop();

        s.display();
    }
}
