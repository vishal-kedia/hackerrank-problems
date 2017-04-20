package com.problems.datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class HalfNodesInBinaryTree {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		System.out.println(findHalfNodes(root));
		System.out.println(findHalfNodesInBinaryTreeWithoutRecursion(root));
	}
	public static int findHalfNodes(Node x){
		if(x == null){
			return 0;
		}else if(x.left == null && x.right !=null){
			return 1 + findHalfNodes(x.right);
		}else if(x.right == null && x.left !=null){
			return 1 + findHalfNodes(x.left);
		}
		return findHalfNodes(x.left) + findHalfNodes(x.right);
		
	}
	public static int findHalfNodesInBinaryTreeWithoutRecursion(Node x){
		int noOfHalfNodes = 0;
		if(x == null){
			return noOfHalfNodes;
		}
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(x);
		while(!queue.isEmpty()){
			Node t = queue.poll();
			if(t.left == null && t.right != null){
				noOfHalfNodes++;
				queue.offer(t.right);
			}else if(t.left != null && t.right == null){
				noOfHalfNodes++;
				queue.offer(t.left);
			}else if(t.left != null && t.right != null){
				queue.offer(t.right);
				queue.offer(t.left);
			}
		}
		return noOfHalfNodes;
	}
}
