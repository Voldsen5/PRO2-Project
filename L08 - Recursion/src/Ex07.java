public class Ex07 {
    public static void main(String[] args) {
        System.out.println(tiles(8));
    }

    public static int tiles(int n){
        return n >= 3 ? tiles(n-1)+tiles(n-2) : n;
    }
//    public static int tiles(int n){
//        if(n >= 3){
//            return tiles(n-1)+tiles(n-2);
//        }
//        return n;
//    }
}
