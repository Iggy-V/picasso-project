package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//import picasso.model.ImprovedNoise;
//import picasso.parser.language.expressions.RGBColor;
//import picasso.parser.language.expressions.X;
//import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.functions.PerlinBWToken;

public class PerlinBWTest {
	
	@Test
	public void testPerlinBWTokenDescription() {
		PerlinBWToken token = new PerlinBWToken();
		assertEquals(token.toString(),"PerlinBW Function Token");
	}
	@Test
	public void testPerlinBWTokenFunction() {
		PerlinBWToken token = new PerlinBWToken();
		assertTrue(token.isFunction()== true);
	}
	@Test
	public void testPerlinBWTokenNotConstant() {
		PerlinBWToken token = new PerlinBWToken();
		assertTrue(token.isConstant()== false);
	}

}