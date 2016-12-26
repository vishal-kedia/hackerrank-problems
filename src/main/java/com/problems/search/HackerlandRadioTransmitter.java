package com.problems.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HackerlandRadioTransmitter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        Arrays.sort(x);
        int leftCoveredHouse = 0;
        int rightCoveredHouse = 0;
        int candidateForTransmitter = 0;
        List<Integer> transmitterLocations = new ArrayList<Integer>();
        for (;rightCoveredHouse < x.length-1;) {
            if(x[candidateForTransmitter+1]-x[leftCoveredHouse] <= k){
                candidateForTransmitter += 1;
                rightCoveredHouse += 1;
            }else if(x[rightCoveredHouse+1]-x[candidateForTransmitter] <= k){
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
        System.out.println(transmitterLocations.size());
    }

}
