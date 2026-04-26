public class PeakElementInRotatedSortedwithDuplicates {
  private int searchPivotWithDuplicates(int[] arr)
    {
        int left=0;
        int right=arr.length-1;

        while(left<=right)
        {
            int  mid = (left+right)/2;
            if(mid < right && arr[mid] > arr[mid+1]  ){
                return mid;
            }
            if(mid > left && arr[mid] < arr[mid-1]  ){
                return mid-1;
            }
            if(arr[left]==arr[mid] && arr[mid]==arr[right])
            {
                if (arr[left] <=arr[left +1]) {
                    left ++;
                }
                else{
                   return left;
                }
                if(right>right-1){
                    right--;
                }
                else{
                    return right-1;
                }
            } else if (arr[left]<arr[mid] || (arr[left]==arr[mid] && arr[right]>arr[mid])) {
                left=mid+1;
            } else  {
                right =mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        PeakElementInRotatedSortedwithDuplicates p = new PeakElementInRotatedSortedwithDuplicates();
        int[] number = {7,7,7,1,2,3,4,5,6};
       int found =  p.searchPivotWithDuplicates(number);
       if(found ==-1){
           System.out.println(found+1);
       }
       else {
          System.out.println(found);
 }
    }
}
