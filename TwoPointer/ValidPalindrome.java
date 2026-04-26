package TwoPointer;

public class ValidPalindrome {
    private boolean checkPalindrome(String str){
        str=str.toLowerCase();
        str = str.replaceAll("[^a-z0-9]","");
        System.out.println(str);
        int start = 0;
        int end = str.length()-1;
        while(start<end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println( v.checkPalindrome("A man, a plan, a canal: Panama"));
    }
}