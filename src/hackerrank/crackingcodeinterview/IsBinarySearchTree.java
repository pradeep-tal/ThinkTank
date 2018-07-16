package hackerrank.crackingcodeinterview;

public class IsBinarySearchTree {

	public static void main(String args[]) {

		/*
		 * Node leftL1 = new Node(1);
		 * 
		 * Node leftR1 = new Node(5);
		 * 
		 * Node left = new Node(3);
		 * 
		 * left.left = leftL1; left.right = leftR1;
		 * 
		 * Node rightR1 = new Node(13);
		 * 
		 * Node rightL1 = new Node(14);
		 * 
		 * rightL1.left = rightR1;
		 * 
		 * Node right = new Node(10);
		 * 
		 * right.right = rightL1;
		 * 
		 * Node root = new Node(8);
		 * 
		 * root.left = left;
		 * 
		 * root.right = right;
		 */

		Node leftL1 = new Node(1);

		Node leftR1 = new Node(4);

		Node left = new Node(2);

		left.left = leftL1;
		left.right = leftR1;

		Node rightR1 = new Node(7);

		Node rightL1 = new Node(5);

		Node right = new Node(6);

		right.right = rightR1;
		right.left = rightL1;

		Node root = new Node(3);

		root.left = left;

		root.right = right;

		System.out.println(checkBST(root));

	}

	static boolean checkBST(Node root) {
		return bstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean bstHelper(Node root, int min, int max) {

		if (root == null) {
			return true;
		}

		if (root.data < min || root.data > max) {
			return false;
		}

		return bstHelper(root.left, min, root.data - 1) && bstHelper(root.right, root.data + 1, max);

	}

}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int i) {
		this.data = i;
		this.right = null;
		this.left = null;
	}

}
