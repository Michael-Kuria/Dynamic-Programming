package com.michael.EducationalContest;

import java.util.Scanner;

/**
 * Find the number of ways you can reach [h,w] in a grid containing blocks (impassible cells)
 */
public class Grid_1 {

    /**
     *
     * @param h
     * @param w
     * @param g
     * @return
     */
    public static double grid(int h, int w,int [][] g){

        long [][] a = new long[h + 1][w + 1];


        for(int i = 1; i <= h; i ++){
            for(int j = 1; j <= w; j ++){

                if((i == 1 && j == 1)){
                    a[i][j] = 1;

                } else if(g[i - 1][j - 1] == 0){

                    a[i][j] = a[i - 1][j] + a[i][j - 1];

                }

            }
        }

        return a[h][w] % (Math.pow(10,9)+ 7);

    }


    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);


        String [] y = scan.nextLine().split(" ");
        int h = Integer.parseInt(y[0]);
        int w = Integer.parseInt(y[1]);


        int [][] g = new int[h][w];

        for(int i = 0; i < h; i ++){
            String x = scan.nextLine().trim();

            for(int j = 0; j < w; j ++){

                if(x.charAt(j) == '#'){
                    g[i][j] = 1;
                }
            }
        }

        System.out.println("Total paths is : " + grid(h,w,g));

    }
}
