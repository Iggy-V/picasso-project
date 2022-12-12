package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.ImageWrap;
import picasso.parser.tokens.functions.ImageWrapToken;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.language.expressions.Image;

public class ImageWrapTest {
	
	@Test
	public void TestImageWrapTokenDescription() {
		ImageWrapToken token = new ImageWrapToken();
		assertEquals(token.toString(), "ImageWrap Function Token");
	}
	
	@Test
	public void testImageWrapTokenFunction() {
		ImageWrapToken token = new ImageWrapToken();
		assertTrue(token.isFunction()== true);
	}
	
	@Test
	public void testImageWrapTokenNotConstant() {
		ImageWrapToken token = new ImageWrapToken();
		assertTrue(token.isConstant()== false);
	}
	
	@Test
	public void testImageWrapEvaluation() {
		ImageWrap myTree = new ImageWrap(new Image("vortex.jpg"), new X(), new Y());
		
		assertEquals(new RGBColor(-2, -2, -2), myTree.evaluate(1, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(2, 2, 2), myTree.evaluate(-1, -1));
		
		for(int i=-1; i<=1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}
		
		double[] tests = {1.1, -1.1, 1.5, -.5};
		
		for (double testVal : tests) {
			if(testVal>1) {
				double difference = testVal - 1;
				double wrapOfTestVal = -1 + difference;
				assertEquals(new RGBColor(wrapOfTestVal, wrapOfTestVal, wrapOfTestVal), myTree.evaluate(wrapOfTestVal, -1));
			}
			if(testVal<-1) {
				double difference = -1 - testVal;
				double wrapOfTestVal = 1 - difference;
				assertEquals(new RGBColor(wrapOfTestVal, wrapOfTestVal, wrapOfTestVal), myTree.evaluate(wrapOfTestVal, -1));
			}
			else {
				double wrapOfTestVal = testVal;
				assertEquals(new RGBColor(wrapOfTestVal, wrapOfTestVal, wrapOfTestVal), myTree.evaluate(wrapOfTestVal, -1));
			}
		}
	}
}