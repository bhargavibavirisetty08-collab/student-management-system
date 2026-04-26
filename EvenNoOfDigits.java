public class EvenNoOfDigits {
    static public int findNumbers(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int j=0;
            int value=nums[i];
            while(value!=0){
                value = value/10 ;
                j++;
            }
            if(j%2==0){
                count++;
            }
        }
        return count;
    }       //leetcode prblm 1295
    public static void main(String[] args) {
            int[] arr = {12,654,234,6543,8765,1,5,98,45};
           int evenDigits=findNumbers(arr);
        System.out.println("No of even digit Numbers : "+evenDigits);

        }
    }

