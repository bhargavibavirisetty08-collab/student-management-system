package Recursion.Array;

public class Pattern {
    static void triangle(int i ,int j){
        if(i==0){
            return;
        }
        if(j<i){
            triangle(i,j+1);
            System.out.print("* ");

        }
        else{
            triangle(i-1,0);
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        for(int i=0;i<4;i++){
//            for(int j=4-i;j>0;j--){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
        triangle(4,0);
    }
}
