package com.problems.datastructures.binarytree;

public class PrintAllAncestors {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		printAllAncestors(root, "", 8);
	}
	public static void printAllAncestors(Node x,String prefix,int data){
		if(x != null){
			if(x.data == data){
				System.out.println(prefix);
			}else{
				printAllAncestors(x.left, prefix+x.data, data);
				printAllAncestors(x.right, prefix+x.data, data);
			}
		}
	}
}
