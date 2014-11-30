package serie2;
import static org.junit.Assert.*;
import static serie2.Utils.evaluateRPN;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EvaluateRPNTest{

		@Rule
		public ExpectedException exception = ExpectedException.none();
		
		@Test
		public void calculate_empty_String() {	
			assertEquals(0, evaluateRPN(""));
		}
		
		@Test
		public void calculate_spaces_String() {
			assertEquals(0, evaluateRPN("       "));
		}
		
		@Test
		public void  calculate_only_a_single_operand() {		
			assertEquals(0, evaluateRPN("0") );
			assertEquals(200, evaluateRPN("200") );
		}
		
	@Test
		public void  calculate_only_operands() {
		exception.expect(IllegalArgumentException.class);
			assertEquals(0, evaluateRPN("1 2") );
			assertEquals(0, evaluateRPN("1 2 3") );
			assertEquals(0, evaluateRPN("2 1") );
			assertEquals(0, evaluateRPN("3 2 1") );
		}
	
		@Test
		public void  calculate_only_operations() {
			exception.expect(IllegalArgumentException.class);
			assertEquals(0, evaluateRPN("*") );
			assertEquals(0, evaluateRPN("* +") );
			assertEquals(0, evaluateRPN("* + -") );
		}
		
		@Test
		public void  calculate_missing_operands() {
			exception.expect(IllegalArgumentException.class);
			assertEquals(0, evaluateRPN("1 *") );
			assertEquals(0, evaluateRPN("1 2 * +") );
			assertEquals(0, evaluateRPN("1 2 3 * + -") );
			assertEquals(0, evaluateRPN("1 2 3 4 * + - /") );
		}
	
		@Test
		public void  calculate_divide_by_zero() {
			exception.expect(ArithmeticException.class);
			assertEquals(0, evaluateRPN("1 0 /") );
			assertEquals(0, evaluateRPN("4 2 2 - /") );
		}
		
		@Test
		public void  calculate_illegal_expressions() {
			exception.expect(IllegalArgumentException.class);
			assertEquals(0, evaluateRPN("1 a") );
			assertEquals(0, evaluateRPN("1l 22 +") );
			assertEquals(0, evaluateRPN("1 x 1 * + -") );
			assertEquals(0, evaluateRPN("1 2 p 4 5 * + - /") );
		}
		
		@Test
		public void  calculate_legal_expressions() {
			assertEquals(3, evaluateRPN("1 2 +") );
			assertEquals(6, evaluateRPN("1 2 3 + +") );
			assertEquals(-1, evaluateRPN("1 2 -") );
			assertEquals(1, evaluateRPN("2 1 -") );
			assertEquals(2, evaluateRPN("3 2 1 - -") );
			assertEquals(2, evaluateRPN("1 2 *") );
			assertEquals(6, evaluateRPN("1 2 3 * *") );
			assertEquals(0, evaluateRPN("1 2 /") );
			assertEquals(2, evaluateRPN("2 1 /") );
			assertEquals(2, evaluateRPN("4 2 1 / /") );
			assertEquals(6, evaluateRPN("1 3 4 * 2 / + 1 -") );
			assertEquals(2075, evaluateRPN("5 9 8 + 4 6 * * 7 + *") );
		}
		
		
}
