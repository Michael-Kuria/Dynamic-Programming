package com.michael.EducationalContest;

import java.util.Scanner;

public class Frog_2 {


    public static int frog(int n, int k, int [] h){

        int [] dp = new int [n];

        dp[0] = 0;
        dp[1] = Math.abs(h[1] - h[0]);

        for(int i = 2; i < n; i ++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 2; i < k && i < n; i ++){

            for(int j = i - 1; j >= 0; j --)
                dp[i] = Math.min(dp[i], dp[j] + Math.abs( h[j] - h[i]));
        }


        for(int i = k; i < n; i ++){
            for(int j = i - 1; j >= i - k; j --){
                dp[i] = Math.min(dp[i], dp[j] + Math.abs( h[j] - h[i]));
            }
        }

       // Frog_1.print(dp);
        return dp[n-1];
    }


    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

       // String [] x = scan.nextLine().split(" ");

        int h [] = new int[n];

        for(int i = 0; i < n ; i ++){
            h[i] = scan.nextInt();
        }

        System.out.println(frog(n,k,h));
    }
}
