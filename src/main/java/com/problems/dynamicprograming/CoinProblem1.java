package com.problems.dynamicprograming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a supply of C={C1,C2,C3,...,CM} using these in how many ways
 * can we make up the N cents. assuming that we have infinite supply
 * of the given valued coins of the lower denominations.
 * 
 * HINT: if the N is smaller than the coin dont include the coin into
 * the solution, if N is exactly equals to the coin then include into 
 * the solution ie. sum of ways including it and excluding it.
 *
 */
public class CoinProblem1 {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] coins = new int[m];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = scan.nextInt();
        }
        Arrays.sort(coins);
        System.out.println(getMaxExchangeType(coins, n));
    }
    
    public static long getMaxExchangeType(int[] coins,int n){
        long[][] p = get2DArray(coins.length,n+1);
        long solution = getMaxExchangeInternal(coins, n, coins.length-1, p);
        for (int k1 = 0; k1 < coins.length; k1++) {
            System.out.print(coins[k1]+"  ");
            for (int k2 = 0; k2 < n+1; k2++) {
                System.out.print(String.format(" %10d", p[k1][k2]));
            }
            System.out.println();
        }
        return solution;
    }
    
    private static long getMaxExchangeInternal(int[] coins,int n,int k,long[][] p){
        if(n < 0 || k < 0){
            return 0;
        }else if(n == 0){
            p[k][n] = 1;
            return p[k][n];
        }else if(p[k][n] == -1){
            if(n<coins[k]){
                p[k][n] = getMaxExchangeInternal(coins, n, k-1, p);
            }else if(n==coins[k]){
                p[k][n] = 1 + getMaxExchangeInternal(coins, n, k-1, p);
            }else{
                p[k][n] = getMaxExchangeInternal(coins, n-coins[k], k, p) + getMaxExchangeInternal(coins, n, k-1, p);
            }
        }
        return p[k][n];
    }
    private static long[][] get2DArray(int i,int j){
        if(i < 0 || j < 0){
            throw new IllegalArgumentException();
        }else{
            long[][] array = new long[i][j];
            for (int k1 = 0; k1 < i; k1++) {
                for (int k2 = 0; k2 < j; k2++) {
                    array[k1][k2] = -1;
                }
            }
            return array;
        }
    }
}
