package Math;

public class difOfSums {
    public int differenceOfSums(int n, int m) {
        int x=0,y=0;
        for(int i=0;i<=n;i++){
            if(i%m==0) x+=i;
            else y+=i;
        }
        return y-x;
    }
    public static void main(String[] args) {
        difOfSums sol = new difOfSums();
        System.out.println(sol.differenceOfSums(10, 2)); // Example usage
    }
}