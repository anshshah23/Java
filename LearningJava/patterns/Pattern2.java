package Patterns;
public class Pattern2 {
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 4 ; i++){
            for(int j = 4 ; j >i ; j--){
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }
}
