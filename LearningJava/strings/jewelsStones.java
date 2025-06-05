class jewelsStones {
    public int numJewelsInStones(String jewels, String stones) {
        int s = stones.length();
        int j = jewels.length();
        int cnt=0;
        for(int i = 0 ; i < s ; i++ ){
            for(int z = 0; z<j ; z++){
                if(stones.charAt(i)==jewels.charAt(z)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        jewelsStones solution = new jewelsStones();
        String jewels = "aA";
        String stones = "aAAbbbb";
        int count = solution.numJewelsInStones(jewels, stones);
        System.out.println(count); // Output: 3
    }
}