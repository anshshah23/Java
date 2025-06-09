package BitManipulation;

public class binToDec {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1};
        int num = 0;
        for(int i = arr.length-1 ; i >= 0; i--) {
            num += arr[i] * (Math.pow(2, (arr.length-1-i)));
        }
        System.out.println(num);
    }
}
