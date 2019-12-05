package com.learnbay.algos.linked.list;

public class FindKthElementFromLast {

	public static int findLengthOfList(Node head) {

		if (head == null)
			return 0;

		Node fast = head;
		int length = 0;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			length += 2;
		}

		length += fast.next == null ? 1 : 2;
		System.out.println("\n**********   Length is :  " + length);

		return length;
	}

	public static Node findKthFromLast(LinkedList list, int kthPos) {
		if (list.head == null)
			return null;

		Node current = list.head;

		int len = list.findLengthOfList(list.head);
		int pos = len - kthPos + 1;
		while (pos != 1) {
			current = current.next;
			pos--;
		}

		return current;

	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addElementAtRear(1);
		list.addElementAtRear(2);
		list.addElementAtRear(3);
		list.addElementAtRear(4);
		list.addElementAtRear(5);
		list.addElementAtRear(6);
		list.addElementAtRear(7);
		list.addElementAtRear(8);
		list.printLinkedList();
		System.out.println("2nd Element from last is : " + findKthFromLast(list, 2).data);
	}

}
