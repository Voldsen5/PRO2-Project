public class Ex04 {
    public static void main(String[] args) {
        String s = "RANSLIRPA";
        System.out.println(reverse(s));
    }

    public static String reverse(String s){
        if(s.isEmpty()){
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }
}
