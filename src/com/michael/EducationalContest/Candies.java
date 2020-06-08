package com.michael.EducationalContest;

import java.util.Scanner;

public class Candies {

    public static long solve(int n, int k, int [] a){

        long dp[][] = new long [n + 1][k + 1];

        dp[0][0] = 1;
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= k; j ++){
                if(a[i - 1] > j)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];

            }
        }

        return dp[n][k] % (int)(1e9 + 7);
    }


    public static int solve2(int n, int k, int [] a){
        int dp[] = new int[k + 1];


        dp[0] = 1;
        for(int i = 0; i < n; i ++){

            for(int j = 0; j <= k; j ++ ){

                if(j <= a[i]){
                    dp[j] = dp[k - j]  +1;
                }
            }
        }

        return dp[k];
    }



    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int [] a = new int[n];

        for(int i = 0; i < n; i ++){
            a[i] = scan.nextInt();
        }

        System.out.println(solve(n,k,a));
        System.out.println(solve2(n,k,a));

    }
}
