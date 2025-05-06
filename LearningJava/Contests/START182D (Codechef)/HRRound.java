import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class HRRound {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> num = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            num.add(i);
        }
        Collections.shuffle(num);
        for(int i: num){
            System.out.println(i);
        }
        sc.close();
    }
}
