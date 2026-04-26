package Recursion;

public class CountZeros {
    private int getZeros(int n){
        return helper(n,0);
    }
    private int helper(int n,int count){
        if(n==0){
            return count;
        }
        if(n%10==0){
            count++;
        }
       return helper(n/10,count);
    }
    public static void main(String[] args) {
        CountZeros c = new CountZeros();
        System.out.println(c.getZeros(908));
    }
}
