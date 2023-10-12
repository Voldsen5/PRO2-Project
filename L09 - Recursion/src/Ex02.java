public class Ex02 {
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        return isPalindrome(s, 0);
    }
    public static boolean isPalindrome(String s, int n){
        if(s.length() == 1 || n >= s.length() - n - 1){
            return true;
        }
        if(s.charAt(n) == s.charAt(s.length()-n-1)){
            return isPalindrome(s,n+1);
        }
        return false;
    }
}
