package StackAndQueues;

public class DynamicQueue extends QueueCustomize{
    DynamicQueue(){
       super();
    }
    DynamicQueue(int size){
        super(size);
    }
    public void enqueue(int key){
        if(isFull()){
            int[] temp = new int[queue.length * 2];

            for(int i = 0;i < queue.length;i++){
                temp[i] = queue[i];
            }
            queue = temp;
        }
        super.enqueue(key);
    }
}
