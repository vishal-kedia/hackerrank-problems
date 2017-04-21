package com.problems.datastructures.binarysearchtrees;

import com.problems.datastructures.binarytree.Node;

public class BinarySearchTreeTest {
	public static Node insert(Node x,int data){
		if(x == null){
			return new Node(data, null, null);
		}
		if(data < x.data){
			x.left = insert(x.left, data);
		}else if(data > x.data){
			x.right = insert(x.right,data);
		}
		return x;
	}
	public static void printInOrder(Node x){
		if(x!=null){
			printInOrder(x.left);
			System.out.print(x.data);
			printInOrder(x.right);
		}
	}
	public static void main(String[] args){
		Node root = new Node(6,null,null);
		root.left = new Node(2,null,null);
		root.right = new Node(8,null,null);
		root.left.left = new Node(1,null,null);
		root.left.right = new Node(9,null,null);
		printInOrder(root);
		System.out.println(isBST(root));
	}
	public static boolean isBST(Node x){
		return isBSTInternal(x,Integer.MAX_VALUE,Integer.MAX_VALUE);
	}
	private static boolean isBSTInternal(Node x,int min,int max){
		if(x==null){
			return true;
		}
		return isBSTInternal(x.left, min,x.data) && (x.data > min && x.data < max) && isBSTInternal(x.right, x.data, max);
	}
}
