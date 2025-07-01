package Recursion;
public class printNtoOne {
    public static void main(String[] args) {
        int index = 5;
        int i = 5;
        printer(index,i);
    }
    public static void printer(int index, int i){
        if(index<1){
            return;
        }
        System.out.println(i--);
        index--;
        printer(index,i);
    }
}
