package com.michael.EducationalContest;

import java.util.Scanner;

public class Coins_1 {

    // Bottom up using O(n^2 space)
    public static double bottom_up2(double[] p , int n){
        double[][] dp = new double[n + 1][ n + 1];

        dp[0][0] = 1;
        for(int i = 1; i <= n; i ++){
            for(int j = i ; j >= 0; j --){
                dp[i][j] = dp[i - 1][j] * (1 - p[i - 1]) + (j == 0 ? 0 : dp[i - 1][j - 1] * p[i - 1]);
            }
        }

        //print(dp);
        double a = 0;
        for(int j = 0; j <= n; j ++){
            int k = n - j;

            if(j > k){
                a += dp[n][j];
            }
        }

        return a;
    }


    // Bottom up saving some space
    public static double bottom_up(double[] p, int n){

        double [] dp = new double [n + 1];

        dp[0] = 1;
        for(int i = 0; i < n ; ++ i){ // for reading each coin's probability in the array p

            for(int j = i + 1  ; j >= 0; -- j){
                dp[j] = (j == 0 ? 0 : dp[j - 1] * p[i]) + dp[j] * (1 - p[i]);

            }
        }


        double answer = 0;
        for(int i = 0; i <= n; i ++){
            int tails = n - i;
            if(i > tails){
                answer += dp[i];
            }

        }

        return answer;

    }

    /**
     *
     * @param j is the position we are in in the array
     * @param h The number of heads we need
     * @param p The array containing the probability of the head of each coin
     * @return the probability of having the most heads
     */
    public static double recursive(int j, int h, double[] p){

        if(h - 1 > j || h == -1) {
            System.out.println( "b " + h +" " + j);
            return 0.0;
        }else if(j == -1){
            System.out.println( "c " + h +" " + j);
            return 1.0;
        }


        System.out.println("d " + h +" "+ j);
        return (p[j] * recursive(j - 1,h - 1,p)) + ((1.0 - p[j]) * recursive(j - 1, h,p));


    }


    public static double topDown(int j, int h, double [] p,  double [][] d ){

        if(h - 1 > j || h == -1) {

            return 0.0;
        }else if(j == -1){

            return 1.0;
        }else if(d[j][h] != 0.0 ){
            //System.out.println("1");
            return d[j][h];
        }

        double k = (p[j] * topDown(j - 1,h - 1,p,d)) + ((1.0 - p[j]) * topDown(j - 1, h,p,d));
        d[j][h] = k;
        return k;

    }

    /**
     * Find all the cases when the numbers of head are h - > n
     * @param n
     * @param p
     * @param d
     * @return
     */
    public static double prob(int n, double [] p, double[][] d){
        int h = n/2 + 1;

        double a = 0.0;

        for(;h <= n ; h ++){

            a += topDown(n - 1, h, p,d);

        }

        return a;
    }


    public static void print(double[][] a){
        for(int i = 0; i < a.length; i ++){
            for(int j = 0; j < a[0].length; j ++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String [] args){

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        double [] p = new double[n];

        for(int i = 0; i < n; i ++){
            p[i] = scan.nextDouble();
        }

        double [][] d = new double[n + 1][n + 1];

        System.out.println("Probability of having most heads : "+ prob(n,p,d));
        //print(d);
        System.out.println("Bottom up : " + bottom_up2(p,n));



        /*int j = p.length - 1;

        int h = 2; // the number of
        */
    }
}
