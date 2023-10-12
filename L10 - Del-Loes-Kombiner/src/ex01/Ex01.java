package ex01;

import java.util.ArrayList;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<Integer> tal = new ArrayList<Integer>();

        tal.add(1);
        tal.add(2);
        tal.add(3);
        tal.add(4);
        tal.add(5);
        tal.add(6);
        tal.add(7);
        tal.add(8);

        System.out.println(sum(tal));

    }

    public static int sum(ArrayList<Integer> list) {
        return Sum(list, 0, list.size() - 1);
    }

    private static int Sum(ArrayList<Integer> list, int l, int h) {
        if (l == h) {
            return list.get(l);
        }
        else {
            int m = (l + h)/2;
            int l1 = Sum(list,l,m);
            int l2 = Sum(list,m+1,h);
            return l1 + l2;
        }
    }
}


