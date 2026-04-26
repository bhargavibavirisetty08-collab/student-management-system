package StackAndQueues;

public class DynamicQueueForCircular extends CircularQueue{
    DynamicQueueForCircular(){
        super();
    }
    DynamicQueueForCircular(int size){
        super(size);
    }
    public void enqueue(int key){
        if(isFull()){
            int[] temp = new int[queue.length * 2];
            for(int i = 0;i < queue.length;i++){
                temp[i] = queue[(front + i )% queue.length];
            }
            front = 0;
            rear = queue.length;
            queue = temp;
        }
        super.enqueue(key);
    }
}
