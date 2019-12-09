package com.learnbay.algos.linked.list;

import java.util.Stack;

public class CircularLinkedList {

	Node tail;

	public CircularLinkedList() {
		tail = null;
	}

	public void insertAtBeginning(int data) {

		Node newNode = new Node(data);
		if (tail == null) {
			tail = newNode;
			tail.next = tail;
		} else {

			Node next = tail.next;
			tail.next = newNode;
			newNode.next = next;
		}
	}

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);

		if (tail == null) {
			tail = newNode;
			tail.next = tail;
		} else {

			Node next = tail.next;
			tail.next = newNode;
			newNode.next = next;
			tail = newNode;
		}

	}

	void printElements() {

		if (tail == null) {
			System.out.println("Empty List!");
			return;
		}

		System.out.println("\n******** Elements in the list are : ");
		Node current = tail.next;
		while (current != tail) {
			System.out.print(current.data);
			if (current.next != tail)
				System.out.print(" --> ");
			current = current.next;
		}
		System.out.print(" --> " + current.data);
	}

	public void deleteElementFromStart() {
		if (tail == null)
			return;

		if (tail.next == tail) {
			tail = null;
			return;
		}

		tail.next = tail.next.next;
	}

	public void deleteElementFromEnd() {
		if (tail == null)
			return;

		if (tail.next == tail) {
			tail = null;
			return;
		}

		Node current = tail.next;
		while (current.next != tail)
			current = current.next;

		tail = current;
		tail.next = tail.next.next;
	}

	public void deleteSpecificElement(int data) {

		if (tail == null)
			return;

		if (tail.next == tail && tail.data == data) {
			tail = null;
			return;
		}

		Node current = tail.next;
		while (current != tail && current.next.data != data)
			current = current.next;

		current.next = current.next.next;
	}

	public static void main(String[] args) {

		CircularLinkedList list = new CircularLinkedList();
		list.insertAtBeginning(2);
		list.insertAtBeginning(4);
		list.insertAtBeginning(7);
		list.insertAtBeginning(8);
		list.printElements();
		list.insertAtEnd(12);
		list.insertAtEnd(15);
		list.insertAtEnd(18);
		list.insertAtEnd(19);
		list.printElements();
		list.deleteSpecificElement(2);
		list.printElements();
		list.deleteSpecificElement(18);
		list.printElements();
		list.deleteElementFromStart();
		list.deleteElementFromStart();
		list.printElements();
		list.deleteElementFromEnd();
		list.deleteElementFromEnd();
		list.printElements();
	}
}
