/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of the evaluation of x
 * 
 * @author Sara Sprenkle
 * 
 * 
 */
public class EvaluatorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = new RGBColor(1, -1, 1);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}

	@Test
	public void testFloorEvaluation() {
		Floor myTree = new Floor(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double floorOfTestVal = Math.floor(testVal);
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}


	@Test
	public void testCosEvaluation() {
		Cosine myTree = new Cosine(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.cos(0.6), Math.cos(0.6), Math.cos(0.6)), myTree.evaluate(.6, -1));
		assertEquals(new RGBColor(Math.cos(0), Math.cos(0), Math.cos(0)), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(Math.cos(-1), Math.cos(-1), Math.cos(-1)), myTree.evaluate(-1, -1));

		// test the ints; remember that y's value doesn't matter
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
	@Test
	public void testAdditionEvaluation() {
		Addition myTree = new Addition(new X(), new Y());

		// some straightforward tests
		assertEquals(new RGBColor(0.6 + (-1), 0.6 + (-1), 0.6 + (-1)), myTree.evaluate(.6, -1));
		assertEquals(new RGBColor(0 + (-1), 0 + (-1), 0 + (-1)), myTree.evaluate(0, -1));
		assertEquals(new RGBColor((-0.3 + 1), (-0.3 + 1), (-0.3 + 1)), myTree.evaluate(-0.3, 1));
		
		// test the ints
		for(int i=-1;i<=1;i++){
			assertEquals(new RGBColor(i+(-i), i+(-i), i+(-i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i+i, i+i, i+i), myTree.evaluate(i, i));
		}

	}

	@Test
	public void testSinEvaluation() {
		Sin myTree = new Sin(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.sin(0.6), Math.sin(0.6), Math.sin(0.6)), myTree.evaluate(.6, -1));
		assertEquals(new RGBColor(Math.sin(0), Math.sin(0), Math.sin(0)), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(Math.sin(-1), Math.sin(-1), Math.sin(-1)), myTree.evaluate(-1, -1));

		// test the ints
		for(int i=-1;i<=1;i++){
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double sinOfTestVal = Math.sin(testVal);
			assertEquals(new RGBColor(sinOfTestVal, sinOfTestVal, sinOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(sinOfTestVal, sinOfTestVal, sinOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
	@Test
	public void testCeilEvaluation() {
		Ceil myTree = new Ceil(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.ceil(0.6), Math.ceil(0.6), Math.ceil(0.6)), myTree.evaluate(.6, -1));
		assertEquals(new RGBColor(Math.ceil(0), Math.ceil(0), Math.ceil(0)), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(Math.ceil(-1), Math.ceil(-1), Math.ceil(-1)), myTree.evaluate(-1, -1));

		// test the ints
		for(int i=-1;i<=1;i++){
			assertEquals(new RGBColor(Math.ceil(i), Math.ceil(i), Math.ceil(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.ceil(i), Math.ceil(i), Math.ceil(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };


		for (double testVal : tests) {
			double ceilOfTestVal = Math.ceil(testVal);
			assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
	
	@Test
	public void testAdditionEvaluation() {
		Addition myTree = new Addition(new X(), new Y());

		// some straightforward tests
		assertEquals(new RGBColor(0.6 + (-1), 0.6 + (-1), 0.6 + (-1)), myTree.evaluate(.6, -1));
		assertEquals(new RGBColor(0 + (-1), 0 + (-1), 0 + (-1)), myTree.evaluate(0, -1));
		assertEquals(new RGBColor((-0.3 + 1), (-0.3 + 1), (-0.3 + 1)), myTree.evaluate(-0.3, 1));
		
		// test the ints
		for(int i=-1;i<=1;i++){
			assertEquals(new RGBColor(i+(-i), i+(-i), i+(-i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i+i, i+i, i+i), myTree.evaluate(i, i));
		}

	}
}
