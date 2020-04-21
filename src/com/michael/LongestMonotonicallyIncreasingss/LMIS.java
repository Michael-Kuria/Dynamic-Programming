package com.michael.LongestMonotonicallyIncreasingss;


import javafx.util.Pair;

/**
 * A java implementation of the Longest Monotonically Increasing Subsequence
 */
public class LMIS {


    /**
     * Bottom up approach
     * @param x
     * @return The length of the Longest Monotonically increasing subsequence
     */
    public static int lmis(String x){

        int [] dp = new int[x.length()];

        int c = 0;

        for(int i = 0; i < x.length(); i ++){
            for(int j = i; j >= 0; j --){

                if(x.charAt(i) >= x.charAt(j)){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            c = Math.max(dp[i], c);
        }

        return c;
    }


    public static void main(String [] a){
        String x = "ABCDAD";

        System.out.println("LMIS " + lmis(x));
    }
}
