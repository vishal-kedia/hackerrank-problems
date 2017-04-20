package com.problems.datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindSumOfAllElements {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		System.out.println(sum(root));
		System.out.println(sumWithoutRecursion(root));
	}
	public static int sum(Node x){
		if(x == null){
			return 0;
		}
		return x.data + sum(x.left) + sum(x.right);
	}
	public static int sumWithoutRecursion(Node x){
		int sum = 0;
		if(x == null){
			return sum;
		}
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(x);
		while(!queue.isEmpty()){
			Node t = queue.poll();
			sum += t.data;
			if(t.left!=null){
				queue.offer(t.left);
			}
			if(t.right!=null){
				queue.offer(t.right);
			}
		}
		return sum;
	}
}
