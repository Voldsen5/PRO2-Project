package Ex03_Strategy;


import java.util.Arrays;

public class EmailEvaluator implements Evaluator {
    /** Returns true, if s contains a valid email address. */
    @Override
    public boolean isValid(String s) {
        if(s.contains("@")){
            String[] email = s.split("@",-1);
            if(email.length < 2){
                return false;
            }
            String[] left = email[0].split("\\.",-1);
            String[] right = email[1].split("\\.",-1);
            boolean word = true;
            int i = 0;
            while(word){
                if(i < left.length){
                    if(!isWord(left[i])){
                        word = false;
                    }
                }
                if(i < right.length){
                    if(!isWord(right[i])){
                        word = false;
                    }
                }
                if(i > left.length && i > right.length){
                    return true;
                }
                i++;
            }
            return false;
        }
        return false;
    }

    /**
     * Returns true, if s is an acceptable word.
     * That is, s is not empty, and all letters
     * are in 'A'..'Z', 'a'..'z' or '0'..'9'.
     */
    public boolean isWord(String s) {
        if(!s.isEmpty()){
            char[] word = s.toCharArray();
            boolean validChars;
            for (char c : word) {
                validChars = ((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z')) || ((c >= '0') && (c <= '9'));
                if(!validChars){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
