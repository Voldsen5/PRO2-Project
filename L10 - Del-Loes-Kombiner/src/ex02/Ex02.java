package ex02;

import java.util.ArrayList;

public class Ex02 {
    public static void main(String[] args) {
        ArrayList<Integer> tal = new ArrayList<>();

        tal.add(1);
        tal.add(0);
        tal.add(1);
        tal.add(2);
        tal.add(0);
        tal.add(0);
        tal.add(1);
        tal.add(0);

        System.out.println(Sum(tal,0, tal.size()) - 1);
    }

    private static int Sum(ArrayList<Integer> list, int l, int h) {
        int count = 0;
        if (l == h) {
            return 0;
        }
        else {
            int m = (l + h)/2;
            int l1 = Sum(list,l,m);
            int l2 = Sum(list,m+1,h);
            if (l1 == 0) count++;
            if (l2 == 0) count++;

            return count;
        }
    }
}
