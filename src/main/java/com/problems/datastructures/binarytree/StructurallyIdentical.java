package com.problems.datastructures.binarytree;

public class StructurallyIdentical {
	public static void main(String[] args){
		Node x = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		CreateBinaryTree.preOrderIdx = 0;
		Node y = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		System.out.println(isIdentical(x, y));
	}
	public static boolean isIdentical(Node x,Node y){
		if(x == null && y == null){
			return true;
		}else if(x == null || y == null){
			return false;
		}
		return (x.data == y.data) && isIdentical(x.left, y.left) && isIdentical(x.right, y.right);
	}
	public static boolean isIdenticalWithoutRecursion(Node x,Node y){
		//
		return false;
	}
}
