package com.problems.datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class SizeOfBinaryTree {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		System.out.println(sizeOfBinaryTree(root));
		System.out.println(sizeOfBinaryTreeWithoutRecursion(root));
	}
	public static int sizeOfBinaryTree(Node x){
		if(x == null){
			return 0;
		}
		return 1 + sizeOfBinaryTree(x.left) + sizeOfBinaryTree(x.right);
	}
	public static int sizeOfBinaryTreeWithoutRecursion(Node x){
		int nodeCount = 0;
		if(x == null){
			return 0;
		}
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(x);
		while(!queue.isEmpty()){
			Node t = queue.poll();
			if(t.left != null){
				queue.offer(t.left);
			}
			if(t.right != null){
				queue.offer(t.right);
			}
			nodeCount++;
		}
		return nodeCount;
	}
}
