package com.michael.EducationalContest;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack_1 {


    public static class Item implements Comparable<Item> {
        int id;
        int w;
        int v;

        public Item(int id, int w, int v){
            this.id = id;
            this.w = w;
            this.v = v;
        }


        @Override
        public int compareTo(Item o) {
            if(w < o.w){
                return -1;
            }else if(w > o.w){
                return 1;
            }
            return 0;
        }
    }

    /**
     * Recursive approach.
     *
     * @param i
     * @param w
     * @param items
     * @return
     */
    public static long recursive(int i, int w, Item [] items) {

        if(w < 0 ) {
            return Integer.MIN_VALUE;
        }else if(i >= items.length){

            return 0;
        }


        return Math.max(recursive(i + 1, w,items), recursive(i + 1, w - items[i].w,items) + items[i].v );

    }

    /**
     * Bottom up approach
     * @param n the total number of items
     * @param w the expected highest weight
     * @param items the list of items
     * @return the best value that can be acquired
     */
    public static long knapsack(int n, int w, Item [] items){

        long dp[][] = new long[n + 1][w + 1];

        for(int i = 1; i <= n; i ++){


            for(int j = 1; j <= w; j ++){

                if(items[i - 1].w > j){
                    dp[i][j] = dp[i - 1][j];
                }else{

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i - 1].w] + items[i - 1].v);
                }
            }
        }
        return dp[n][w];
    }



    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        String [] x = scan.nextLine().trim().split(" ");

        int n = Integer.parseInt(x[0]);
        int w = Integer.parseInt(x[1]);


        Item [] items = new Item[n];

        for(int i = 0; i < n; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();

            Item item = new Item(i,a,b);
            items[i] = item;


        }

        //Arrays.sort(items);


        System.out.println("Best "  +recursive(0,w,items));
        System.out.println("Knapsack " + knapsack(n,w,items));
    }
}
