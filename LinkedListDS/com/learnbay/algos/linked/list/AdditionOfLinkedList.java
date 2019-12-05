package com.learnbay.algos.linked.list;

public class AdditionOfLinkedList {

	public static Node addElementFromFronForGivenLists(Node head1, Node head2) {

		Node sumNode = new Node(0);
		Node returnNode = sumNode;

		int carry = 0;
		while (head1 != null || head2 != null) {
			int first = head1 == null ? 0 : head1.data;
			int second = head2 == null ? 0 : head2.data;

			int sum = first + second + carry;
			carry = sum / 10;
			sum = sum % 10;

			Node temp = new Node(sum);
			returnNode.next = temp;

			head1 = head1 == null ? null : head1.next;
			head2 = head2 == null ? null : head2.next;

			returnNode = returnNode.next;
		}
		return sumNode.next;
	}

	public static Node addLinkedList(Node head1, Node head2) {

		head1 = new LinkedList().reverseLinkedList(head1);
		head2 = new LinkedList().reverseLinkedList(head2);
		return new LinkedList().reverseLinkedList(addElementFromFronForGivenLists(head1, head2));
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.addElementAtRear(2);
		list1.addElementAtRear(3);
		list1.addElementAtRear(4);
		list1.addElementAtRear(5);
		list1.printLinkedList();

		LinkedList list2 = new LinkedList();
		list2.addElementAtRear(5);
		list2.addElementAtRear(8);
		list2.addElementAtRear(7);
		list2.printLinkedList();

		Node sumNode = addLinkedList(list1.head, list2.head);
		list1.printListFromNode(sumNode);
	}
}
