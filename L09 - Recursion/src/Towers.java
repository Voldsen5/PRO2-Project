public class Towers {
    private static int count = 0;

    public static void main(String args[])
    {
        int n = 5;
        System.out.printf("Antal flytninger: %d\n", towerOfHanoi(n,1,3));
    }

    static int towerOfHanoi(int n, int fra, int til)
    {
        if (n == 1)
        {
            //System.out.println("Flyt fra " + fra + " til " + til);
            count++;
            return 0;
        }
        int helper = 6 - fra - til;
        towerOfHanoi(n-1, fra, helper);
        //System.out.println("Flyt fra " + fra + " til " + til);
        count++;
        towerOfHanoi(n-1, helper, til);
        return count;
    }


}
