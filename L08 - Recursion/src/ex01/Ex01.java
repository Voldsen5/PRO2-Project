package ex01;

import static java.lang.Math.multiplyExact;

public class Ex01 {
    public static void main(String[] args) {
        Ex01 e = new Ex01();

        String s = "gay";

        System.out.println(e.power(2,6));

        System.out.println(e.factorial(5));

        System.out.println(e.power2(2,6));

        System.out.println(e.prod(5,4));

        System.out.println(e.prodRus(2,4));

        System.out.println(reverse(s));

    }

    public int factorial(int n){
        int result = 0;
        if (n <= 1){
            result = 1;
        } else {
            result = n * factorial((n - 1));
        }
        return result;

    }

    public int power(int n, int p){
        int result;
        if (p <= 0){
            result = 1;
        }
        else {
            result = n * power(n,p-1);
        }
        return result;
    }

    public int power2(int n, int p){
        int result;
        if (p <= 0){
            result = 1;
        } else if (p % 2 != 0) {
            result = n * power2(n,p-1);
        } else {
            result = power2(n * n,p / 2);
        }
        return result;
    }

    public int prod(int a, int b){
        int result;
        if (a <= 0 || b <= 0){
            result = 0;
        } else if (a == 1) {
            result = b;
        } else {
            result = b + prod(a-1,b);
        }
        return result;
    }

    public int prodRus(int a, int b){
        int result;
        if (a <= 0){
            result = 0;
        } else if (a % 2 != 0) {
            result = b + prodRus(a-1,b);
        } else {
            result = prodRus(a / 2,2 * b);
        }
        return result;
    }

    public static String reverse(String s){
        if (s.isEmpty()){
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }
}
