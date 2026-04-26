package StackAndQueues;

import java.util.Arrays;



public class GameOfTwoStacks {
    public static  final int MAX_SIZE = 20;
    public int[] stack1;
    public int[] stack2;
    int top = -1 ;
    int top1 = -1;
    public GameOfTwoStacks(){

        this(MAX_SIZE);
    }
    public GameOfTwoStacks(int size){

        this.stack1 = new int[size];
        this.stack2 = new int[size];
    }
    public boolean isFull(){

        return top == stack1.length-1;
    }
    public boolean isEmpty(){

        return top == -1;
    }
    public void push(int key){
        if(isFull()){
            System.out.println("Stack is full !!!");
        }
        else{
            top++;
            stack1[top] = key;
        }
    }

    public void push1(int key){
        if(isFull()){
            System.out.println("Stack is full !!!");
        }
        else{
            top1++;
            stack2[top1] = key;
        }
    }

    public void pop1() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is empty cant be pop");
        }
        else{
            int removed = stack2[top1];
            System.out.println(removed);
            top1--;
        }
    }

    public boolean isFull1(){

        return top1 == stack1.length-1;
    }

    public boolean isEmpty1(){

        return top1 == -1;
    }

    public void pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is empty cant be pop");
        }
        else{
            int removed = stack1[top];
            System.out.println(removed);
            top--;
        }
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }

        for(int i = top; i >= 0; i--){
            System.out.println(stack1[i]);
        }
    }
   public int getSum(){
      return getMaxCombination(top,top1,0,0,10) - 1 ;
   }
    public int getMaxCombination(int t1,int t2,int sum,int count,int MaxSum){
        if(sum > MaxSum || t1 == -1 || t2 == -1){
            return count;
        }
//        int ans1 = getMaxCombination(Arrays.copyOfRange(s1,0,s1 .length -1), s2 ,sum + stack1[s1.length - 1],count+1 , MaxSum);
//        int ans2 =  getMaxCombination( s1 ,Arrays.copyOfRange(s2,0 , s2 .length -1 ) ,sum + stack2[s2.length - 1], count+1 , MaxSum);
        int ans1 = getMaxCombination(t1 - 1, t2 ,sum + stack1[t1],count+1 , MaxSum);
        int ans2 =  getMaxCombination( t1 , t2 - 1 ,sum + stack2[t2], count+1 , MaxSum);
        return Math.max(ans1,ans2);
    }
    public static void main(String[] args) {
        GameOfTwoStacks s = new GameOfTwoStacks();
        s.push(1);
        s.push(6);
        s.push(4);
        s.push(2);
        s.push(4);
        s.push1(5);
        s.push1(8);
        s.push1(1);
        s.push1(2);
        System.out.println(s.getSum());

    }
}
