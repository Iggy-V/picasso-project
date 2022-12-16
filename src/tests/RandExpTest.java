package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.tokens.functions.RandExpToken;


public class RandExpTest  {
	
	@Test
	public void TestRandExpTokenDescription() {
		RandExpToken token = new RandExpToken();
		assertEquals(token.toString(), "RandExp Function Token");
	}
	
	@Test
	public void testRandExpTokenFunction() {
		RandExpToken token = new RandExpToken();
		assertTrue(token.isFunction()== true);
	}
	
	@Test
	public void testRandExpTokenNotConstant() {
		RandExpToken token = new RandExpToken();
		assertTrue(token.isConstant()== false);
	}
}
