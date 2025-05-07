// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class printName {
    public static void main(String[] args) {
        int index = 5;
        printer(index);
    }
    public static void printer(int index){
        if(index<1){
            return;
        }
        System.out.println("Name");
        index--;
        printer(index);
    }
}