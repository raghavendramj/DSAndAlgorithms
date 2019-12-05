package com.learnbay.algos.linked.list;

import java.util.Iterator;

public class LinkedList {

	Node head;

	public LinkedList() {
		head = null;
	}

	public void addFromFront(int data) {

		if (head == null) {
			head = new Node(data);
			return;
		}

		Node current = new Node(data);
		current.next = head;
		head = current;
	}

	public Node addElementAtRear(int data) {

		if (head == null) {
			head = new Node(data);
			return head;
		}
		Node current = head;
		while (current.next != null)
			current = current.next;
		current.next = new Node(data);

		return current.next;
	}

	public void addElementAfter(int after, int data) {

		if (head == null) {
			head = new Node(data);
			return;
		}
		Node current = head;
		while (current.next != null && current.data != after)
			current = current.next;

		// Keep reference of next node
		Node nextNode = current.next;
		// Create new node and make next as current node
		Node newNode = new Node(data);
		current.next = newNode;

		// Make inserted node next for rest of the list using nextNode reference
		newNode.next = nextNode;
	}

	public void addElementBefore(int before, int data) {

		if (head == null) {
			head = new Node(data);
			return;
		}

		Node current = head, prev = null;
		while (current.next != null && current.data != before) {
			prev = current;
			current = current.next;
		}

		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.next = current;

	}

	public void deleteFront() {

		if (head == null)
			return;

		head = head.next;
	}

	public void deleteRear() {

		if (head == null)
			return;

		Node current = head, prev = null;
		while (current.next != null) {
			prev = current;
			current = current.next;
		}
		prev.next = null;
	}

	public void deleteElement(int element) {

		if (head == null)
			return;

		Node current = head, prev = null;
		while (current.next != null && current.data != element) {
			prev = current;
			current = current.next;
		}
		prev.next = current.next;
	}

	public void deleteAfter(int after) {

		if (head == null)
			return;

		Node current = head;
		while (current.next != null && current.data != after)
			current = current.next;

		if (current.next.next == null)
			current.next = null;
		else
			current.next = current.next.next;
	}

	public void createLoop(int where) {

		if (head == null) {
			System.out.println("Can't create a loop");
		}

		else if (head.next == null) {
			head.next = head;
		}

		Node lastElement = head;
		while (lastElement.next != null)
			lastElement = lastElement.next;

		Node current = head;
		while (current.data != where)
			current = current.next;

		lastElement.next = current;
	}

	public boolean detectLoop() {

		if (head == null)
			return false;

		Node slow = head, fast = head;

		while (slow.next != null) {

			slow = slow.next;
			fast = fast.next;
			fast = fast.next;

			if (fast.data == slow.data)
				return true;
		}
		return false;
	}

	public void removeLoop() {

		if (head == null)
			return;

		Node slow = head, fast = head;

		boolean hasLoop = false;
		while (slow != null && fast != null && slow.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow.data == fast.data) {
				hasLoop = true;
				break;
			}
		}

		if (hasLoop) {
			Node prev = null;
			slow = head;

			while (slow.data != fast.data) {
				prev = fast;
				fast = fast.next;
				slow = slow.next;
			}
			System.out.println("\n##################>>  Loop Starting point is " + fast.data);
			prev.next = null;
		}

		System.out.println("\n##################>> Printing the list after removing the loop..");
		printLinkedList();

		return;

	}

	public void printListFromNode(Node current) {

		System.out.print("\n**************** Elements in the list : ");
		while (current != null) {
			System.out.print(current.data + "  ");
			current = current.next;
		}
		System.out.println();
	}

	public void printLinkedList() {
		printListFromNode(head);
	}

	public Node reverseLinkedList(Node retNode) {

		if (retNode == null)
			return retNode;

		Node current = retNode, prev = null;
		while (current != null) {

			Node next = current.next;

			current.next = prev;
			prev = current;
			current = next;
		}

		retNode = prev;
		System.out.println("\n*******************  After reveresing the list");
		printListFromNode(retNode);
		;
		return retNode;

	}

	public int findEvenOrOddLengthWayOne() {

		if (head == null) {
			System.out.println("Length is ZERO");
			return 0;
		}

		Node current = head;

		int length = 0;
		while (current != null) {
			if (current.next == null) {
				length += 1;
				System.out.println("\n*************** Odd Length : " + length);
				return length;
			}

			else if (current.next.next == null) {
				length += 2;
				System.out.println("\n*************** Even Length : " + length);
				return length;
			}
			length += 2;
			current = current.next.next;
		}
		return length;
	}

	public int findEvenOrOddLengthWayTwo() {

		if (head == null)
			return 0;

		Node fast = head;
		int length = 0;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			length += 2;
		}

		if (fast.next == null) {
			length += 1;
			System.out.println("\n*************** Odd Length : " + length);
		}

		else if (fast.next.next == null) {
			length += 2;
			System.out.println("\n*************** Even Length : " + length);
		}

		return length;
	}

	public int findLengthOfList(Node head) {

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

	public Node generateList(int arr[]) {
		Node head = new Node(0);
		Node localHead = head;

		for (int data : arr) {
			localHead.next = new Node(data);
			localHead = localHead.next;
		}
		printListFromNode(head.next);
		return head.next;
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.addFromFront(5);
		list.addFromFront(4);
		list.addFromFront(3);
		list.addFromFront(2);
		list.addFromFront(1);

		list.addElementAtRear(6);
		list.addElementAfter(6, 8);
		list.addElementBefore(8, 7);
		list.printLinkedList();

		// System.out.println("1. Linked List has loop ? "+ list.detectLoop());

		list.createLoop(3);
		System.out.println("\n************************* Linked List has loop ? " + list.detectLoop());
		list.removeLoop();

		list.reverseLinkedList(list.head);

		list.findEvenOrOddLengthWayTwo();
		list.printLinkedList();

		list.addElementAtRear(8);

		list.findEvenOrOddLengthWayTwo();
		list.printLinkedList();
		/*
		 * list.deleteElement(5); list.deleteFront(); list.deleteRear();
		 * list.deleteAfter(6); list.deleteAfter(2);
		 * System.out.println("\n==========> After ALL the deletion operations!!");
		 * list.printLinkedList();
		 */

	}
}
