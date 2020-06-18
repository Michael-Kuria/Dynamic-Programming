package com.michael.EducationalContest;

import java.util.Scanner;

public class Slime {


    public static long solve(int n, int [] a){

        long INF = (long)1e18 + 10;

        long dp[][] = new long[n][n];

        for(int i = 0; i < n; i ++){

            for(int j = i; j >= 0; j --){

                if(i == j){
                    dp[j][i] = 0;
                }else
                    dp[j][i] =  INF;
                    long s = sum(i,j,a);

                    for(int k = j; k < i; k ++){
                        dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i] + s);
                    }

            }
        }
        return dp[0][n - 1];
    }

    //  find sum of range  i to j in a
    private static long sum(int i, int j, int[] a) {

        long s = 0;

        for(int k = i; k >= j; k --){
            s += a[k];
        }
        return s;
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int [] a = new int[n];

        for(int i = 0; i < n; i ++){
            a[i] = scan.nextInt();
        }

        System.out.println(solve(n,a));

    }
}
