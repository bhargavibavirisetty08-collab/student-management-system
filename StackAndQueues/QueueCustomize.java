package StackAndQueues;

public class QueueCustomize {
    int front = -1;
    int rear = -1;
    int[] queue;
    public static final int MAX_SIZE_Q = 5;

    public QueueCustomize(){
        this(MAX_SIZE_Q);
    }

   public QueueCustomize(int size){
        queue = new int[size];
    }

    public boolean isFull(){
        if(rear == queue.length-1){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if (front == -1 && rear == -1){
            return true;
        }
        return false;
    }

    public void enqueue(int key){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(isEmpty()){
            front++;
            rear++;
            queue[rear] = key;
        }
        else {
            rear++;
            queue[rear] = key;
        }
    }

    public void dequeue() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is Empty cant be removed");
        }
        if(front == rear){
            front = rear = -1;
        }
        int removed = queue[front];
        System.out.println("Removed element : " + removed);
        front++;
    }

    public void peek() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is full");
        }
        System.out.println(queue[front]);
    }

    public void display() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is Empty");
        }
        for(int i = front;i <= rear;i++){
            System.out.println(" Elements are " + queue[i]);
        }
    }


    public static void main(String[] args) throws QueueException {
        QueueCustomize q = new QueueCustomize();
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        q.dequeue();
        q.peek();
        q.display();
    }
}
