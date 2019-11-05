
public class IsBinary {

	static boolean isBinary(String str) {
		long num = Long.parseLong(str);
		while (num > 0) {
			long rem = num % 10;
			if (rem > 1)
				return false;
			num = num / 10;
		}
		return true;
	}
	
	
	static boolean isBinaryTwo(String str) {
		
		char arr[] = str.toCharArray();
		for (char c : arr) {
			if(c!='0' && c!='1')
				return false;
		}
		return true;
	}
	

	public static void main(String[] args) {
		System.out.println("Is Binary : " + isBinary("1011"));
		System.out.println("Is Binary : " + isBinary("450"));

		System.out.println("Is Binary : " + isBinary("0111100110101100"));
		System.out.println("Is Binary : " + isBinaryTwo("0010110001111000111010111101001010100100011101010"));
	}

}
