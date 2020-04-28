package com.michael.EducationalContest;

import java.util.Scanner;

/**
 * Find the minimum possible total cost incurred before the frog reaches Stone N
 */
public class Frog_1 {

    /**
     * Bottom up approach, (Find the minimum cost of each i where 1 <= i <= n)
     * @param n Number of steps
     * @param h array consisting of the cost of each step
     * @return the minimum cost of arriving at n
     */
    public static int frog(int n, int [] h){

        int dp[] = new int [n];

        dp[0] = 0;
        dp[1] = Math.abs(h[1] - h[0]);

        for(int i = 2; i < n ; i ++){

            dp[i] = Math.min(dp [i - 2] + Math.abs(h[i] - h[i - 2]), dp[i - 1] + Math.abs(h[i] - h[i - 1]));



        }
        //print(dp);
        return dp[n - 1];
    }

    public static void print(int [] a){
        for(int i = 0; i < a.length; i ++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine().trim());
        int h [] = new int[n];
        String [] x = scan.nextLine().split(" ");


        for(int i = 0; i < n; i ++){

            h[i] = Integer.parseInt(x[i]);
        }

        System.out.println(frog(n,h));
    }
}
