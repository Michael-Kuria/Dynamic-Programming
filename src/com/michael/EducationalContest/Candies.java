package com.michael.EducationalContest;

import java.util.Scanner;

public class Candies {

    static int mod = (int)1e9 + 7;

    public static int sub(int a, int b){

        a -= b;
        if(a < 0){
           a += mod;
        }
        return a;
    }


    public static int add(int a, int b){
        a += b;

        if(a >= mod){
            a -= mod;
        }
        return a;
    }

    public static int solve(int n, int k, int [] a){

        int [] dp = new int [k + 1];

        dp[0] = 1;

        for(int i = 0 ; i < n; i ++) {

            int[] updates = new int[k + 1];

            for (int used = k; used >= 0; used--) {

                int L = used + 1;
                int R = used + Math.min(a[i], k - used);

                if (L <= R) {

                    updates[L] = add(updates[L], dp[used]);

                    if (R + 1 <= k) {
                        updates[R + 1] = sub(updates[R + 1], dp[used]);
                    }
                }

            }

            int pref = 0;

            for (int j = 0; j <= k; j++) {
                pref = add(pref, updates[j]);

                dp[j] = add(dp[j], pref);

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
        //System.out.println(solve2(n,k,a));

    }
}
