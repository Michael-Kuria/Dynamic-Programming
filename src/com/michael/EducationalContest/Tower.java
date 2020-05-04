package com.michael.EducationalContest;


import java.util.Arrays;
import java.util.Scanner;

public class Tower {

    public static class Block implements Comparable<Block>{

        int w,s,v;

        Block(int w, int s, int v){
            this.w = w;
            this.s = s;
            this.v = v;
        }


        @Override
        public int compareTo(Block o) {
            return ((Integer) (w + s)).compareTo(o.s + o.w);
        }
    }


    public static long sol(Block[] b, int n, int SIZE){

        long [] dp = new long[SIZE + 1];

        for(int i = 0; i < n; i ++){

            for(int j = Math.min(SIZE - b[i].w , b[i].s); j >= 0; j --){
                dp[j + b[i].w] = Math.max(dp[j + b[i].w], dp[j] + b[i].v );
            }
        }

        long a = 0;

        for(int i = 0; i < SIZE; i ++){

            a = (long)Math.max(a, dp[i]);
        }

        return a;

    }




    /*public static class Pair{
        int f; int s;

        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }

    }

    public static int sol(int [] w, int [] s, int [] v, int n){

        Pair dp[][] = new Pair [n][n + 1];

        for(int i = 0; i < n; i ++){
            for(int j = 0; j <= n ; j ++ )
                dp[i][j] = new Pair(0,0);
        }


        for(int i = 0; i < n; i ++){
            for(int j = n ; j > i; j --){

                int x = s[j - 1] - dp[i][j].f;

                if(x > 0){
                    dp[i][j] = new Pair(dp[i][j - 1].f + w[j - 1], dp[i][j - 1].s + v[j - 1]);
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int a = 0;
        for(int i = 0; i < n ; i ++){
            a = Math.max(a,dp[i][n].s);

        }

        return a;
    }*/


    public static void main(String [] a){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Block [] b = new Block[n];



        for(int i = 0; i < n; i ++){

            b[i] = new Block(scan.nextInt(),scan.nextInt(),scan.nextInt());
        }
        Arrays.sort(b);

        System.out.println(sol(b,n,20123));
    }
}
