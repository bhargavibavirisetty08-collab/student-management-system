package BitManipulation;

public class elementOcuuredthrice {
    private int getElement(int[] arr){

        int result=0;
        for(int bit =0;bit<32;bit++){
            int count=0;
            for(int i : arr){
                if((i>>bit&1)==1){
                    count++;
                }
            }
            if(count%3!=0){
                result=result|(1<<bit);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        elementOcuuredthrice e = new elementOcuuredthrice();
        int[] nums = {2,3,4,5,2,4,5,2,5,4,3,3,9};
        System.out.println(e.getElement(nums));
    }
}
