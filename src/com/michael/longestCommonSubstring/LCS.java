package com.michael.longestCommonSubstring;


import java.util.Arrays;

/**
 * A java implementation of the Longest Common Substring
 */
public class LCS {

    /**
     * A bottom up approach
     * @param x
     * @param y
     * @return the length of the Longest common substring
     */
    public static int bottom_up(String x, String y){
        int [] a = new int[x.length() + 1];
        int [] b = new int[x.length() + 1];

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= y.length(); i ++){
            for(int j = 1; j <= x.length(); j ++){

                if(x.charAt(j - 1) == y.charAt(i - 1)){
                    b[j] = a[j - 1] + 1;
                    max = Math.max(b[j], max);
                }else{
                    b[j] = 0;
                }

            }

            a = Arrays.copyOf(b, b.length);
        }

        return max;

    }



    public static void main(String [] args){
        String x = "ABCBDABABACDCACDAAAAAA";
        String y = "BDCAACDABACDAAAAA";

        System.out.println("Bottom up : " + bottom_up(x,y));
        //print(a);
    }

}
