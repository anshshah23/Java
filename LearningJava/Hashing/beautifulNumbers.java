class beautifulNumbers {
    public int nextBeautifulNumber(int n) {
        Boolean stat = false;
        int ans = 0;
        n++;
        while(!stat){
            stat = isBeautiful(n);
            if(stat) ans = n;
            n++;
        }
        return ans;
    }
    public Boolean isBeautiful(int a){
        int temp = a;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(temp > 0){
            int digit = temp%10;
            hm.put(digit,hm.getOrDefault(digit,0)+1);
            temp = temp/10;
        }
        for (int digit : hm.keySet()) {
            if (hm.get(digit) != digit) {
                return false;
            }
        }
        return true;
    }
}
