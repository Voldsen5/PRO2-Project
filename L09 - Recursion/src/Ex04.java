public class Ex04 {
    static int count = 0;
    public static void main(String[] args) {
        printAnagrams("","cat");
        System.out.printf("Antal combination: %d", count);
    }

    public static void printAnagrams(String prefix, String word){
        if(word.isEmpty()) {
            System.out.println(prefix);
            count++;
        }
        for (int i = 0; i < word.length(); i++)
        {
            String newPrefix = prefix + word.charAt(i);
            String newWord = word.substring(0,i) + word.substring(i + 1);
            printAnagrams(newPrefix, newWord);
        }

    }
}
