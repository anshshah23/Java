package Math;
import java.util.Arrays;
class assignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int num = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int i = 0;
        while( i < g.length && j < s.length){
            if(g[i] <= s[j]) {
                num++;
                i++;
            }
            j++;
        }
        return num;
    }
}