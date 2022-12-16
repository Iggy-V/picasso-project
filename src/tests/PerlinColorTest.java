package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//import picasso.model.ImprovedNoise;
//import picasso.parser.language.expressions.PerlinColor;
//import picasso.parser.language.expressions.RGBColor;
//import picasso.parser.language.expressions.X;
//import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.functions.PerlinColorToken;

public class PerlinColorTest {
	
	@Test
	public void testPerlinColorTokenDescription() {
		PerlinColorToken token = new PerlinColorToken();
		assertEquals(token.toString(),"PerlinColor Function Token");
	}
	@Test
	public void testPerlinColorTokenFunction() {
		PerlinColorToken token = new PerlinColorToken();
		assertTrue(token.isFunction()== true);
	}
	@Test
	public void testPerlinColorTokenNotConstant() {
		PerlinColorToken token = new PerlinColorToken();
		assertTrue(token.isConstant()== false);
	}

}
