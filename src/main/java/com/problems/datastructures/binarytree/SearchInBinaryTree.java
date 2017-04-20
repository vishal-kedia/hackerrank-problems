package com.problems.datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class SearchInBinaryTree {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		System.out.println(exists(root, 9));
		System.out.println(existsWithOutRecursion(root, 11));
	}
	public static boolean exists(Node x,int data){
		if(x==null){
			return false;
		}
		return (x.data == data) || exists(x.left,data) || exists(x.right,data);
	}
	public static boolean existsWithOutRecursion(Node x, int data){
		if(x==null){
			return false;
		}
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(x);
		while(!queue.isEmpty()){
			Node t = queue.poll();
			if(t.data == data){
				queue.clear();
				return true;
			}
			if(Objects.nonNull(t.left)){
				queue.offer(t.left);
			}
			if(Objects.nonNull(t.right)){
				queue.offer(t.right);
			}
		}
		return false;
	}

}
