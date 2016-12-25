package com.problems.dynamicprograming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Bill Gates is on one of his philanthropic journeys to a village in Utopia. He has N packets of 
 * candies and would like to distribute one packet to each of the K children in the village (each 
 * packet may contain different number of candies). To avoid a fight between the children, he 
 * would like to pick K out of N packets such that the unfairness is minimized.
 * 
 * Unfairness is nothing but the sum of difference of all the candies in all the picked up packets. 
 */
public class AngryChildren2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfPackets = scan.nextInt();
        int noOfChildrens = scan.nextInt();
        long[] packets = new long[noOfPackets];
        for (int i = 0; i < packets.length; i++) {
            packets[i] = scan.nextInt();
        }
        long startTime = System.currentTimeMillis();
        System.out.println(minimumUnfairness(packets, noOfChildrens));
        //System.out.println("Execution Time ="+(System.currentTimeMillis()-startTime));
    }
    
    private static long minimumUnfairness(long[] packets,int noOfChildrens){
        Arrays.sort(packets);
        long[] addedCandies = new long[packets.length];
        long sum = 0;
        for (int i = 0; i < addedCandies.length; i++) {
            sum += packets[i];
            addedCandies[i] = sum;
        }
        //return minimumUnfairnessRecursiveInternal(new HashMap<String,Long>(),packets, noOfChildrens, 0, packets.length-1);
        return minimumUnfairnessIterativeInternal(packets,addedCandies,noOfChildrens);
    }
    
    private static long minimumUnfairnessRecursiveInternal(Map<String,Long> mem,long[] packets,int noOfChildrens,int i,int j){
        final String key = String.format("(%d,%d)", i,j);
        if(!mem.containsKey(key)){
            if(i==j){
                mem.put(key, 0L);
            }else if(j-i==noOfChildrens-1){
                long sum = 0;
                for (int k = i; k < j; k++) {
                    for (int k2 = k+1; k2 <= j; k2++) {
                        sum += packets[k2]-packets[k];
                    }
                }
                mem.put(key, sum);
                System.out.println(key+"="+sum);
            }else{
                mem.put(key, Math.min(minimumUnfairnessRecursiveInternal(mem,packets, noOfChildrens, i+1, j), minimumUnfairnessRecursiveInternal(mem,packets, noOfChildrens, i, j-1)));
            }
        }
        return mem.get(key);
    }
    private static long minimumUnfairnessIterativeInternal(long[] packets,long[] addedCandies,int noOfChildrens){
        long minDiff = unfairness(packets,addedCandies, 0, noOfChildrens-1);
        long diff = minDiff;
        //System.out.println(String.format("diff(%d,%d)=%d", 0,noOfChildrens-1,diff));
        for (int i = 1; i < packets.length-noOfChildrens+1; i++) {
            diff +=((noOfChildrens-1)*(packets[i-1] + packets[i+noOfChildrens-1])) - 2*(addedCandies[i+noOfChildrens-2]-addedCandies[i-1]);
            if(diff < minDiff){
                minDiff = diff;
            }
            //System.out.println(String.format("diff(%d,%d)=diff(%d,%d)+(%d*(%d+%d)-2*(%d-%d))", i,i+noOfChildrens-1,i-1,i+noOfChildrens-2,noOfChildrens-2,packets[i-1],packets[i+noOfChildrens-1],addedCandies[i+noOfChildrens-2],addedCandies[i-1]));
        }
        return minDiff;
    }
    private static long unfairness(long[] packets,long[] addedCandies,int ki, int kj){
        long diff = 0;
        for (int i = ki+1; i <= kj; i++) {
            diff += i*packets[i]-(sumOfElementsBetweenIndexIncluding(addedCandies, ki, i-1));
            //System.out.println(String.format("diff(%d,%d)=diff(%d,%d) + %d*pack(%d)-sum(%d,%d)", ki,i,ki,i-1,i,i,ki,i-1));
        }
        return diff;
    }
    private static long sumOfElementsBetweenIndexIncluding(long[] addedCandies,int i, int j){
        if(i>0){
            return addedCandies[j]-addedCandies[i-1];
        }else{
            return addedCandies[j];
        }
    }

}
