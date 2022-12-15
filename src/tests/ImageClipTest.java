package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.ImageClip;
import picasso.parser.tokens.functions.ImageClipToken;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.language.expressions.Image;

public class ImageClipTest {
	
	@Test
	public void TestImageClipTokenDescription() {
		ImageClipToken token = new ImageClipToken();
		assertEquals(token.toString(), "ImageClip Function Token");
	}
	
	@Test
	public void testImageClipTokenFunction() {
		ImageClipToken token = new ImageClipToken();
		assertTrue(token.isFunction()== true);
	}
	
	@Test
	public void testImageClipTokenNotConstant() {
		ImageClipToken token = new ImageClipToken();
		assertTrue(token.isConstant()== false);
	}
	
	@Test
	public void testImageCLipEvaluation() {
		ImageClip myTree = new ImageClip(new Image("vortex.jpg"), new X(), new Y());
		
		assertEquals(new RGBColor(-6, -6, -6), myTree.evaluate(-1, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(6, 6, 6), myTree.evaluate(1, -1));
		
		for(int i=-1; i<=1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}
		
		double[] tests = {7, -10, 100, -.5};
		
		for (double testVal : tests) {
			if(testVal>1) {
				double clampOfTestVal = 1;
				assertEquals(new RGBColor(clampOfTestVal, clampOfTestVal, clampOfTestVal), myTree.evaluate(1, -1));
			}
			if(testVal<-1) {
				double clampOfTestVal = -1;
				assertEquals(new RGBColor(clampOfTestVal, clampOfTestVal, clampOfTestVal), myTree.evaluate(-1, -1));
			}
			else {
				double clampOfTestVal = testVal;
				assertEquals(new RGBColor(clampOfTestVal, clampOfTestVal, clampOfTestVal), myTree.evaluate(testVal, -1));
			}
		}
	}
}