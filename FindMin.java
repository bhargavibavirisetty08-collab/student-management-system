public class FindMin {
    int min;
    int MinNumber(int[] arr,int min){
        this.min=min;
        for(int i =0;i< arr.length;i++){
            if(this.min > arr[i]){
                this.min=arr[i];
            }
        }
        return this.min;
    }
    public static void main(String[] args) {
        FindMin fm = new FindMin();
        int[] arr = {43,47,84,32,51,10,91,41,12,8,54};
        int min=arr[0];
        int minnum = fm.MinNumber(arr,min);
        System.out.println("The minimum is :  "+minnum);
    }
}
