package Ex03;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ABCDEFGFEDCBA"));
        System.out.println(isPalindrome("ABCCA"));
    }

    public static boolean isPalindrome(String s){
        LinkedStack<String> stack = new LinkedStack<>();
        boolean palindrome = true;
        int i = 0;
        String[] strArr = s.split("");
        while(palindrome && i < s.length()){
            if(i < s.length()/2){
                stack.push(strArr[i]);
            } else{
                if(!stack.peek().equals(strArr[i])){
                    palindrome = false;
                } else {
                    stack.pop();
                }
            }
            i++;
            if(i == s.length() / 2 && s.length() % 2 != 0){
                i++;
            }
        }
        return palindrome;
    }
}
