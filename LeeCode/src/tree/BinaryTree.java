package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		System.out.println(maxDepth(treeNode));

	}
	
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		ArrayList<Integer> result = new ArrayList<>();
		deep(root, 1, result);
		System.out.println(result);
		Collections.sort(result);
		System.out.println(result);
        return result.get(result.size()-1);
    }
	
	private static void deep(TreeNode treeNode ,int floor ,List<Integer> result) {
		if (treeNode.left == null && treeNode.right == null) {
			result.add(floor);
			return;
		}
		
		if (treeNode.left == null) {
			deep(treeNode.right, floor + 1, result);
			return;
		}
		
		if (treeNode.right == null) {
			deep(treeNode.left, floor+1, result);
			return;
		}
		deep(treeNode.left, floor+1, result);
		deep(treeNode.right, floor+1, result);
	}
	
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		invert(root);
		return root;        
    }
	
	private static void invert(TreeNode treeNode) {
		if (treeNode.left == null && treeNode.right == null) {
			return;
		}
		if (treeNode.left == null) {
			treeNode.left = treeNode.right;
			treeNode.right = null;
			invert(treeNode.left);
			return;
		}
		if (treeNode.right == null) {
			treeNode.right = treeNode.left;
			treeNode.left = null;
			invert(treeNode.right);
			return;
		}
		TreeNode temp = treeNode.right;
		treeNode.right = treeNode.left;
		treeNode.left = temp;
		invert(treeNode.left);
		invert(treeNode.right);
	}
	
	public static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
}