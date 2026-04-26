import java.util.Scanner;

public class SearchWithInRange {
        static int search(int[] num,int index,int Start,int End){
            if(num.length==0){
                return -1;
            }
            for(int i=Start;i<=End;i++){
                if(num[i]==index){
                    return i;
                }
            }
            return Integer.MIN_VALUE;  // if -1 is also a number,we return max/min value
        }
        public static void main(String[] args) {
            int[] arr={3,4,5,6,7,1,98,54,92};
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number to be search :");
            int value = sc.nextInt();
            System.out.println(" enter the starting index : ");
            int indexStart = sc.nextInt();
            System.out.println(" enter the ending index : ");
            int indexEnd = sc.nextInt();
            int find=search(arr,value,indexStart,indexEnd);
            if(find != -1) {
                System.out.println(value + " is found at " + find);
            }else{
                System.out.println(value + " doesn't found!!! please enter existing numbers ");
            }
        }
    }


