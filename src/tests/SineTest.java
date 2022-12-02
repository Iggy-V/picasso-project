package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import picasso.parser.tokens.functions.SinToken;

public class SineTest {
	
	@Test
	public void testSinTokenDescription() {
		SinToken token = new SinToken();
		assertEquals(token.toString(),"Sine Function Token");
	}
	@Test
	public void testSinTokenFunction() {
		SinToken token = new SinToken();
		assertTrue(token.isFunction()== true);
	}
	@Test
	public void testSinTokenNotConstant() {
		SinToken token = new SinToken();
		assertTrue(token.isConstant()== false);
	}
	
	
}
