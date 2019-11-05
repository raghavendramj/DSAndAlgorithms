import java.util.Stack;

public class BalanacedBrackets {

	static boolean balancedBrackets(String input) {
		char[] arr = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();

		for (char bracket : arr) {

			if (bracket == '(' || bracket == '{' || bracket == '[')
				stack.push(bracket);

			else if (bracket == ')' || bracket == '}' || bracket == ']') {
				char inStack = stack.peek();
				if (bracket == ')' && inStack == '(' || bracket == ']' && inStack == '['
						|| bracket == '}' && inStack == '{')
					stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println("Are brackets balanced ? "+ balancedBrackets("{[()}]"));
		System.out.println("Are brackets balanced ? "+ balancedBrackets("{()}"));
	}
}
