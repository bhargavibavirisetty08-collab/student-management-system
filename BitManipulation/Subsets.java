package BitManipulation;
import java.util.*;
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> finList=new ArrayList<>();
        int len=1 << nums.length;
        for(int i=0;i<len;i++){
            List<Integer> list1=new  ArrayList<>();
            int count=0;
            int temp=i;
             for(int j=0;j<nums.length;j++){
                 if((temp&1)==1){
                     list1.add(nums[j]);
                 }
                 temp=temp>>1;
             }
             finList.add(list1);
        }
        return finList;
    }
    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] arr ={1,2,3};
        System.out.println(s.subsets(arr));
    }
}
