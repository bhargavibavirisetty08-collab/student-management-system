import java.util.Scanner;
public class LinearSearch {
    static int search8(int[] num,int index){
        if(num.length==0){
            return -1;
        }
        for(int i=0;i<num.length;i++){
            if(num[i]==index){
                return i;
            }
        }
        return Integer.MIN_VALUE;  // if -1 is also a number,we return max/min value
    }
    public static void main(String[] args) {
        int[] arr={3,4,5,6,7,1,98,54,92};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to be searchhh");
        int value = sc.nextInt();
        int find=search8(arr,value);
        if(find != -1) {
            System.out.println(value + " is found at " + find);
        }else{
            System.out.println(value + " doesn't found!!! please enter existing numbers ");
        }
    }
}
