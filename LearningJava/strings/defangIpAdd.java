package strings;
public class defangIpAdd {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
    public static void main(String[] args) {
        defangIpAdd solution = new defangIpAdd();
        String address = "142.13.44.51";
        String defangedAddress = solution.defangIPaddr(address);
        System.out.println(defangedAddress); // Output: 142[.]13[.]44[.]51
    }
}
