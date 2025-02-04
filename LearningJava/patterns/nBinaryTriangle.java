/*
1
0 1
1 0 1
*/

public class nBinaryTriangle {
    public static void printPattern(int n) {
        for(int i = 1; i <=n ; i++){
            for(int j=0; j <i ; j++){
                if(i%2==1 && j%2==0){
                    System.out.print("1 ");
                }
                else if(i%2==0 && j%2==0){
                    System.out.print("0 ");
                }
                else if(i%2==1 && j%2==1){
                    System.out.print("0 ");
                }
                else
                    System.out.print("1 ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        printPattern(7);
    }
}