package Recursion.Strings;

public class NoOfPermutations {
    static int getno(String newper,String  str)
    {

        if(str.isEmpty()){
            return 1;
        }
        int count=0;
        //System.out.println(newper.length());
        char ch = str.charAt(0);
        for(int i=0;i<=newper.length();i++)
        {
            String first = newper.substring(0,i);
            String second = newper.substring(i,newper.length());
           count = count+ getno(first+ch+second,str.substring(1));

        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(getno("","abc"));
    }
}
