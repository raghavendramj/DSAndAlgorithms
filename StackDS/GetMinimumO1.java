import java.util.Stack;

public class GetMinimumO1 {

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	Stack<Integer> maxStack = new Stack<Integer>();

	public void pushElement(int item) {

		if (minStack.isEmpty() || minStack.peek() > item)
			minStack.push(item);

		if (maxStack.isEmpty() || maxStack.peek() < item)
			maxStack.push(item);

		stack.push(item);
	}

	public void removeElement() {

		int item = stack.pop();

		if (!minStack.isEmpty() && minStack.peek() == item)
			minStack.pop();

		if (!maxStack.isEmpty() && maxStack.peek() == item)
			maxStack.pop();
	}

	public static void main(String[] args) {

		GetMinimumO1 obj = new GetMinimumO1();
		obj.pushElement(5);
		obj.pushElement(2);
		obj.pushElement(6);
		System.out.println("Elements in the Stack : " + obj.stack.toString());
		System.out.println("Minumum Element in the stack : " + obj.minStack.peek());
		System.out.println("Maximum Element in the stack : " + obj.maxStack.peek());
		obj.pushElement(9);
		obj.pushElement(3);
		obj.pushElement(1);
		System.out.println("Elements in the Stack : " + obj.stack.toString());
		System.out.println("Minumum Element in the stack : " + obj.minStack.peek());
		System.out.println("Maximum Element in the stack : " + obj.maxStack.peek());
		obj.pushElement(10);
		obj.pushElement(4);
		System.out.println("Elements in the Stack : " + obj.stack.toString());
		System.out.println("Minumum Element in the stack : " + obj.minStack.peek());
		System.out.println("Maximum Element in the stack : " + obj.maxStack.peek());

	}

}
