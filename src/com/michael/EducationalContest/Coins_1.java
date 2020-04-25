package com.michael.EducationalContest;

import java.util.Scanner;

public class Coins_1 {

    /**
     *
     * @param j is the position we are in in the array
     * @param h The number of heads we need
     * @param p The array containing the probability of the head of each coin
     * @return the probability of having the most heads
     */
    public static double recursive(int j, int h, double[] p){
        if(h == 1 && j == 0){
            System.out.println( "a " + h +" " + j);
            return p[j];
        }else if(h - 1 > j || h == -1) {
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
        print(d);



        /*int j = p.length - 1;

        int h = 2; // the number of
        */
    }
}
