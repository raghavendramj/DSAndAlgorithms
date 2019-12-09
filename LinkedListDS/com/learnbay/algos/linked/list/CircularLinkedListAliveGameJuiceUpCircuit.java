package com.learnbay.algos.linked.list;

public class CircularLinkedListAliveGameJuiceUpCircuit {

	public static void playGame(CircularLinkedList list) {

		Node current = list.tail.next;

		while (current.next != current) {
			System.out.println("\n Player : " + current.data + " Killed --> " + current.next.data);
			current.next = current.next.next;
			current = current.next;
		}
		System.out.println("\n Player who has won is :" + current.data);

	}

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list.insertAtBeginning(2);
		list.insertAtBeginning(4);
		list.insertAtBeginning(7);
		list.insertAtBeginning(8);
		list.insertAtEnd(12);
		list.insertAtEnd(15);
		list.insertAtEnd(18);
		list.insertAtEnd(19);
		list.printElements();
		playGame(list);
	}

}
