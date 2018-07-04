import java.util.Stack;

public class PrefixPostfix {
	
	/**
	 * Convert from prefix notation: *+AB-CD 
	 * to postfix notation: AB+CD-* 
	 * @param input
	 * @return
	 */
	public String convertPrefixToPostfix(String input) {
		
		StringBuilder strBuilder = new StringBuilder(input.length());
		
		Stack<Character> stack = new Stack<>();
		
		//Parse the string
		//Assume that character is either operator or operand
		boolean inExpression=false;
		for(int i=0;i<input.length();i++) {
			Character ch=input.charAt(i);
			if(isOperator(ch) && !inExpression) {
				stack.push(ch);
			} else {
				
			}
		}
		
		
		return strBuilder.toString();
	}
	
	private boolean isOperator(Character c) {
		return c == '+'||c =='-'||c=='*'||c=='/';
	}
	
	private boolean isOperand(Character c) {
		return Character.isLetter(c);
	}
}
