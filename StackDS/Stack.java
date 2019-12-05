
public class Stack {

	int top;
	int maxSize;
	int arr[];

	public Stack(int maxSize) {
		super();
		this.top = -1;
		this.arr = new int[maxSize];
		this.maxSize = maxSize;
	}

	boolean isEmpty() {
		return top == -1;
	}

	boolean isFull() {
		return top == maxSize - 1;
	}

	void push(int element) {
		if (top == maxSize - 1) {
			System.out.println("\n --> Stack Overflow!");
			return;
		}

		arr[++top] = element;
		System.out.println("Element Added in to the stack is : " + arr[top]);
	}

	void pop() {
		if (top == -1) {
			System.out.println("\n --> Stack Underflow");
			return;
		}
		System.out.println("Removed Element from Stack is " + arr[top--]);
	}

	void peek() {
		if (top == 1) {
			System.out.println("\n -->Stack is Empty");
			return;
		}

		System.out.println("Top Element in the Stack is " + arr[top]);
	}

	void display() {
		if (top == -1) {
			System.out.println("Stack is Empty");
		}

		System.out.println("----------Elements in the Stack from top!-------------------");
		for (int i = top; i >= 0; i--)
			System.out.print(" " + arr[i]);
		System.out.println("\n-----------------------------");
	}

	public static void main(String[] args) {

		Stack stk = new Stack(5);
		stk.pop();
		stk.push(10);
		stk.push(23);
		stk.push(45);
		stk.display();
		stk.push(78);
		stk.push(62);
		stk.display();
		stk.peek();
		stk.push(73);
		stk.pop();
		stk.display();
	}
}
