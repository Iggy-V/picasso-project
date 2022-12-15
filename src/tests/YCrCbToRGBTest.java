package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.YCrCbToRGB;
import picasso.parser.language.expressions.X;
import picasso.parser.tokens.functions.YCrCbToRGBToken;
/**
 * Tests for YCrCbToRGB function
 * @author Joe Condie
 *
 */
public class YCrCbToRGBTest {
	
	@Test
	public void testYCrCbToRGBTokenDescription() {
		YCrCbToRGBToken token = new YCrCbToRGBToken();
		assertEquals(token.toString(),"YCrCbToRGB Function Token");
	}
	@Test
	public void testYCrCbToRGBTokenFunction() {
		YCrCbToRGBToken token = new YCrCbToRGBToken();
		assertTrue(token.isFunction()== true);
	}
	@Test
	public void testYCrCbToRGBTokenNotConstant() {
		YCrCbToRGBToken token = new YCrCbToRGBToken();
		assertTrue(token.isConstant()== false);
	}
	@Test
	public void testYCrCbToRGBEvaluation() {
		YCrCbToRGB myTree = new YCrCbToRGB(new X());

		// some straightforward tests
		assertEquals(new RGBColor((0.6 + 0.6* 1.4022),(0.6 + 0.6 * -0.3456 + 0.6 * -0.7145), 
				(0.6 + 0.6 * 1.7710)), myTree.evaluate(.6, -1));
		
		assertEquals(new RGBColor((1 + 1* 1.4022),(1 + 1 * -0.3456 + 1 * -0.7145), 
				(1 + 1 * 1.7710)), myTree.evaluate(1, -1));
		
		assertEquals(new RGBColor((-1 + -1 * 1.4022),(-1 + -1 * -0.3456 + -1 * -0.7145), 
				(-1 + -1 * 1.7710)), myTree.evaluate(-1, 1));

	// test the ints
			for(int i=-1;i<=1;i++){
				assertEquals(new RGBColor((i + i* 1.4022),(i + i * -0.3456 + i * -0.7145), 
						(i + i * 1.7710)), myTree.evaluate(i, -1));
				assertEquals(new RGBColor((i + i* 1.4022),(i + i * -0.3456 + i * -0.7145), 
						(i + i * 1.7710)), myTree.evaluate(i, i));

			}
	}
	
}