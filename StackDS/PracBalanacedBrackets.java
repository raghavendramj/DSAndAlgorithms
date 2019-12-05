import java.util.Stack;

public class PracBalanacedBrackets {

	public static boolean isBalanaced(String brackets) {

		if (brackets.length() % 2 != 0 || brackets == null || brackets.length() == 0)
			return false;

		Stack<Character> stk = new Stack<Character>();
		char[] chars = brackets.toCharArray();

		for (char character : chars) {

			if (character == '[' || character == '{' || character == '(') {
				stk.push(character);
				continue;
			}

			char outChar = stk.pop();
			boolean isBalanacedString = outChar == '[' && character == ']' || outChar == '(' && character == ')'
					|| outChar == '{' && character == '}';

			if (!isBalanacedString)
				return false;
		}

		return stk.isEmpty();
	}

	public static String isBalanacedString(String brackets) {

		if (brackets.length() % 2 != 0 || brackets == null || brackets.length() == 0)
			return "NO";

		Stack<Character> stk = new Stack<Character>();
		char[] chars = brackets.toCharArray();

		for (char character : chars) {

			if (character == '[' || character == '{' || character == '(') {
				stk.push(character);
				continue;
			}

			char outChar = stk.pop();
			boolean isBalanacedString = outChar == '[' && character == ']' || outChar == '(' && character == ')'
					|| outChar == '{' && character == '}';

			if (!isBalanacedString)
				return "NO";
		}

		return stk.isEmpty() ? "YES" : "NO";
	}

	public static void main(String[] args) {
		System.out.println("Are brackets balanced ? " + isBalanacedString("{[()}]"));
		System.out.println("Are brackets balanced ? " + isBalanacedString("{()}"));
		System.out.println("Are brackets balanced ? " + isBalanacedString("(())"));
		System.out.println("Are brackets balanced ? " + isBalanacedString("(({))"));
		System.out.println("Are brackets balanced ? " + isBalanacedString("(){}[]"));
		System.out.println("Are brackets balanced ? " + isBalanacedString("{[()]}"));
		System.out.println("Are brackets balanced ? " + isBalanacedString("{[(])}"));
		System.out.println("Are brackets balanced ? " + isBalanacedString("{{[[(())]]}}"));
	}
}
