package com.learnbay.algos.linked.list;

public class DoublyLinkedList {

	DoublyNode head;

	public DoublyLinkedList() {
		this.head = null;
	}

	public DoublyNode insertElementAtFront(int data) {

		DoublyNode newNode = new DoublyNode(data);

		if (head == null) {
			head = newNode;
			return head;
		}

		DoublyNode current = head;
		newNode.next = current;
		current.prev = newNode;
		head = newNode;

		return head;

	}

	public DoublyNode insertEementAtRear(int data) {

		DoublyNode newNode = new DoublyNode(data);

		if (head == null) {
			head = newNode;
			return head;
		}

		DoublyNode current = head;
		while (current.next != null)
			current = current.next;

		current.next = newNode;
		newNode.prev = current;

		return head;

	}

	public DoublyNode insertElementAfter(int after, int data) {

		DoublyNode newNode = new DoublyNode(data);

		if (head == null) {
			head = newNode;
			return head;
		}

		DoublyNode current = head;
		while (current != null && current.data != after)
			current = current.next;

		DoublyNode currNext = current.next;

		current.next = newNode;
		newNode.prev = current;

		newNode.next = currNext;
		currNext.prev = newNode;

		return head;
	}

	public DoublyNode insertElementBefore(int before, int data) {

		DoublyNode newNode = new DoublyNode(data);

		if (head == null) {
			head = newNode;
			return head;
		}

		DoublyNode current = head;
		while (current != null && current.data != before)
			current = current.next;

		DoublyNode prevNode = current.prev;

		prevNode.next = newNode;
		newNode.prev = prevNode;

		newNode.next = current;
		current.prev = newNode;

		return head;
	}

	public void printDoublyLinkedList() {
		printDoublyLinkedList(head);
	}

	public void printDoublyLinkedList(DoublyNode fromNode) {

		System.out.println("\n ****** Elements in the Doubly Linked List are : ");
		while (fromNode != null) {
			System.out.print(fromNode.data + "  ");
			fromNode = fromNode.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		DoublyLinkedList list = new DoublyLinkedList();
		list.insertEementAtRear(10);
		list.insertEementAtRear(20);
		list.insertEementAtRear(30);
		list.insertElementAtFront(05);
		list.insertElementAtFront(02);
		list.printDoublyLinkedList();
		list.insertElementAfter(20, 25);
		list.insertElementBefore(20, 15);
		list.printDoublyLinkedList();

	}

}
