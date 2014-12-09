package serie2;

public class Utils {
	public static int evaluateRPN(String expression) {
		final String SEPARATOR = " ";
		char c;
		SLinkedList<Integer> stack = new SLinkedList<Integer>();
		
		String[] operands =expression.split(SEPARATOR);
		
		if (operands.length == 0)
			return 0;
		
		if (operands.length == 1)
			try {
				return Integer.parseInt(operands[0]);
			} catch (Exception e) {
				return 0;
			}
		
		for (String s: operands){
			try {
				stack.push(Integer.parseInt(s));
			} catch (Exception e ) {
				handleOperation(stack , s.charAt(0));
			}
		}
		
		if (stack.size > 1)
			throw new IllegalArgumentException();
		return stack.pop();
	}
	
	
	private static void handleOperation(SLinkedList<Integer> stack, char c) {

		Integer b = stack.pop();
		Integer a = stack.pop();
		
		if (a== null || b== null )
			throw new IllegalArgumentException();
		
		switch (c){
			case '*': stack.push(a*b);break;
			case '/': {
				if (b==0)
					throw new ArithmeticException();
				stack.push(a/b);
				break;
			}
			case '+': stack.push(a+b);break;
			case '-': stack.push(a-b);break;
			default : throw new IllegalArgumentException();
		}


		
	}
}


