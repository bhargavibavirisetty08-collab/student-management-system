public class peakElementInRotatedSortedArray {
     static int searchPivot(int[] arr)
    {
        int left=0;
        int right=arr.length-1;

        while(left<=right)
        {
          int  mid = (left+right)/2;
            if(mid < right && arr[mid] > arr[mid+1]  ){  //check if mid is peak
                return mid;
            }
            if(mid > left && arr[mid] < arr[mid-1]  ){
                return mid-1;
            }

           if (arr[mid]<=arr[left]) {
                right=mid-1;
            } else  {
                left=mid+1; // if mid is pivot then it will be catch  in case1,2.so we ignore it not in case1 so ignore mid
            }
        }
        return -1;
    }
//    static int  searchBS(int[] arr,int key,int left,int right) {
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (key == arr[mid]) {
//                return mid;
//            } else if (key > arr[mid]) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return -1;
//    }
//    int searchElement(int[] k,int target){
//        int find = searchPivot(k);
//        if(find ==-1){
//          return   searchBS(k,target,0,k.length-1);
//        }
//        if (k[find]==target)
//        {
//            return find;
//        }
//        if (target>=k[0]) {
//            return searchBS(k,target,0,find-1);
//        }else {
//            return searchBS(k,target,find+1,k.length-1);
//        }
//    }
    public static void main(String[] args) {
        int[] num ={2,2,2,3,4,2};
       peakElementInRotatedSortedArray p = new peakElementInRotatedSortedArray();
       int found = p.searchPivot(num);
        System.out.println(found);
    }
}
