package com.learnbay.algos.linked.list;

public class RemoveDuplicatesFromSortedList {

	public static Node removeDuplicatesFromSortedList(Node head) {

		if (head == null)
			return null;

		Node retNode = new Node(0);
		Node current = retNode;
		while (head != null) {

			int num1 = head.data;
			int num2 = head.next != null ? head.next.data : 0;

			if (num1 != current.data) {
				current.next = new Node(num1);
				current = current.next;
			}

			if (num1 == num2)
				head = head.next.next;
			else
				head = head.next;
		}

		return retNode.next;
	}

	public static Node differenApproach(Node head) {

		Node curr = head;

		while (curr != null) {

			Node temp = curr;
			while (temp != null && curr.data == temp.data)
				temp = temp.next;

			curr.next = temp;
			curr = curr.next;
		}

		return head;

	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		Node head = list.generateList(new int[] { 5, 10, 10, 10, 10, 10, 10, 10, 40, 40, 40, 60, 60 });
		head = differenApproach(head);
		list.printListFromNode(head);

		head = list.generateList(new int[] { 1, 1, 1, 1, 1, 2, 3, 4, 4, 4, 4, 5, 7, 8 });
		head = removeDuplicatesFromSortedList(head);
		list.printListFromNode(head);
	}
}
