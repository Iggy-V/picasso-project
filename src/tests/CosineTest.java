package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Cosine;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.tokens.functions.CosToken;

public class CosineTest {
	
	@Test
	public void testCosineTokenDescription() {
		CosToken token = new CosToken();
		assertEquals(token.toString(),"Cosine Function Token");
	}
	@Test
	public void testCosineTokenFunction() {
		CosToken token = new CosToken();
		assertTrue(token.isFunction()== true);
	}
	@Test
	public void testCosineTokenNotConstant() {
		CosToken token = new CosToken();
		assertTrue(token.isConstant()== false);
	}
	@Test
	public void testCosEvaluation() {
		Cosine myTree = new Cosine(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.cos(0.6), Math.cos(0.6), Math.cos(0.6)), myTree.evaluate(.6, -1));
		assertEquals(new RGBColor(Math.cos(0), Math.cos(0), Math.cos(0)), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(Math.cos(-1), Math.cos(-1), Math.cos(-1)), myTree.evaluate(-1, -1));

		// test the ints
		for(int i=-1;i<=1;i++){
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double cosOfTestVal = Math.cos(testVal);
			assertEquals(new RGBColor(cosOfTestVal, cosOfTestVal, cosOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(cosOfTestVal, cosOfTestVal, cosOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
	
	
}