
public class FindSumPairForGivenNumber {

	static void findSunPair(int arr[], int sum) {

		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i] < sum) {
				int diff = sum - arr[i];
				for (int j = i + 1; j < len; j++) {
					if (diff == arr[j]) {
						System.out.println(" Sum pair is : " + arr[i] + " , " + arr[j]);
						return;
					}
				}
			}
		}
		System.out.println(" No Sum pair found in the given array for sum : " + sum);
	}

	public static void main(String[] args) {
		int arr[] = { 10, 8, 2, 3, 7, 1, 4 };
		findSunPair(arr, 8);
	}
}
