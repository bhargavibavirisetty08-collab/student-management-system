package BitManipulation;

public class rangeOfXor {
    public static void main(String[] args) {
        int range = 2;
        if(range%4==0){
            System.out.println(range);
        } else if (range%4==1) {
            System.out.println(1);
        } else if (range%4==2) {
            System.out.println(range+1);
        }else {
            System.out.println(0);
        }
    }
}
