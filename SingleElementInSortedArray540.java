public class SingleElementInSortedArray540 {
    private int FindSingleElement(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int mid = (start+end)/2;
            if(mid%2==1){
                mid--;
            }
            if ((arr[mid] == arr[mid+1])) {
               start=mid+2;
            }else{
                end = mid;
            }
        }
        return arr[end];
    }
    public static void main(String[] args) {
        SingleElementInSortedArray540 s = new SingleElementInSortedArray540();
        int[] nums = {2,2,3,3,4,4,6,7,7};
        System.out.println(s.FindSingleElement(nums));
    }
}
