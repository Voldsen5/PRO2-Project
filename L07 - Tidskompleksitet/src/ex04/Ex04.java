package ex04;

public class Ex04 {
        private final int[] weeklyRainfall = {
                20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13, 15, 10,
                9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2,
                0, 0, 18, 0, 0, 0, 34, 12, 34, 23, 23, 12, 44,
                23, 12, 34, 22, 22, 22, 22, 18, 19, 21, 32, 24, 13};
        /**
         * Return the week number of the first week
         * in the period of 3 weeks with the least rainfall.
         */
        public int minRainfall3() {
            int sum = 0;
            int sum2 = (weeklyRainfall[0] + weeklyRainfall[1] + weeklyRainfall[2]);
            int index = 0;
            for (int i = 1; i < weeklyRainfall.length - 2; i++) {
                sum = (weeklyRainfall[i] + weeklyRainfall[i+1] + weeklyRainfall[i+2]);
                if (sum2 > sum){
                    sum2 = sum;
                    index = i;
                }
            }
            return index + 1;
        }
        /**
         * Return the week number of the first week
         * in the period of n weeks with the least rainfall.
         */
        public int minRainfallN(int n) {
            int index = 0;
            int sum2 = weeklyRainfall[n];
            int[] n1 = new int[n];
            int[] n2 = new int[n];
            for (int i = 1; i < weeklyRainfall.length; i++) {
                for (int j = 0; j < n; j++) {
                    n1[j] = weeklyRainfall[i];
                    n2[j] = weeklyRainfall[i + 1];
                    if (n1[j] < n2[j]){
                        index = j;
                    }
                }

            }
            return index + 1;
        }
        /**
         *  Return the week number of the first week in the longest period,
         *  where the rainfall has been exactly the same each week.
         */
        public int sameRainfall() {
            // TODO
            return 0;
        }
}
