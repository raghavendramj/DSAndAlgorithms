
public class FindMaxElemntInRightSideOfArray {

	public static void main(String args[]) {

		int arr[] = { 10, 8, 2, 4, 3, 7, 1 };

		int len = arr.length;
		for (int i = 0; i < len - 2; i++) {
			int max = arr[i + 1];
			for (int j = i + 1; j < len - 1; j++) {
				if (max < arr[j])
					max = arr[j];
			}
			arr[i] = max;
		}
		arr[len - 1] = -1;

		System.out.println("Arranged Array : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
