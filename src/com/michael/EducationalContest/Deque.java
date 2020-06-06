package com.michael.EducationalContest;

import java.util.Scanner;

public class Deque {

    public static long solve(int [] a, int n){
        long dp[] = new long[n + 2];

        int i = 0, j = n - 1;
        int k = 2;

        while(i <= j){


            if(a[i] > a[j]){
                if(i + 1 < j && a[i + 1] > a[j] && a[i + 1] > a[i]){
                    dp[k] = dp[k - 2] + a[j];
                    j --;
                }
                else{
                    dp[k] = dp[k - 2] + a[i];
                    i ++;
                }

            }else{
                if(j - 1 > i && a[j - 1] > a[i] && a[j - 1] > a[j]){
                    dp[k] = dp[k - 2] + a[i];
                    i ++;
                }else{
                    dp[k] = dp[k - 2] + a[j];
                    j --;
                }

            }

            k ++;
        }

        if(n%2 == 0){
            return dp[n] - dp[n + 1];
        }
        return dp[n + 1] - dp[n];
    }


    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i ++){
            a[i] = scan.nextInt();
        }

        System.out.println(solve(a,n));
    }
}
