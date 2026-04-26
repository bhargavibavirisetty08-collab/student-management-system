package BitManipulation;

public class FindSingleOccuredElement {
    public static void main(String[] args) {
        int[] arr ={2,3,4,2,5,5,6,3,4};
       int Single=0;
        for(int i : arr){
            Single= Single^i;
        }
        System.out.println(Single);
    }
}
