package com.michael.EducationalContest;

import java.util.BitSet;
import java.util.Scanner;

public class Matching {
    static int mod = (int)1e9 + 7;

    public static int sum(int a, int b){

        a += b;

        if(a > mod){
            a -= mod;
        }

        return a;
    }

    public static int solve(int n, int [][] a){

        int [] dp = new int [1 << n];
        dp[0] = 1;


        for(int j = 0; j < (1 << n) - 1; j ++ ){
            int i =  Integer.bitCount(j);
            for(int k = 0; k < n; k ++){

                if(a[i][k] == 1 && (j & (1 << k)) == 0){

                    int m = j ^ (1 << k);
                    dp[m] = sum(dp[m], dp[j]);
                }
            }
        }


        return  (dp[(1 << n) - 1]);
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int [][] a = new int[n][n];

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){

                a[i][j] = scan.nextInt();
            }
        }

        System.out.println(solve(n,a));
    }
}
