package Strings;

class sortCharsByFreq {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for( int i = 0 ; i < s.length() ; i++ ) {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        ArrayList<Character> list = new ArrayList<>(hm.keySet());
        list.sort((a,b) -> hm.get(b)-hm.get(a));
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            int freq = hm.get(c);
            for(int i = 0 ; i < freq ; i++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        sortCharsByFreq sorter = new sortCharsByFreq();
        String result = sorter.frequencySort("tree");
        System.out.println(result); // Output: "eetr" or "eert"
    }
}