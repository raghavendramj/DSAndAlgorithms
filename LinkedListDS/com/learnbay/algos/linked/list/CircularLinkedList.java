package com.learnbay.algos.linked.list;

public class CircularLinkedList {

	Node tail;

	public CircularLinkedList() {
		tail = null;
	}

	public void addElement(int data) {

		Node temp = new Node(data);
		if (tail == null) {
			tail = temp;
			tail.next = tail;
		} else {
			Node next = tail.next;
			temp.next = next;
			tail.next = temp;
		}
	}
	
	public void deleteElement(int data) {
		
		
		
	}

	public static void main(String[] args) {

		CircularLinkedList list = new CircularLinkedList();
		list.addElement(2);
		list.addElement(4);
		list.addElement(7);
		list.addElement(8);
	}
}
