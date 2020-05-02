package com.michael.EducationalContest;

import java.util.Arrays;
import java.util.Scanner;

public class Vacation2 {


    public static int sol(int n, int [][] h){

        int dp[][] = new int [n + 1][3];

        for(int i = 1; i <= n ; i ++){

            for(int j = 0; j < 3; j ++){

                for(int k = 0; k < 3 ; k ++){

                    if(k != j)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + h[i - 1][j] );
                }
            }
        }

        //print(dp);

        int a = 0;

        for(int i = 0; i < 3; i ++){
            a = Math.max(a,dp[n][i]);
        }

        return a;
    }

    public static int sol2(int n, int [][] h, int m){
        int [][] dp = new int [2][m];

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m ; j ++){
                for(int k = 0; k < m; k ++){

                    if(k != j){
                        dp[1][j] = Math.max(dp[1][j] , dp[0][k] + h[i][j] );
                    }
                }
            }

            dp[0] = Arrays.copyOf(dp[1] , m);

        }

        int a = 0;

        for(int i = 0; i < m; i ++){
            a = Math.max(a, dp[1][i]);
        }

        return a;
    }


    public static  void print(int [][] a){
        for(int i = 0; i < a.length; i ++){
            for(int j = 0; j < a[0].length; j ++){
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
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

        System.out.println("Vacation happiness " + sol(n,a));
        System.out.println("Solution 2 " + sol2(n,a,3));
    }
}