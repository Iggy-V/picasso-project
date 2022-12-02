package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Cosine;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.tokens.functions.CosToken;

public class AbsValueTest {
	
	@Test
	public void testAbsTokenDescription() {
		AbsToken token = new AbsToken();
		assertEquals(token.toString(),"Cosine Function Token");
	}
	@Test
	public void testAbsTokenFunction() {
		AbsToken token = new AbsToken();
		assertTrue(token.isFunction()== true);
	}
	@Test
	public void testAbsTokenNotConstant() {
		AbsToken token = new AbsToken();
		assertTrue(token.isConstant()== false);
	}
	@Test
	public void testAbsEvaluation() {
		Absolute myTree = new Absolute(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.abs(0.6), Math.abs(0.6), Math.abs(0.6)), myTree.evaluate(.6, -1));
		assertEquals(new RGBColor(Math.abs(0), Math.abs(0), Math.abs(0)), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(Math.abs(-1), Math.abs(-1), Math.abs(-1)), myTree.evaluate(-1, -1));

		// test the ints
		for(int i=-1;i<=1;i++){
			assertEquals(new RGBColor(Math.abs(i), Math.abs(i), Math.abs(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.abs(i), Math.abs(i), Math.abs(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double absOfTestVal = Math.abs(testVal);
			assertEquals(new RGBColor(absOfTestVal, absOfTestVal, absOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(absOfTestVal, absOfTestVal, absOfTestVal),
					myTree.evaluate(testVal, testVal));
			
		}
	}
	
	
}