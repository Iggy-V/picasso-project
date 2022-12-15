package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.Clamp;
import picasso.parser.tokens.functions.ClampToken;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

public class ClampTest {
	
	@Test
	public void TestClampTokenDescription() {
		ClampToken token = new ClampToken();
		assertEquals(token.toString(), "Clamp Function Token");
	}
	
	@Test
	public void testClampTokenFunction() {
		ClampToken token = new ClampToken();
		assertTrue(token.isFunction()== true);
	}
	
	@Test
	public void testClampTokenNotConstant() {
		ClampToken token = new ClampToken();
		assertTrue(token.isConstant()== false);
	}
	
	@Test
	public void testClampEvaluation() {
		Clamp myTree = new Clamp(new X());
		
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