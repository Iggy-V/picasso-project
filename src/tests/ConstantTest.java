package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Constant;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.tokens.NumberToken;

public class ConstantTest {
	
	@Test
	public void testConstantTokenDescription() {
		NumberToken token = new NumberToken(1);
		assertEquals(token.toString(),"Number Token");
	}
	@Test
	public void testConstantTokenFunction() {
		NumberToken token = new NumberToken(0);
		assertTrue(token.isFunction()== false);
	}
	@Test
	public void testConstantTokenConstant() {
		NumberToken token = new NumberToken(2);
		assertTrue(token.isConstant()== true);
	}
	@Test
	public void testConstantMethods() {
		Constant number = new Constant(0);
		assertEquals(number.value(), number);
		
		assertTrue(number.toString().equals("Constant: " + number));
		
		assertEquals(number.evaluate(0, 0), new RGBColor(number.value(), number.value(), number.value()));
	}
	
	
}