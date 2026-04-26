package Recursion;

public class Palindrome {
    private boolean Ispalindrome(String num)
    {
       for(int i=0;i<num.length()/2;i++){
           if(num.charAt(i)!=num.charAt(num.length()-1-i)){
               return false;
           }

       }
       return true;
    }
    public static void main(String[] args) {
        Palindrome p= new Palindrome();
       String n="121";
        System.out.println(p.Ispalindrome(n));
    }
}
