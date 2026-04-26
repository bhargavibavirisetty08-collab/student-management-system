package LinkedList;

public class HappyNo {
    public  int square(int num){
        int rem = 0,sum = 0;
        while(num != 0){
            rem = num % 10;
            sum = sum + (rem*rem);
            num = num/10;
        }
         return sum;
    }
    public boolean IsHappy(int n){
        int slow = n;
        int fast = n;
        do{
            slow = square(slow);
            fast = square(square(fast));
        }while (slow != fast);

        if (slow == 1){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        HappyNo h = new HappyNo();
        System.out.println(h.IsHappy(4));
    }
}
