package com.problems.datastructures.binarytree;

public class DiameterOfBinaryTree {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		System.out.println(diameterOfTree(root));
	}
	public static int diameterOfTree(Node x){
		if(x == null || (x.left == null && x.right == null)){
			return 0;
		}
		return 1 + Math.max(diameterOfTree(x.left), diameterOfTree(x.right));
	}
}
