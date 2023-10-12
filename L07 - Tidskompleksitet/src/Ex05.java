import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex05 {
    public static void main(String[] args) {
        char[] chars = {'W', 'R', 'G', 'W', 'W', 'R', 'G', 'R','W', 'W', 'R', 'G', 'W'};
        order(chars);
        System.out.println(Arrays.toString(chars));
    }

    public static void order(char[] letters){
        int ws = 0;
        int rs = 0;
        int gs = 0;

        for (char letter : letters) {
            if (letter == 'W') {
                ws++;
            } else if (letter == 'R') {
                rs++;
            } else {
                gs++;
            }
        }
        int counter = 0;
        int highest = IntStream.of(ws, rs, gs).max().getAsInt();
        System.out.println(highest);
        for (int i = 0; i < highest; i++, counter++) {
            if(counter < gs){
                letters[i] = 'G';
            }
            if(counter < ws){
                letters[i+gs] = 'W';
            }
            if(counter < rs){
                letters[i+gs+ws] = 'R';
            }
        }
    }
}
