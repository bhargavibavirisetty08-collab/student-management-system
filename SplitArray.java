public class SplitArray {
    private int getSplitArray(int[] arr,int m){
        int sum = 0;
        int max = arr[0];
        for (int i : arr){
            if(max < i){
                max = i;
            }
            sum = sum+i;
        }
        int start = max;
        int end = sum;
        //System.out.println(start + " "+end);
        while(start<end){
            int mid = (start+end)/2;
            int SumArray = 0;
            int pieces=1;
            for( int num : arr){
                if (SumArray +num   >  mid){
                    SumArray = num;
                    pieces++;

                }
                else{
                    SumArray +=num;

                }
            }
            if(pieces > m  ){
                start=mid+1;
            }
            else{
                end = mid;
            }
        }
        return end;
    }
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        SplitArray s = new SplitArray();
        int Minans = s.getSplitArray(nums,2);
        System.out.println(Minans);
    }
}
