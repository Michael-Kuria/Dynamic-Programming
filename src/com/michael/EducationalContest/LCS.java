package com.michael.EducationalContest;

import java.util.Scanner;

/**
 * Longest common subsequence, output the sequence
 */
public class LCS {

    public static String lcs(String s, String t){

        int dp [][] = new int[s.length() + 1][t.length() + 1];

        for(int i = 1; i <= s.length(); i ++){
            for(int j = 1; j <= t.length(); j ++){

                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        //printArray(dp);

        StringBuilder x = new StringBuilder();

        int j = t.length();
        int i = s.length();
        while(i > 0 && j > 0 ){

           if(dp[i - 1][j] == dp[i][j]){
                i -= 1;

            }else if(dp[i][j - 1] == dp[i][j]){
                j -= 1;

            }else if(dp[i - 1][j - 1] == dp[i][j]){
                i -= 1;
                j -= 1;

            }else{
               x.append(s.charAt(i - 1));
               i -= 1;
               j -= 1;
           }

        }

        return x.reverse().toString();
    }


    public static void printArray(int [][] a){
        for(int i = 0; i < a.length; i ++){
            for(int j = 0; j < a[0].length; j ++){

                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String [] args){
        Scanner scan  = new Scanner(System.in);

        String s = scan.nextLine().trim();
        String t = scan.nextLine().trim();

        System.out.println("LCS " + lcs(s,t));
    }
}
