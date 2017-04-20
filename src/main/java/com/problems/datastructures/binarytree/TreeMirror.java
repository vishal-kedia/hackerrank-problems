package com.problems.datastructures.binarytree;

public class TreeMirror {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		Node mirror = mirror(root);
		printInOrder(mirror);
	}
	public static Node mirror(Node x){
		if(x == null){
			return null;
		}
		System.out.println(x.data);
		Node t = x.left;
		x.left = mirror(x.right);
		x.right = mirror(t);
		return x;
	}
	public static void printInOrder(Node root) {
		if (root != null) {
			System.out.print("(");
			printInOrder(root.left);
			System.out.print(root.data);
			printInOrder(root.right);
			System.out.print(")");
		}
	}
}
