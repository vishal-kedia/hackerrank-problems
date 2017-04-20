package com.problems.datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class HeightOfBinaryTree {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		System.out.println(findHeight(root));
		System.out.println(findHeightWithoutRecursion(root));
	}
	public static int findHeight(Node x){
		if(x == null){
			return 0;
		}
		return 1 + Math.max(findHeight(x.left),findHeight(x.right));
	}
	public static int findHeightWithoutRecursion(Node x){
		int height = 0;
		if(x == null){
			return height;
		}
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(x);
		queue.offer(new Node(-1, null, null));
		while(!queue.isEmpty()){
			Node t = queue.poll();
			if(t.data==-1){
				height++;
				if(!queue.isEmpty()){
					queue.offer(new Node(-1, null, null));
				}
			}else{
				if(t.left != null){
					queue.offer(t.left);
				}
				if(t.right != null){
					queue.offer(t.right);
				}
			}
		}
		return height;
	}
}
