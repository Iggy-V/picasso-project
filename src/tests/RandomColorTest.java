
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.RandomColor;
import picasso.parser.tokens.functions.RandomToken;

public class RandomColorTest  {
	
	@Test
	public void TestRandomTokenDescription() {
		RandomToken token = new RandomToken();
		assertEquals(token.toString(), "Random Function Token");
	}
	
	@Test
	public void testRandomTokenFunction() {
		RandomToken token = new RandomToken();
		assertTrue(token.isFunction()== true);
	}
	
	@Test
	public void testRandomTokenNotConstant() {
		RandomToken token = new RandomToken();
		assertTrue(token.isConstant()== false);
	}
}
