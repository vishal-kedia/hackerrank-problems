package com.problems.datastructures.binarytree;

public class PrintAllRootToLiftNodesPath {
	public static void main(String[] args){
		Node root = CreateBinaryTree.createBinaryTree(new int[] {4,3,1,6,8,2,9,5}, new int[] {6,1,8,3,4,9,2,5});
		//printAllLeafNodePaths(root,"");
		printPathWithTheGivenSum(root,"",0,14);
	}
	public static void printAllLeafNodePaths(Node x,String prefix){
		if(x != null){
			if(x.left != null){
				printAllLeafNodePaths(x.left,prefix+x.data);
			}
			if(x.right != null){
				printAllLeafNodePaths(x.right,prefix+x.data);
			}
			if(x.left == null && x.right == null){
				System.out.println(prefix+x.data);
			}
		}
	}
	public static void printPathWithTheGivenSum(Node x,String path,int sum, int givenSum){
		if(x != null){
			if(sum + x.data == givenSum){
				System.out.println(path+x.data);
			}else{
				printPathWithTheGivenSum(x.left, path+x.data, sum+x.data, givenSum);
				printPathWithTheGivenSum(x.right, path+x.data, sum+x.data, givenSum);
			}
		}
	}
}
