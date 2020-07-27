package com.michael.EducationalContest;

import java.util.Scanner;

public class Permutations {

    static int nax = 3005, n, MOD = (int)1e9 + 7;
    static Scanner scn = new Scanner(System.in);
    static String s;

    public static int add(int a, int b){

        a += b;

        if(a > MOD){
            a -= MOD;
        }
        return a;
    }

    public static void solve(){

        int dp[][] = new int[nax][nax];
        dp[1][1] = 1;

        for(int len = 2; len <= n; len ++){

            int [] pref = new int[len + 1];

            for(int i = 1; i <= len; i ++){
                pref[i] = add(pref[i - 1] , dp[len - 1][i]);
            }

            for(int b = 1; b <= len; b ++){

                // solving using prefix sum to obtain an O(n^2) solution
                int L,R;

                if(s.charAt(len - 2) == '<'){
                    L = 1;
                    R = b - 1;
                }else {
                    L = b;
                    R = len - 1;
                }

                if(L <= R){
                    dp[len][b] = (pref[R] - pref[L - 1] + MOD) % MOD;
                }
            }

        }

        int ans = 0;

        for(int j = 1; j <= n; j ++){
            ans = add(ans,  dp[n][j]);
        }

        System.out.println(ans);
    }


    public static void main(String [] args){

        n = scn.nextInt();
        s = scn.next();

        solve();
        scn.close();
    }


}
