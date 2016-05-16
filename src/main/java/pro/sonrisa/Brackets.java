package pro.sonrisa;

import java.util.Stack;

public final class Brackets {

	private Brackets() {
	}

	public static boolean checkBrackets(String text) {

		Stack<Character> charStack = new Stack<Character>();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '{' || text.charAt(i) == '[' || text.charAt(i) == '(' || text.charAt(i) == '<') {
				charStack.push(text.charAt(i));
			} else if (!charStack.isEmpty()) {
				if ((text.charAt(i) == '}' && charStack.peek() == '{')
						|| (text.charAt(i) == ')' && charStack.peek() == '(')
						|| (text.charAt(i) == ']' && charStack.peek() == '[')
						|| (text.charAt(i) == '>' && charStack.peek() == '<')) {
					charStack.pop();
				} else if (text.charAt(i) == '}' || text.charAt(i) == ')' || text.charAt(i) == ']'
						|| text.charAt(i) == '>') {
					return false;
				}
			} else if (text.charAt(i) == '}' || text.charAt(i) == ')' || text.charAt(i) == ']'
					|| text.charAt(i) == '>') {
				return false;
			}
		}
		return charStack.isEmpty();
	}
}