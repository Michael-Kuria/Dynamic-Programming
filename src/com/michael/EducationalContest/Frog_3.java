package com.michael.EducationalContest;

import java.util.Scanner;

public class Frog_3 {

    public static long compute(long a, long b, long c){
        return (long)Math.pow((b - a),2) + c;
    }

    public static Long frog(long [] h, int n, long c){

        Long [] dp = new Long [n];

        long INF = (long)(1e12 + 1e12);

        dp[0] = 0L;
        /*dp[1] = (int)Math.pow((h[1] - dp[0]), 2) + c;*/

        for(int k = 1; k < n; k ++){
            dp[k] = INF;
        }

        for(int i = 0; i < n; i ++){
            for(int j = i; j >= 0; j --){
                dp[i] = Math.min(dp[j] + compute(h[i],h[j],c), dp[i]);
            }

        }

        return dp[n - 1];
    }


    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long c = scan.nextLong();

        long [] h = new long[n];

        for(int i = 0; i < n; i ++){
            h[i] = scan.nextInt();
        }

        System.out.println(frog(h,n,c));
    }
}
