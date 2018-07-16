package com.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfMirrorTree {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(6);
		tree.root.right = new Node(15);

		BinaryTree tree1 = new BinaryTree();
		tree1.root = new Node(10);
		tree1.root.left = new Node(15);
		tree1.root.right = new Node(6);
		tree1.root.right.right = new Node(16);

		System.out.println(checkMirrorTree(tree.root, tree1.root));

	}

	private static boolean checkMirrorTree(Node root, Node root2) {

		if (root != null && root2 != null) {

			Queue<Node> q1 = new LinkedList<Node>();

			Queue<Node> q2 = new LinkedList<Node>();

			if (root.key != root2.key) {

				return false;

			}

			q1.add(root);

			q2.add(root2);

			while (true) {

				int s1 = q1.size();

				int s2 = q2.size();

				if (s1 != s2) {

					return false;

				}
				
				if(s1==0)
				{
					break;
				}

				while (s1 > 0) {

					Node r1 = q1.poll();

					Node r2 = q2.poll();

					if (r1.key != r2.key) {
						return false;
					}

					s1--;

					if (r1.left != null)
						q1.add(r1.left);

					if (r1.right != null)

						q1.add(r1.right);

					if (r2.right != null)
						q2.add(r2.right);

					if (r2.left != null)

						q2.add(r2.left);

				}

			}

		}
		return true;

	}

}
