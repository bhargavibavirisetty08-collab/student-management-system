package BitManipulation;

public class CheckEvenOrOdd {
    public static void main(String[] args) {
        CheckEvenOrOdd c = new CheckEvenOrOdd();
        int n =27;
        if((n& 1) == 1){
            System.out.println("odd");
        }
        else{
            System.out.println("even");
        }
    }
}
