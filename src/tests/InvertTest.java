package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import picasso.parser.language.expressions.Invert;
import picasso.parser.tokens.functions.InvertToken;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

public class InvertTest {
	
	@Test
	public void TestInvertTokenDescription() {
		InvertToken token = new InvertToken();
		assertEquals(token.toString(), "! Function Token");
	}
	
	@Test
	public void testInvertTokenFunction() {
		InvertToken token = new InvertToken();
		assertTrue(token.isFunction()== true);
	}
	
	@Test
	public void testInvertTokenNotConstant() {
		InvertToken token = new InvertToken();
		assertTrue(token.isConstant()== false);
	}
	
	@Test
	public void testInvertEvaluation() {
		Invert myTree = new Invert(new X());
		
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(1, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(-1, -1));
		
		for(int i=-1; i<=1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(-i, -i));
			assertEquals(new RGBColor(-i, -i, -i), myTree.evaluate(i, i));
		}
		
		double[] tests = {1, -1, .5, -.5};
		
		for (double testVal : tests) {
			assertEquals(new RGBColor(testVal, testVal, testVal), myTree.evaluate(-1*testVal, -1));
		}
	}
}
