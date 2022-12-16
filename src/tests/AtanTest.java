package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.ArcTan;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.tokens.functions.AtanToken;

public class AtanTest {
	
	@Test
	public void testAtanTokenDescription() {
		AtanToken token = new AtanToken();
		assertEquals(token.toString(),"arc tan Function Token");
	}
	@Test
	public void testAtanTokenFunction() {
		AtanToken token = new AtanToken();
		assertTrue(token.isFunction()== true);
	}
	@Test
	public void testAtanTokenNotConstant() {
		AtanToken token = new AtanToken();
		assertTrue(token.isConstant()== false);
	}
	@Test
	public void testAtanEvaluation() {
		ArcTan myTree = new ArcTan(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.atan(0.6), Math.atan(0.6), Math.atan(0.6)), myTree.evaluate(.6, -1));
		assertEquals(new RGBColor(Math.atan(0), Math.atan(0), Math.atan(0)), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(Math.atan(-1), Math.atan(-1), Math.atan(-1)), myTree.evaluate(-1, -1));

		// test the ints
		for(int i=-1;i<=1;i++){
			assertEquals(new RGBColor(Math.atan(i), Math.atan(i), Math.atan(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.atan(i), Math.atan(i), Math.atan(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double aTanOfTestVal = Math.atan(testVal);
			assertEquals(new RGBColor(aTanOfTestVal, aTanOfTestVal, aTanOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(aTanOfTestVal, aTanOfTestVal, aTanOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
	
	
}