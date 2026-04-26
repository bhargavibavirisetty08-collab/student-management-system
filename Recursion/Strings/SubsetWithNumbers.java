package Recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithNumbers {
    static List<List<Integer>> getSubset(int[] arr){
        List<List<Integer>> listOut = new ArrayList<>();
        listOut.add(new ArrayList<>());
        for(int i : arr){
            int size= listOut.size();
            for(int j=0;j<size;j++){
                List<Integer>listIn = new ArrayList<>(listOut.get(j));
                listIn.add(i);

                    listOut.add(listIn);

            }
        }
        return listOut;
    }
    public static void main(String[] args) {
        int[] nums ={2,1,2};
        System.out.println(getSubset(nums));
    }
}
