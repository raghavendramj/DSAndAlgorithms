package com.learnbay.algos.linked.list;

public class MultiLevelLinkedList {

	MutiLevelNode head;

	public MultiLevelLinkedList() {
		head = null;
	}

	public MutiLevelNode addElementAtRight(int data) {

		MutiLevelNode newNode = new MutiLevelNode(data);

		if (head == null) {
			head = new MutiLevelNode(data);
			return head;
		}
		MutiLevelNode current = head;
		while (current.right != null)
			current = current.right;
		current.right = newNode;

		return head;
	}

	public MutiLevelNode addElementAtDown(int downof, int data) {

		MutiLevelNode newNode = new MutiLevelNode(data);

		if (head == null) {
			head = new MutiLevelNode(data);
			return head;
		}

		MutiLevelNode current = head;

		while (current.right != null && downof != current.data)
			current = current.right;

		while (current.down != null)
			current = current.down;
		current.down = newNode;

		return head;
	}

	public void printMultiLevelList() {

		MutiLevelNode current = head;

		while (current != null) {
			System.out.print(current.data + "  ");
			MutiLevelNode localCurr = current.down;

			System.out.print("\n**************** Elements in the list to the Down to : " + current.data + " --> ");
			while (localCurr != null) {
				System.out.print(localCurr.data + "  ");
				localCurr = localCurr.down;
			}
			System.out.println();
			current = current.right;

		}
		System.out.println();
	}

	public Node makeSingleRightList() {

		if (head == null)
			return null;

		Node referenceNode = new Node(0);
		Node returnNode = referenceNode;

		MutiLevelNode current = head;

		while (current != null) {

			returnNode.next = new Node(current.data);
			returnNode = returnNode.next;

			MutiLevelNode localCurr = current.down;
			while (localCurr != null) {
				returnNode.next = new Node(localCurr.data);
				localCurr = localCurr.down;
				returnNode = returnNode.next;
			}
			current = current.right;
		}

		new LinkedList().printListFromNode(referenceNode.next);
		return referenceNode.next;
	}

	public static void main(String[] args) {

		MultiLevelLinkedList list = new MultiLevelLinkedList();
		list.addElementAtRight(5);
		list.addElementAtDown(5, 7);
		list.addElementAtDown(5, 9);

		list.addElementAtRight(10);
		list.addElementAtDown(10, 12);
		list.addElementAtDown(10, 15);

		list.addElementAtRight(20);
		list.addElementAtDown(20, 22);
		list.addElementAtDown(20, 25);

		list.printMultiLevelList();
		list.makeSingleRightList();

	}

}
