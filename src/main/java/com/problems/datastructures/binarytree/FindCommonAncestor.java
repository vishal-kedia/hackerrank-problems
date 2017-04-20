package com.problems.datastructures.binarytree;

public class FindCommonAncestor {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		System.out.println(commonAncestor(root, 6, 8));
	}
	public static int commonAncestor(Node x,int y,int z){
		Node p = findCommonAncestor(x, y, z);
		if(p == null || p.data == y || p.data == z ){
			return -1;
		}
		return p.data;
	}
	public static Node findCommonAncestor(Node x,int y,int z){
		if(x == null){
			return null;
		}
		if(x.data == y || x.data == z){
			return x;
		}
		Node fromLeftSubTree = findCommonAncestor(x.left, y, z);
		Node fromRightSubTree = findCommonAncestor(x.right,y,z);
		if(fromLeftSubTree != null && fromRightSubTree != null){
			return x;
		}else if(fromLeftSubTree==null){
			return fromRightSubTree;
		}else{
			return fromLeftSubTree;
		}
	}
}
