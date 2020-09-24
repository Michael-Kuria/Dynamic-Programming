package com.michael.EducationalContest;

import java.util.Scanner;

public class Walk {

    static int n, MOD = (int)1e9 + 7;
    static int [][] g;
    static long k;

    public static int mul(int a , int b){
        //long p = a * b;
        return (int)((long)a * (long)b % MOD);
    }

    public static int add(int a , int b){
        a += b;
        if(a >= MOD){
            a -=  MOD;
        }
        return a;
    }

    public static int[][] multiply(int [][] a, int [][] b){
        int C = a != null? a[0].length: 0;
        int R = b.length;

        if(R != C)
            throw new RuntimeException();

        int product[][] = new int[n][n];

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                for(int k = 0; k < n; k ++){

                    product[i][j] = add(product[i][j], mul(a[i][k], b[k][j]));
                }
            }
        }

        return product;
    }

    public static void solve(){

        int [][] result =  new int[n][n];

        // creating an identity matrix
        for(int i = 0; i < n; i ++){
            result[i][i] = 1;
        }

        // matrix exponentiation
        while(k > 0){
            if((k & 1) != 0)
                result = multiply(result, g);

            g = multiply(g, g);
            k /= 2;
        }

        int ans  = 0;

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                ans = add(ans, result[i][j]);
            }
        }
        System.out.println(ans);
    }

    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        k = scn.nextLong();

        g = new int[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                g[i][j] =  scn.nextInt();
            }
        }

        solve();
    }


}
