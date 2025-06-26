class stringMatchHashing {
    public boolean wordPattern(String pattern, String s) {
        
        char[] ch = pattern.toCharArray();
        String[] str = s.split(" ");

        if (ch.length != str.length)
            return false;

        Map<Character, String> map = new HashMap<>();

        for (int i=0; i<str.length; i++) {

            if (map.containsKey(ch[i])) {
                if (!(map.get(ch[i]).equals(str[i]))) {
                    return false;
                }
            }
            else if (map.containsValue(str[i])) {
                return false;
            }
            map.put(ch[i], str[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        stringMatchHashing smh = new stringMatchHashing();
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(smh.wordPattern(pattern, s)); // Output: true

        pattern = "abba";
        s = "dog cat cat fish";
        System.out.println(smh.wordPattern(pattern, s)); // Output: false
    }
}