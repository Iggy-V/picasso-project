package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import picasso.parser.tokens.ImageToken;

public class ImageTest {
	
	@Test
	public void TestImageTokenDescription() {
		ImageToken token = new ImageToken("vortex.jpg");
		assertEquals(token.toString(), "Image Token");
	}
	
	@Test
	public void testImageTokenFunction() {
		ImageToken token = new ImageToken("vortex.jpg");
		assertTrue(token.isFunction()== false);
	}
	
	@Test
	public void testImageTokenNotConstant() {
		ImageToken token = new ImageToken("vortex.jpg");
		assertTrue(token.isConstant()== false);
	}
}