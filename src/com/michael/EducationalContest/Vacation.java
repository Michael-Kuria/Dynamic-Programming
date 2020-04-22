package com.michael.EducationalContest;

import java.util.Scanner;

public class Vacation {

    public static int vacation(int n, int [][] h){

        int [] dp = new int[n + 1];

        dp[1] = Math.max(h[0][0], Math.max(h[0][1], h[0][2]));

        for(int i = 2; i <= n; i ++){
            int j = i - 1; // maintaining the index in h

            if(dp[i - 1] - h[j - 1][0] == dp[i - 2]){
                dp[i] = dp[i - 1] + Math.max(h[j][1], h[j][2]);

            }else if(dp[i - 1] - h[j - 1][1] == dp[i - 2]){

                dp[i] = dp[i - 1] + Math.max(h[j][0], h[j][2]);
            }else{
                dp[i] = dp[i - 1] + Math.max(h[j][0], h[j][1]);
            }


        }

        return dp[n];

    }

    public static void main(String [] args){

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine().trim());

        int [][] a = new int[n][3];

        for(int i = 0; i < n ; i ++){
            String[] x = scan.nextLine().split(" ");
            a[i][0] = Integer.parseInt(x[0]);
            a[i][1] = Integer.parseInt(x[1]);
            a[i][2] = Integer.parseInt(x[2]);

        }

        System.out.println("Vacation happiness " + vacation(n,a));
    }
}
