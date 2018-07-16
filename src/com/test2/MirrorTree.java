package com.test2;

public class MirrorTree {

	public static void main(String[] args) {
		
		BinaryTree root=new BinaryTree(10);
		
		BinaryTree left=new BinaryTree(11);
		
		BinaryTree right=new BinaryTree(12);
		
		root.left=left;
		
		root.right=right;
		

		inorder(root);
		
		BinaryTree root2=convertToMirrorTree(root);
		
		inorder(root2);
		
		
		
	}

	private static void inorder(BinaryTree root) {
		
		if(root!=null) {
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
		
	}

	private static BinaryTree convertToMirrorTree(BinaryTree root) {
		
		if(root==null) {
			return root;
		}else
		{
			BinaryTree left=convertToMirrorTree(root.left);
			
			BinaryTree right=convertToMirrorTree(root.right);
			
			root.left=right;
			root.right=left;
		}
		
		return root;
	}

}
