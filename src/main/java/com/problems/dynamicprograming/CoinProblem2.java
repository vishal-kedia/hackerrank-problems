package com.problems.dynamicprograming;

import java.util.Arrays;
import java.util.Scanner;

public class CoinProblem2 {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] coins = new int[m];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = scan.nextInt();
        }
        Arrays.sort(coins);
        System.out.println(getMinChange(coins, n));
    }

	private static long getMinChange(int[] coins, int amt) {
		long[][] p = get2DArray(coins.length,amt+1);
		return getMinChangeInternal(coins,amt,p,coins.length-1);
	}

	private static long getMinChangeInternal(int[] coins, int n, long[][] p,int k) {
		if(n < 0 || k < 0){
			return Integer.MAX_VALUE;
		}else if(n==0){
			return 0;
		}else if(p[k][n] == -1){
			p[k][n] = Math.min(getMinChangeInternal(coins,n-coins[k],p,k), getMinChangeInternal(coins,n,p,k-1));
		}
		System.out.println(String.format("(%d,%d) = %d", k,n,p[k][n]));
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
