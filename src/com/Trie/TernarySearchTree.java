package com.Trie;

public class TernarySearchTree {

	public static void main(String[] args) {

		TSTNode node = null;
		node = insertKey(node, "cat", 0);
		node = insertKey(node, "cats", 0);
		node = insertKey(node, "catsr", 0);
		node = insertKey(node, "up", 0);
		node = insertKey(node, "bug", 0);

		// System.out.println(searchInTST(node, "cat1", 0));

		// System.out.println(searchInTSTIterative(node, "cat1", 0));

		// traverseTST(node, new StringBuilder());

		System.out.println(maxWord(node, new StringBuilder()));

	}

	private static boolean searchInTSTIterative(TSTNode node, String word, int pos) {

		while (node != null) {

			if (word.charAt(pos) < node.data) {

				node = node.left;

			} else if (word.charAt(pos) > node.data) {

				node = node.right;

			} else {
				if (node.isLast && word.length() - 1 == pos) {
					return true;
				} else {
					node = node.eq;
					pos = pos + 1;
				}

			}

		}

		return false;

	}

	private static boolean searchInTST(TSTNode node, String word, int pos) {

		if (node == null) {
			return false;
		}

		if (word.charAt(pos) < node.data) {

			return searchInTST(node.left, word, pos);

		} else if (word.charAt(pos) > node.data) {

			return searchInTST(node.right, word, pos);

		} else {
			if (node.isLast && word.length() - 1 == pos) {
				return true;
			} else {
				return searchInTST(node.eq, word, pos + 1);
			}

		}

	}

	private static void traverseTST(TSTNode node, StringBuilder sb) {

		if (node == null)
			return;

		sb.append(node.data);

		if (node.isLast) {
			System.out.println(sb.toString());
		}

		traverseTST(node.eq, sb);

		traverseTST(node.left, new StringBuilder(""));

		traverseTST(node.right, new StringBuilder(""));

	}

	private static Integer maxWord(TSTNode node, StringBuilder sb) {

		if (node == null)
			return 0;

		sb.append(node.data);

		if (node.isLast) {
			System.out.println(sb.toString());

			if (node.eq != null) {
				return maxWord(node.eq, sb);
			}
			return sb.toString().length();

		}

		return Math.max(Math.max(maxWord(node.eq, sb), maxWord(node.left, new StringBuilder(""))),
				maxWord(node.right, new StringBuilder("")));

	}

	static TSTNode root;

	static class TSTNode {

		char data;

		TSTNode left;

		TSTNode right;

		TSTNode eq;

		boolean isLast;

		public TSTNode(char c) {

			this.data = c;

		}

		public TSTNode() {

		}

	}

	static TSTNode insertKey(TSTNode node, String word, int pos) {

		if (word.length() <= pos)
			return node;

		if (node == null) {
			node = new TSTNode(word.charAt(pos));

			if (pos == word.length() - 1) {

				node.isLast = true;

				return node;
			} else {
				node.eq = insertKey(node.eq, word, pos + 1);

				return node;
			}

		} else if (word.charAt(pos) < node.data) {

			node.left = insertKey(node.left, word, pos);
		} else if (word.charAt(pos) > node.data) {
			node.right = insertKey(node.right, word, pos);
		} else {
			node.eq = insertKey(node.eq, word, pos + 1);
		}

		return node;

	}

}
