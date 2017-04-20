package com.problems.datastructures.heap;

public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] keys;
	private int size = 0;

	public MaxPQ(int maxN) {
		keys = (Key[]) new Comparable[maxN + 1];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	private void swim(int index) {
		while (index > 1 && less(index / 2, index)) {
			exchng(index / 2, index);
			index = index / 2;
		}
	}

	private void sink(int index) {
		while (2 * index <= size) {
			int j = 2 * index;
			if (j < size && less(j, j + 1))
				j++;
			if (!less(index, j))
				break;
			exchng(j, index);
			index = j;
		}
	}

	public void insert(Key v) {
		keys[++size] = v;
		swim(size);
	}

	public Key delMax() {
		Key max = keys[1];
		exchng(1, size--);
		keys[size + 1] = null;
		sink(1);
		return max;
	}

	private boolean less(int index1, int index2) {
		return keys[index1].compareTo(keys[index2]) < 0;
	}

	private void exchng(int index1, int index2) {
		Key p = keys[index1];
		keys[index1] = keys[index2];
		keys[index2] = p;
	}
}
