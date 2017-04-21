package com.problems.datastructures.binarysearchtrees;

import com.problems.datastructures.binarytree.Node;

public class BST2DLL {
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
			System.out.print("(");
			printInOrder(x.left);
			System.out.print(x.data);
			printInOrder(x.right);
			System.out.print(")");
		}
	}
	public static void main(String[] args){
		Node root = insert(null, 4);
		root = insert(root,3);
		root = insert(root,2);
		root = insert(root,1);
		root = insert(root,9);
		root = insert(root,5);
		root = insert(root,6);
		root = insert(root,8);
		Node head = bstToDll(root);
		Node temp = head.right;
		System.out.print(head.data);
		while(temp != head){
			System.out.print(temp.data);
			temp = temp.right;
		}
	}
	public static Node min(Node x){
		if(x==null){
			return null;
		}
		if(x.left==null){
			return x;
		}
		return min(x.left);
	}
	public static Node deleteMin(Node x){
		if(x == null){
			return null;
		}
		if(x.left == null){
			return x.right;
		}
		x.left = deleteMin(x.left);
		return x;
		
	}
	public static Node max(Node x){
		if(x == null){
			return null;
		}
		if(x.right == null){
			return x;
		}
		return max(x.right);
	}
	public static Node deleteMax(Node x){
		if(x == null){
			return null;
		}
		if(x.right == null){
			return x.left;
		}
		x.right = deleteMax(x.right);
		return x;
	}
	public static Node bstToDll(Node x){
		if(x == null){
			return null;
		}
		Node head = linkPredecessor(x);
		System.out.println();
		Node tail = linkSuccessor(x);
		System.out.println();
		System.out.println(String.format("head = %s, tail = %s", head.data,tail.data));
		head.left = tail;
		tail.right = head;
		return head;
	}
	private static Node linkPredecessor(Node x){
		if(x==null){
			return null;
		}
		Node predecessor = max(x.left);
		if(predecessor!=null){
			System.out.print(predecessor.data);
			x.left = deleteMax(x.left);
			predecessor.right = x;
			predecessor.left = x.left;
			x.left = predecessor;
			return linkPredecessor(predecessor);
		}
		return x;
	}
	private static Node linkSuccessor(Node x){
		if(x==null){
			return null;
		}
		Node successor = min(x.right);
		if(successor!=null){
			System.out.print(successor.data);
			x.right = deleteMin(x.right);
			successor.left = x;
			successor.right = x.right;
			x.right = successor;
			return linkSuccessor(successor);
		}
		return x;
	}
}
