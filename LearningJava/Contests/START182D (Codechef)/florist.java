import java.util.*;

class Codechef {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int D = sc.nextInt();

            int[] T_arr = new int[N];
            for (int i = 0; i < N; i++) {
                T_arr[i] = sc.nextInt();
            }

            int tcd = D * (N - K);
            if (tcd == 0) {
                System.out.println(0);
                continue;
            }

            Arrays.sort(T_arr);

            int total = 0;
            int ucd = 0;

            for (int i = 0; i < N; i++) {
                int t = T_arr[i];
                int plucks = 1 + (D - 1) / (t + 1);
                int cdd = plucks * t;

                if (ucd + cdd <= tcd) {
                    total += plucks;
                    ucd += cdd;
                } else {
                    int remCd = tcd - ucd;
                    int maxPp = (remCd + t - 1) / t;
                    total += maxPp;
                    break;
                    }
                }
            }

            System.out.println(total);
        }
    }
}
