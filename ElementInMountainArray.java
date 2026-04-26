public class ElementInMountainArray {
    static public int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right = arr.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]<arr[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;//left or right
    }
    static int search4(int[] arr,int key,int left,int right)
    {
        while(left<=right){
            int mid = (left+right)/2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                left=mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
    static int search5(int[] arr ,int key,int left,int right)
    {
        while(left<=right){
            int mid = (left+right)/2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                right=mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int num[] ={1,2,3,5,7,6,3,2};
        int length=num.length-1;
       int ans = peakIndexInMountainArray(num);
        System.out.println(ans);
        int index1 = search4(num,3,0,ans);
        int index2 = search5(num,3,ans,length);
        if(index1 ==-1 && index2 == -1){
            System.out.println("3 is not found");
        }else if (index1!=-1 && index2!=-1) {
            System.out.println("3 is found at "+index1);
        } else if (index1==-1) {
            System.out.println("3 is found at "+index2);
        }else{
            System.out.println("3 is found at "+index1);
        }
    }
}
