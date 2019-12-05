package com.learnbay.algos.linked.list;

public class FindIntersectionPoint {

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

	public static void findInterSectionPoint(Node head1, Node head2) {

		int len1 = findLengthOfList(head1);
		int len2 = findLengthOfList(head2);

		Node p1 = head1;
		Node p2 = head2;
		if (len1 > len2) {

			int diff = len1 - len2;
			while (diff != 0) {
				p1 = p1.next;
				diff--;
			}
		} else {
			int diff = len2 - len1;

			while (diff != 0) {
				p2 = p2.next;
				diff--;
			}
		}

		while (p1 != null && p2 != null) {

			if (p1 == p2) {
				System.out.println("\n\n **************** Intersection point is : " + p1.data);
				return;
			}

			p1 = p1.next;
			p2 = p2.next;
		}
	}

	public static void main(String[] args) {

		LinkedList list1 = new LinkedList();
		list1.addElementAtRear(1);
		list1.addElementAtRear(2);
		list1.addElementAtRear(3);
		list1.addElementAtRear(4);
		list1.addElementAtRear(5);
		list1.addElementAtRear(7);
		list1.addElementAtRear(8);
		Node element1 = list1.addElementAtRear(9);
		list1.addElementAtRear(10);
		list1.printLinkedList();

		LinkedList list2 = new LinkedList();
		list2.addElementAtRear(12);
		list2.addElementAtRear(13);
		Node element2 = list2.addElementAtRear(15);
		list2.printLinkedList();
		element2.next = element1;
		list2.printLinkedList();

		findInterSectionPoint(list1.head, list2.head);
	}
}
