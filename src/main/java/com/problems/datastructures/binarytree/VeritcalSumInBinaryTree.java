package com.problems.datastructures.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VeritcalSumInBinaryTree {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		Map<Integer,Integer> data = new HashMap<Integer, Integer>();
		populateVeritcalNodes(root, 0, data);
		for(Entry<Integer, Integer> entry : data.entrySet()){
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
	}
	public static void populateVeritcalNodes(Node x,int column,Map<Integer,Integer> data){
		if(x != null){
			data.put(column, data.getOrDefault(column, 0)+x.data);
			populateVeritcalNodes(x.left, column-1, data);
			populateVeritcalNodes(x.right, column+1, data);
		}
	}
	
}
