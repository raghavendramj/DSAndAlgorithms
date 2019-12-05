
public class Queue {

	int maxSize;
	int arr[];
	int front;
	int rear;

	public Queue(int maxSize) {
		this.arr = new int[maxSize];
		this.front = 0;
		this.rear = -1;
		this.maxSize = maxSize;
	}

	public void enqueue(int element) {

		if (rear == maxSize - 1) {
			System.out.println("Queue is full");
			return;
		}

		arr[++rear] = element;

	}

	public boolean isEmpty() {
		return (rear == -1 || front == maxSize);
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}

		return arr[front++];

	}

	public void printElement() {

		if (rear == -1) {
			System.out.println("Queue is empty");
			return;
		}

		for (int i = 0; i <= rear; i++) {
			System.out.println(arr[i]);
		}
	}

	public int peek() {
		return rear == -1 ? -1 : arr[rear];
	}

	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);

		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}
}
