package com.problems.datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class MaxElementInBinaryTree {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		System.out.println(findMaxElementInBinaryTree(root));
		System.out.println(findMaxElementWithoutRecursionInBinaryTree(root));
	}
	public static int findMaxElementInBinaryTree(Node x){
		if(x == null){
			return -1;
		}
		int leftTreeMax = findMaxElementInBinaryTree(x.left);
		int rightTreeMax = findMaxElementInBinaryTree(x.right);
		int maxAmongChilds = Math.max(leftTreeMax, rightTreeMax);
		return Math.max(maxAmongChilds, x.data);
	}
	public static int findMaxElementWithoutRecursionInBinaryTree(Node x){
		Queue<Node> queue = new ArrayDeque<Node>();
		int maxElement = -1;
		if(x==null){
			return maxElement;
		}
		queue.offer(x);
		while(!queue.isEmpty()){
			Node t = queue.poll();
			if(t.data > maxElement){
				maxElement = t.data;
			}
			if(Objects.nonNull(t.left)){
				queue.offer(t.left);
			}
			if(Objects.nonNull(t.right)){
				queue.offer(t.right);
			}
		}
		return maxElement;
	}
}
