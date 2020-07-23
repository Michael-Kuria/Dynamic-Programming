package com.michael.EducationalContest;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack_2 {

    static int totalValue = 0;
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




    public static void sol(int n, int w, Item [] it){

        int dp[] = new int[totalValue + 5];

        Arrays.fill(dp, Integer.MAX_VALUE >> 2);
        dp[0] = 0;

        for(int i = 0; i < n; i ++){

            for(int x = totalValue - it[i].v; x >= 0; x --){

                dp[x + it[i].v] = Math.min(dp[x + it[i].v], dp[x] + it[i].w);
            }
        }


        int ans = 0;

        for(int i = 0; i <= totalValue; i ++){

            if(dp[i] <= w)
                ans = Math.max(ans, i);
        }

        System.out.println(ans);

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
            totalValue += it[i].v;
            i ++;
        }

        sol(n,w,it);
    }
}
