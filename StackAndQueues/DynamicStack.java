package StackAndQueues;

public class DynamicStack extends StackCustomize{
   public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
       super(size);
    }
    public void push(int key){
        if(isFull()){
            int[] temp = new int[stack.length * 2];

            for(int i = 0;i < stack.length;i++){
                temp[i] = stack[i];
            }
            stack = temp;
        }
        super.push(key);
    }
}
