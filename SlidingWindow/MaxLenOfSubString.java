package SlidingWindow;

import java.util.HashSet;

public class MaxLenOfSubString {
   private int getLength(String str){
       HashSet<Character> set = new HashSet<>();
       int curSize=0;int maxSize=0;int left=0;
       for(int right=0;right<str.length();right++){
           while(set.contains(str.charAt(right))){
                   set.remove(str.charAt(left));
                   left++;
           }
           set.add(str.charAt(right));
           curSize= set.size();
           maxSize = Math.max(curSize,maxSize);
       }
       return maxSize;
   }
    public static void main(String[] args) {
        String s= "abcabcbb";
        MaxLenOfSubString m = new MaxLenOfSubString();
        System.out.println(m.getLength(s));
    }
}
