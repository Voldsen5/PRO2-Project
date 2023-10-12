public class Ex06 {
    public static void main(String[] args) {
        System.out.println(gcd(468, 24));
    }

    public static int gcd(int a, int b){
        if(a >= 2 && b >= 2){
            if(b <= a && a%b == 0){
                return b;
            } else if (a < b) {
                return gcd(b,a);
            }
            return gcd(b,a % b);
        }
        return 0;
    }
}
