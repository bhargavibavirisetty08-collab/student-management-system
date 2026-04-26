package StackAndQueues;

public class CircularQueue {
    int front = -1;
    int rear = -1;
    int[] queue;
    public static final int MAX_SIZE_Q = 5;

    public CircularQueue(){
        this(MAX_SIZE_Q);
    }

    public CircularQueue(int size){
        queue = new int[size];
    }

    public boolean isFull(){
        return (rear+1)%queue.length == front;
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
            front = (front+1)%queue.length;
            rear = (rear+1)%queue.length;
            queue[rear] = key;
        }
        else {
            rear = (rear+1)%queue.length;
            queue[rear] = key;
        }
    }

    public void dequeue() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is Empty cant be removed");
        }
        int removed = queue[front];
        System.out.println("Removed element : " + removed);
        if(front == rear){
            front = rear = -1;
        }
        else {
            front = (front + 1) % queue.length;
        }
    }

    public void peek() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is Empty");
        }
        System.out.println(queue[front]);
    }

    public void display() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is Empty");
        }
        int i = front;
        while (true) {
            System.out.println(queue[i]);
            if(i == rear){
                break;
            }
            i = (i+1)% queue.length;
        }
    }


    public static void main(String[] args) throws QueueException {
        CircularQueue q = new CircularQueue();
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        q.dequeue();
        q.peek();
        q.display();
    }
}
