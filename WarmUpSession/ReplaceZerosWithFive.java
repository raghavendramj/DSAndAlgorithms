
public class ReplaceZerosWithFive {
	public static void convertFive(int n) {
		int rep = 0;
		while (n > 0) {
			int rem = n % 10;
			rep = rep * 10 + (rem == 0 ? 5 : rem);
			n = n / 10;
		}
		System.out.println(reverse(rep));
	}

	public static int reverse(int n) {
		int rev = 0;
		while (n > 0) {
			int rem = n % 10;
			rev = rev * 10 + rem;
			n = n / 10;
		}
		return rev;
	}

	public static void main(String[] args) {
		convertFive(1004);
		convertFive(121);
	}
}
