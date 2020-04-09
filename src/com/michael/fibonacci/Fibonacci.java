package com.michael.fibonacci;

import java.util.HashMap;

/**
 * Java implementation for calculating fibonacci values
 */
public class Fibonacci {

    static HashMap<Integer,Integer> map = new HashMap<>(); // This map will be used to store computed fibonacci values

    /**
     * This the recursive approach that is commonly used.
     *
     * This function will take exponential time i.e O(2^n/2)
     *
     * @param n
     * @return the fibonacci of {@code n}
     */
    public static int naiveApproach(int n){

        if(n <= 2){
            return 1;
        }else{
            return naiveApproach(n - 1) + naiveApproach( n - 2);
        }

    }


    /**
     * This function uses dynamic programming. Once a value is computed the value is stored in a hash-map
     * and will be used later during computation.
     * This function takes O(n) time
     *
     * @param n argument
     * @return the fibonacci of {@code n}
     */
    public static int dynamicProgrammingApproach(int n){
        int f;
        if(!map.isEmpty() && map.get(n) != null ){
            f = map.get(n);
        }else if(n <= 2){
            f = 1;
            map.put(n, f);
        }else{
            f = dynamicProgrammingApproach(n - 1) + dynamicProgrammingApproach(n - 2);
            map.put(n,f);
        }

        return f;
    }


    /**
     * This a dp approach, except that in this case we first solve the small problems till we reach n;
     *  BOTTOM-UP-APPROACH
     * @param n
     * @return
     */
    public static int bottomUpApproach(int n){
        int [] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i ++){

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    public static void main(String  [] args){
        int n = 25;
        System.out.println("Using Dynamic Programming Approach: " + dynamicProgrammingApproach(n));
        System.out.println("Using the bottom up approach " + bottomUpApproach(n));
        System.out.println("Using NaiveApproach: " + naiveApproach(n));


    }
}
