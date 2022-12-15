package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.Ceil;
import picasso.parser.tokens.functions.CeilToken;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

public class CeilTest {
	
	@Test
	public void TestCeilTokenDescription() {
		CeilToken token = new CeilToken();
		assertEquals(token.toString(), "Ceiling Function Token");
	}
	
	@Test
	public void testCeilTokenFunction() {
		CeilToken token = new CeilToken();
		assertTrue(token.isFunction()== true);
	}
	
	@Test
	public void testCeilTokenNotConstant() {
		CeilToken token = new CeilToken();
		assertTrue(token.isConstant()== false);
	}
	
	@Test
	public void testCeilEvaluation() {
		Ceil myTree = new Ceil(new X());
		
		assertEquals(new RGBColor(Math.ceil(0.6), Math.ceil(0.6), Math.ceil(0.6)), myTree.evaluate(1, -1));
		assertEquals(new RGBColor(Math.ceil(0), Math.ceil(0), Math.ceil(0)), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(Math.ceil(-0.6), Math.ceil(-0.6), Math.ceil(-0.6)), myTree.evaluate(0, -1));
		
		for(int i=-1; i<=1; i++) {
			assertEquals(new RGBColor(Math.ceil(i), Math.ceil(i), Math.ceil(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.ceil(i), Math.ceil(i), Math.ceil(i)), myTree.evaluate(i, i));
		}
		
		double[] tests = {-.7, -.00001, -.000001, .5 };
		
		for (double testVal : tests) {
			double ceilOfTestVal = Math.ceil(testVal);
			if( testVal < 0 ) {
				assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(0, -1));
			}
			else {
				assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(1, -1));
			}
		}
	}
}