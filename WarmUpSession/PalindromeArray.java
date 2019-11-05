
public class PalindromeArray {

	public static int palinArray(int[] a, int n) {
		for (int ele : a) {
			int temp = ele, rev = 0;
			while (temp > 0) {
				int rem = temp % 10;
				rev = rev * 10 + rem;
				temp = temp / 10;
			}

			if (ele != rev)
				return 0;
		}
		return 1;
	}

	public static void main(String[] args) {

		System.out.println(palinArray(new int[] { 111, 222, 333, 444, 555 }, 5));
	}
}
