package Recursion.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetwithNumberDuplicates {
    static List<List<Integer>> getsubsett(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> listOut = new ArrayList<>();
        listOut.add(new ArrayList<>());
        int start=0;int end=0;
        for(int i=0;i<arr.length;i++){
            start=0;
            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }
            end = listOut.size()-1;
            int size= listOut.size();
            for(int j=start;j<size;j++){
                List<Integer>listIn = new ArrayList<>(listOut.get(j));
                listIn.add(arr[i]);
                listOut.add(listIn);
            }
        }
        return listOut;
    }
    public static void main(String[] args) {
        int[] nums={1,2,2};
        System.out.println(getsubsett(nums));
    }
}
