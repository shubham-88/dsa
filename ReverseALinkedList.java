package programs;

import java.util.Collections;
import java.util.LinkedList;

public class ReverseALinkedList {

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		print(n1);
		Node rev = reverse(n1);
		print(rev);

		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		
		Collections.reverseOrder();
	}

	private static void print(Node rev) {
		while (rev != null) {
			System.out.println(rev.val);
			rev = rev.next;
		}
	}

	static Node reverse(Node root) {
		Node prev = null;
		Node current = root;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return root = prev;

	}

	static class Node {

		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}
}
