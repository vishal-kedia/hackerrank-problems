package com.problems.datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class FullNodesInBinaryTree {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		System.out.println(findNoOfFullNodes(root));
		System.out.println(findNoOfFullNodesWithoutRecursion(root));
	}
	public static int findNoOfFullNodes(Node x){
		if(x == null){
			return 0;
		}else if(x.left == null){
			return findNoOfFullNodes(x.right);
		}else if(x.right == null){
			return findNoOfFullNodes(x.left);
		}
		return 1 + findNoOfFullNodes(x.left) + findNoOfFullNodes(x.right);
	}
	public static int findNoOfFullNodesWithoutRecursion(Node x){
		int noOfFullNodes = 0;
		if(x == null){
			return noOfFullNodes;
		}
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(x);
		while(!queue.isEmpty()){
			Node t = queue.poll();
			if(t.left != null && t.right != null)
				noOfFullNodes++;
			if(t.left != null){
				queue.offer(t.left);
			}
			if(t.right != null){
				queue.offer(t.right);
			}
		}
		return noOfFullNodes;
	}
}
