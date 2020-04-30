package com.michael.EducationalContest;

import javax.swing.*;
import java.util.Scanner;

public class Grid_2 {

    public static int compute(int [][] dp , int i, int j){

        return (int)(dp[i - 1][j] + dp[i][j - 1] % (1e9 + 7));
    }

    public static int grid(int [][] g, int h, int w){

        int [][] dp = new int [h + 1][w + 1];


        for(int i = 1; i <= h; i ++){
            for(int j = 1; j <= w; j ++){
                if(g[i - 1][j - 1] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = i == 1 && j == 1 ? 1 : compute(dp, i, j);
                }

            }
        }

        return (int)(dp[h][w] % (1e9 + 7));


    }


    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt();
        int w = scan.nextInt();
        int n = scan.nextInt();

        int [][] g = new int[h][w];

        for(int i = 0; i < n; i ++){
            g[scan.nextInt() - 1][scan.nextInt() - 1] = 1;
        }

        System.out.println(grid(g,h,w));


    }
}
