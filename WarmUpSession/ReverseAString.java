
public class ReverseAString {

	public static void main(String[] args) {

		String str = "LearnBay";
		System.out.println("Input String is :"+ str);
		char[] arr = str.toCharArray();
		int len = arr.length;

		for (int i = 0, j = len - 1; j > i; i++, j--) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		String output = "";
		
		for (char c : arr) {
			output += c;
		}
		
		System.out.println("Reveresed String is :"+ output);
	}

}
