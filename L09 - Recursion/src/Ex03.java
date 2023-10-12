import java.util.ArrayList;
import java.util.List;

public class Ex03 {
    public static void main(String[] args) {
        System.out.println(calcNo(45));

        System.out.println();
        System.out.println(calcNoIt(45));


    }


    //Requires: n >= 0
    public static int calcNo(int n){
        if(n == 0){
            return 2;
        } else if (n == 1) {
            return 1;
        } else if (n == 2){
            return 5;
        }
        return n % 2 == 0 ? 2*calcNo(n-3) - calcNo(n-1) : calcNo(n-1) + calcNo(n-2) + 3*calcNo(n-3);
    }

    public static int calcNoIt(int n){
        ArrayList<Integer> list = new ArrayList<>(List.of(2, 1, 5));
        int i = 3;
        int calc;
        while(i <= n){
            if(i % 2 == 0){
                calc = 2 * list.get(i-3)-list.get(i-1);
                list.add(calc);
            } else {
                calc = list.get(i-1) + list.get(i-2) + 3 * list.get(i-3);
                list.add(calc);
            }
            i++;
        }

        return list.get(n);
    }
}
