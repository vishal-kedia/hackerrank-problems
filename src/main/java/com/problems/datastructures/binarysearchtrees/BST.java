package com.problems.datastructures.binarysearchtrees;

import java.util.Objects;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int N;

		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (Objects.isNull(x)){
			return 0;
		}
		return x.N;
	}
	public Value get(Key key){
		Node node = get(root,key);
		if(Objects.nonNull(node)){
			return node.value;
		}
		return null;
	}
	private Node get(Node x,Key k){
		if(Objects.isNull(x)){
			return null;
		}
		int cmp = k.compareTo(x.key);
		if(cmp < 0){
			return get(x.left,k);
		}else if(cmp > 0){
			return get(x.right,k);
		}else{
			return x;
		}
	}
	public void put(Key key, Value value){
		root = put(root,key,value);
	}
	private Node put(Node x,Key key,Value value){
		if(Objects.isNull(x)){
			return new Node(key,value,1);
		}else{
			int cmp = key.compareTo(x.key);
			if(cmp < 0){
				x.left = put(x.left,key,value);
			}else if(cmp > 0){
				x.right = put(x.right,key,value);
			}else{
				x.value = value;
			}
			x.N = size(x.left) + size(x.right) + 1;
			return x;
		}
	}
	public Key min(){
		if(Objects.isNull(root)){
			return null;
		}
		return min(root).key;
	}
	private Node min(Node x){
		if(Objects.isNull(x)){
			return null;
		}
		if(Objects.isNull(x.left)){
			return x;
		}else{
			return min(x.left);
		}
	}
	public Key max(){
		if(Objects.isNull(root)){
			return null;
		}
		return max(root).key;
	}
	private Node max(Node x){
		if(Objects.isNull(x)){
			return null;
		}
		if(Objects.isNull(x.right)){
			return x;
		}else{
			return max(x.right);
		}
	}
	public Key predecessor(Key key){
		Node node = get(root,key);
		if(Objects.nonNull(node)){
			Node predecessor = predecessor(node);
			if(Objects.nonNull(predecessor)){
				return predecessor.key;
			}
		}
		return null;
	}
	private Node predecessor(Node x){
		if(Objects.isNull(x)){
			return null;
		}
		return max(x.left);
	}
	public Key successor(Key key){
		Node node = get(root,key);
		if(Objects.nonNull(node)){
			Node successor = successor(node);
			if(Objects.nonNull(successor)){
				return successor.key;
			}
		}
		return null;
	}
	private Node successor(Node x){
		if(Objects.isNull(x)){
			return null;
		}
		return min(x.right);
	}
	public void delete(Key k){
		if(k!=null){
			root = delete(root,k);
		}
	}
	public void deleteMax(){
		root = deleteMax(root);
	}
	private Node deleteMax(Node x){
		if(Objects.isNull(x)){
			return null;
		}
		if(Objects.isNull(x.right)){
			return x.left;
		}
		x.right = deleteMax(x.right);
		return x;
	}
	public void deleteMin(){
		root = deleteMin(root);
	}
	private Node deleteMin(Node x){
		if(Objects.isNull(x)){
			return null;
		}
		if(Objects.isNull(x.left)){
			return x.right;
		}
		x.left = deleteMin(x.left);
		return x;
	}
	private Node delete(Node x,Key k){
		if(Objects.isNull(x)){
			return x;
		}
		int cmp = k.compareTo(x.key);
		if(cmp < 0){
			return delete(x.left,k);
		}else if(cmp > 0){
			return delete(x.right,k);
		}
		Node succ = successor(x);
		succ.left = x.left;
		succ.right = deleteMin(x.right);
		succ.N = size(succ.left) + size(succ.right);
		return succ;
	}
	public void print(){
		
	}
	public void print(Node x){
		
	}
}
