package com.learnbay.algos.linked.list;

public class MegreTwoSortedLists {

	// Not working yet.
	public static Node addList(Node head1, Node head2) {
		Node resHead = new Node(0);
		Node head = resHead;
		// both list is not empty
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				head.next = head1;
				head1 = head1.next;
			} else {
				head.next = head2;
				head2 = head2.next;
			}
			head = head.next;
		}

		// head1 list is not empty
		while (head1 != null) {
			head.next = head1;
			head1 = head1.next;

			head = head.next;
		}
		// head2 list is not empty
		while (head2 != null) {
			head.next = head2;
			head2 = head2.next;

			head = head.next;
		}

		return resHead.next;
	}

	public static Node mergeTwoList(Node head1, Node head2) {

		LinkedList resHead = new LinkedList();
		while (head1 != null && head2 != null) {

			int data = head1.data < head2.data ? head1.data : head2.data;

			if (head1.data < head2.data) {
				data = head1.data;
				head1 = head1.next;
			} else {
				data = head2.data;
				head2 = head2.next;
			}
			resHead.addElementAtRear(data);
		}

		while (head1 != null) {
			resHead.addElementAtRear(head1.data);
			head1 = head1.next;
		}

		while (head2 != null) {
			resHead.addElementAtRear(head2.data);
			head2 = head2.next;
		}
		return resHead.head;
	}

	public Node megreViaRecursion(Node head1, Node head2) {

		if (head1 == null && head2 == null)
			return null;

		if (head2 == null)
			return head1;

		if (head1 == null)
			return head2;

		if (head1.data < head2.data) {
			head1.next = megreViaRecursion(head1.next, head2);
			return head1;
		}

		else {
			head2.next = megreViaRecursion(head1, head2.next);
			return head2;
		}
	}

	public static void main(String[] args) {

		LinkedList list1 = new LinkedList();
		list1.addElementAtRear(20);
		list1.addElementAtRear(30);
		list1.addElementAtRear(40);
		list1.addElementAtRear(50);
		list1.printLinkedList();

		LinkedList list2 = new LinkedList();
		list2.addElementAtRear(25);
		list2.addElementAtRear(28);
		list2.addElementAtRear(44);
		list2.addElementAtRear(55);
		list2.printLinkedList();

		Node res = new MegreTwoSortedLists().megreViaRecursion(list1.head, list2.head);
		list1.printListFromNode(res);
	}
}
