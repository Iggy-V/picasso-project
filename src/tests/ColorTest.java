package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.RGBColor;
import picasso.parser.tokens.ColorToken;

public class ColorTest {
	
	@Test
	public void testColorTokenDescription() {
		ColorToken token = new ColorToken(-1, -1, -1);
		assertEquals(token.toString(),"Color Token");
	}
	@Test
	public void testColorTokenFunction() {
		ColorToken token = new ColorToken(0,0,0);
		assertTrue(token.isFunction()== false);
	}
	@Test
	public void testColorTokenConstant() {
		ColorToken token = new ColorToken(1,1,1);
		assertTrue(token.isConstant()== true);
	}
	
	@Test
	public void testGetters() {
		RGBColor color = new RGBColor(-1,0,1);
		assertEquals(color.getRed(), -1);
		assertEquals(color.getGreen(), 0);
		assertEquals(color.getBlue(), 1);
	}
}