package com.michael.EducationalContest;

import java.util.Scanner;

public class Flowers {

    static int  [] h, b;
    static int n;

    public static void solve(){

       long dp[] = new long[n];


       for(int i = 0; i  < n; i ++){
           dp[i] = b[i];

           for(int j = i - 1; j >= 0; j --){

               if(h[j] < h[i]){
                   dp[i] = Math.max(dp[i], dp[j] + b[i]);
               }
           }

       }

        System.out.println(dp[n - 1]);
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        h = new int[n]; b = new int[n];

        for(int i = 0; i < n; i ++){
            h[i] = scan.nextInt();
        }

        for(int i = 0; i < n; i ++){
            b[i] = scan.nextInt();
        }

        solve();
    }
}
