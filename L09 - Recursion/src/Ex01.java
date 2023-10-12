public class Ex01 {
    public static void main(String[] args) {
        System.out.println(binomial(7,5));
    }

    public static int binomial(int n, int m){
        if(n == m || m == 0){
            return 1;
        }
        return binomial(n-1,m) + binomial(n-1,m-1);
    }
}
