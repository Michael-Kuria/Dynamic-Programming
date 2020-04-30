package com.michael.EducationalContest;

import java.util.Scanner;

public class K_Stones {

    public static String stones(int n, int k, int [] a){
        boolean dp[] = new boolean[k + 1];

        for(int i = 0; i <= k ; i ++){
            for(int j = 0; j < n; j ++ ){

                if(a[j] <= i && !dp[i - a[j]]){
                    dp[i] = true;
                }
            }
        }

        return dp[k]? "First": "Second";
    }


    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int [] a = new int [n];
        for(int i = 0; i < n; i ++){
            a[i] = scan.nextInt();
        }

        System.out.println(stones(n,k,a));

    }
}
