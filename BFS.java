package dsa;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String arr[]) {
		BFS parent = new BFS();
		Node root = parent.new Node(10);
		root.left = parent.new Node(8);
		root.right = parent.new Node(11);
		root.left.left = parent.new Node(7);
		root.left.right = parent.new Node(9);
		
		PrintLeafNodes(root,2);
		System.out.println("################");

		// bfs

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node child = q.poll();
			System.out.println(child.value);
			if (child.left != null)
				q.add(child.left);
			if (child.right != null)
				q.add(child.right);
		}

	}

	static void PrintLeafNodes(Node root, int level) {
		if (root == null) {
			return;
		}

		if (level == 1) {
			if (root.left == null && root.right == null) {
				System.out.print(root.value + " ");
			}

		} else if (level > 1) {
			PrintLeafNodes(root.left, level - 1);
			PrintLeafNodes(root.right, level - 1);
		}
	}

}
