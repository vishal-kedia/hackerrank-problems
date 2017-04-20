package com.problems.datastructures.binarytree;

public class CreateBinaryTree {
	public static int preOrderIdx = 0;
	public static void main(String[] args) {
		Node root = createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		printInOrder(root);
	}

	public static Node createBinaryTree(int[] preOrderList, int[] inOrderList) {
		return createBinaryTreeInternal(preOrderList, inOrderList,0,inOrderList.length - 1);
	}

	private static Node createBinaryTreeInternal(int[] preOrderList, int[] inOrderList, int inOrderStartIdx, int inOrderEndIdx) {
		if(inOrderStartIdx>inOrderEndIdx){
			return null;
		}
		if(inOrderStartIdx==inOrderEndIdx){
			return new Node(preOrderList[preOrderIdx++],null,null);
		}else{
			//System.out.println(String.format("%s,(%s,%s)", preOrderIdx,inOrderStartIdx,inOrderEndIdx));
			int data = preOrderList[preOrderIdx++];
			int inOrderIdx = searchIndex(inOrderList,data);
			return new Node(data,createBinaryTreeInternal(preOrderList, inOrderList, inOrderStartIdx, inOrderIdx-1),createBinaryTreeInternal(preOrderList, inOrderList, inOrderIdx+1, inOrderEndIdx));
		}
	}

	private static int searchIndex(int[] array, int element) {
		for (int i = 0; i < array.length; i++) {
			if (element == array[i]) {
				return i;
			}
		}
		throw new RuntimeException("Element not found");
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
