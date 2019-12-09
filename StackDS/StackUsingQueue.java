import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> q1;
	Queue<Integer> q2;

	public StackUsingQueue() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}

	public void pushUsingTwoQueue(int data) {

		if (q1.isEmpty()) {
			q1.add(data);
		} else {
			while (!q1.isEmpty())
				q2.add(q1.remove());

			q1.add(data);

			while (!q2.isEmpty())
				q1.add(q2.remove());
		}
	}
	
	public void pushUsingOneQueue() {
		
	}

	public int pop() {
		return q1.remove();
	}

	public boolean isEmpty() {
		return q1.isEmpty();
	}
	
	public void printStack() {
		System.out.print("Elements in the Stack from the top -->: ");
		for (Integer val : q1) {
			System.out.print(val+ " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		StackUsingQueue stack = new StackUsingQueue();
		stack.pushUsingTwoQueue(10);
		stack.pushUsingTwoQueue(20);
		stack.pushUsingTwoQueue(30);
		stack.printStack();
		
	}

}
