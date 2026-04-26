import java.util.Scanner;

public class SearchInString {
    static int search(String word,char letter){
        for(int i =0;i<word.length();i++){
            if(word.charAt(i)==letter){
                return i;
            }
        }
        return -1;
    }
//static int search(String word,char letter){
//    for (char ch : word.toCharArray())
//    {
//        if (ch==letter){   //by using for each and checking wth letter not a index
//            return ch;
//        }
//    }
//    return -1;
//}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Name : ");
        String name = sc.nextLine();
        System.out.println("Enter the letter to search : ");
        char c = sc.nextLine().charAt(0);
        int find= search(name,c);
        if(find != -1) {
            System.out.println(c + " is found at " + find);
        }else{
            System.out.println(c + " doesn't found!!! please enter existing numbers ");
        }
    }
}
