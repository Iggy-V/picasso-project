package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Equals;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.EqualsToken;


public class AssignmentTests {
	
	String testVar = new String("a");
	X x = new X();
	Y y = new Y();

	@Test
	public void testEqualsTokenFunction() {
		EqualsToken token = new EqualsToken();
		assertTrue(token.isFunction()== false);
	}
	@Test
	public void testEqualsTokenNotConstant() {
		EqualsToken token = new EqualsToken();
		assertTrue(token.isConstant()== false);
	}
	@Test
	public void testEqualsEvaluation() {
		Equals myTree = new Equals(testVar, x);

		// some straightforward tests
		assertEquals(new RGBColor(0.3, 0.3, 0.3), myTree.evaluate(.3, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, -1));

		}
	}
	