package com.problems.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hackerland is a one-dimensional city with `n` houses, where each house `i` is located at some `xi` 
 * on the x-axis. The Mayor wants to install radio transmitters on the roofs of the city's houses. Each 
 * transmitter has a range, k , meaning it can transmit a signal to all houses <=k units of distance away. * 
 *
 * Given a map of Hackerland and the value of k, can you find and print the minimum number of transmitters 
 * needed to cover every house in the city? (Every house must be covered by at least one transmitter) Each 
 * transmitter must be installed on top of an existing house.
 */
public class HackerlandRadioTransmitter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        System.out.println(minNoOfTransmitters(x, k));
    }
    public static int minNoOfTransmitters(int[] house,int range){
        Arrays.sort(house);
        int leftCoveredHouse = 0;
        int rightCoveredHouse = 0;
        int candidateForTransmitter = 0;
        List<Integer> transmitterLocations = new ArrayList<Integer>();
        for (;rightCoveredHouse < house.length-1;) {
            if(house[candidateForTransmitter+1]-house[leftCoveredHouse] <= range){
                candidateForTransmitter += 1;
                rightCoveredHouse += 1;
            }else if(house[rightCoveredHouse+1]-house[candidateForTransmitter] <= range){
                rightCoveredHouse +=1;
            }else{
                System.out.println(String.format("(%d,%d,%d)", leftCoveredHouse,candidateForTransmitter,rightCoveredHouse));
                transmitterLocations.add(candidateForTransmitter);
                leftCoveredHouse = rightCoveredHouse+1;
                candidateForTransmitter = rightCoveredHouse+1;
                rightCoveredHouse = rightCoveredHouse+1;
            }
        }
        if(!transmitterLocations.contains(candidateForTransmitter)){
            System.out.println(String.format("(%d,%d,%d)", leftCoveredHouse,candidateForTransmitter,rightCoveredHouse));
            transmitterLocations.add(candidateForTransmitter);
        }
        return transmitterLocations.size();
    }

}
