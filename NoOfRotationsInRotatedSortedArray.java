public class NoOfRotationsInRotatedSortedArray {
    private int NoOfRotation(int[] arr)
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

            if (arr[mid]<=arr[left]) {
                right=mid-1;
            } else  {
                left=mid+1; // if mid is pivot then it will be catch in case1,2.so we ignore it not in case1 so ignore mid
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        NoOfRotationsInRotatedSortedArray n = new NoOfRotationsInRotatedSortedArray();
        int[] num = {4,5,6,7,0,1,2};
        int rotations = n.NoOfRotation(num) +1;
        System.out.println("No of rotation are " + rotations);
    }
}
