package com.michael.fibonacci;

import java.util.HashMap;

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
     * and will be used later.
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


    public static void main(String  [] args){
        int n = 25;
        System.out.println("Using Dynamic Programming Approach: " + dynamicProgrammingApproach(n));
        System.out.println("Using NaiveApproach: " + naiveApproach(n));


    }
}
