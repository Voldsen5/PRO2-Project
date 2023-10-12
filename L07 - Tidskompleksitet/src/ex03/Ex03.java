package ex03;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {

        int[] ga = {5,10,5,6,4,9,8};


        System.out.println(Arrays.toString(prefixAverage(ga)));
    }


    public static double[] prefixAverage(int[] input){
        double[] na = new double[7];
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            na[i] = sum / (i+1);
        }
        return na;
    }


}
