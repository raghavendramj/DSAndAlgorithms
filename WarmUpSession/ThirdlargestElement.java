
public class ThirdlargestElement {
	static int thirdLargest(int a[]) {

		return a.length < 3 ? -1 : sortArray(a)[a.length - 3];
	}

	static int[] sortArray(int arr[]) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int smallIndex = i;

			for (int j = i + 1; j < len; j++) {
				if (arr[smallIndex] > arr[j])
					smallIndex = j;
			}
			int temp = arr[smallIndex];
			arr[smallIndex] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 1, 3, 5 };
		System.out.println(thirdLargest(arr));
	}
}
