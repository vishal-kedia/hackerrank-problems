package com.problems.datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ZigZagTraversal {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		printInZigZagOrder(root);
	}
	public static void printInZigZagOrder(Node x){
		Queue<Node> queue = new ArrayDeque<Node>();
		Deque<Node> stack = new ArrayDeque<Node>();
		boolean leftToRight = true;
		queue.offer(x);
		queue.offer(new Node(-1, null, null));
		while(!queue.isEmpty()){
			Node t = queue.poll();
			if(t.data == -1){
				leftToRight = !leftToRight;
				if(!queue.isEmpty()){
					queue.offer(new Node(-1, null, null));
				}
			}else{
				if(leftToRight){
					System.out.print(t.data);
				}else{
					stack.push(t);
				}
			}
			while(leftToRight && !stack.isEmpty()){
				System.out.print(stack.pop().data);
			}
			if(t.left!=null){
				queue.offer(t.left);
			}
			if(t.right!=null){
				queue.offer(t.right);
			}
		}
	}
}
