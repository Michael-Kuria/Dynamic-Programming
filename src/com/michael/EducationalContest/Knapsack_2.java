package com.michael.EducationalContest;

import java.util.Scanner;

public class Knapsack_2 {

    public static class Item{
        int id;
        int w;
        int v;

        public Item(int id, int w, int v){
            this.w = w;
            this.v = v;
            this.id = id;
        }
    }


    public static int knapsack(int n, int w, Item [] it){

        int dp[][] = new int[n + 1][w + 1];

        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= w; j ++){

                if(it[i - 1].w > j){

                    dp[i][j] = dp[i - 1][j];
                }else{

                    dp[i][j] = Math.max(dp[i - 1][j],  dp[i - 1][j - it[i - 1].w] + it[i - 1].v);
                }
            }
        }

        return dp[n][w];
    }


    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int w = scan.nextInt();

        Item [] it = new Item[n];

        int i = 0;
        while(i < n){
            System.out.println(i);
            it[i] = new Item(i, scan.nextInt(), scan.nextInt());
            i ++;
        }

        System.out.println("Best " + knapsack(n,w,it));
    }
}
