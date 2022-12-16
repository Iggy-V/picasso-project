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
import picasso.parser.language.expressions.Module;

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
	public void testDivisionEvaluation() {
		Division myTree = new Division(new X(), new Y());
		
		assertEquals(new RGBColor(0.6 / 2, 0.6 / 2, 0.6 / 2), myTree.evaluate(.6, 0));
		assertEquals(new RGBColor(-1 / 3, -1 / 3, -1 / 3), myTree.evaluate(-1, 0));
		assertEquals(new RGBColor(-.3 / 10, -.3 / 10, -.3 / 10), myTree.evaluate(-.3, 0));
		
		for( int i = -1; i<=1; i++ ) {
			assertEquals(new RGBColor(i / i, i / i, i / i), myTree.evaluate(i, -1));
			assertEquals(new RGBColor(-i / i, -i / i, -i / i), myTree.evaluate(i, -i));
		}
	}
	
	@Test
	public void testExpEvaluation() {
		Exp myTree = new Exp(new X());
		
		assertEquals(new RGBColor(Math.exp(0.6), Math.exp(0.6), Math.exp(0.6)), myTree.evaluate(0.6, 1));
		assertEquals(new RGBColor(Math.exp(-1), Math.exp(-1), Math.exp(-1)), myTree.evaluate(-1, 1));
		assertEquals(new RGBColor(Math.exp(0.3), Math.exp(0.3), Math.exp(0.3)), myTree.evaluate(0.3, 0));
		
		for(int i=-1;i<=1;i++) {
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), myTree.evaluate(i, i));
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), myTree.evaluate(i, 0));
		}
		
		double[] tests = {-.7, -.0001, .000001, .5 };
		
		for( double testVal : tests) {
			double expOfTestVal = Math.exp(testVal);
			
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(testVal, testVal));
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(testVal, -1));
		}
	}
	
	@Test
	public void testExponentiateEvaluation() {
		Exponentiate myTree = new Exponentiate(new X(), new Y());
		
		assertEquals(new RGBColor(Math.pow(0.6, 2), Math.pow(0.6, 2), Math.pow(0.6, 2)), myTree.evaluate(0.6, 0));
		assertEquals(new RGBColor(Math.pow(0.4, 3), Math.pow(0.4, 3), Math.pow(0.4, 3)), myTree.evaluate(0.4, -1));
		assertEquals(new RGBColor(Math.pow(0.7, 0.5), Math.pow(0.7, 0.5), Math.pow(0.7, 0.5)), myTree.evaluate(0.7, 1));
		
		for(int i=-1;i<=1;i++) {
			assertEquals(new RGBColor(Math.pow(i, i), Math.pow(i, i), Math.pow(i, i)), myTree.evaluate(i, i));
			assertEquals(new RGBColor(Math.pow(i, -i), Math.pow(i, -i), Math.pow(i, -i)), myTree.evaluate(i, -i));
		}
	}
	
	@Test
	public void testLogEvaluation() {
		Logorithm myTree = new Logorithm(new X());
		
		assertEquals(new RGBColor(Math.log(1), Math.log(1), Math.log(1)), myTree.evaluate(1, 0));
		assertEquals(new RGBColor(Math.log(0.6), Math.log(0.6), Math.log(0.6)), myTree.evaluate(0.6, -1));
		assertEquals(new RGBColor(Math.log(-0.3), Math.log(-0.3), Math.log(-0.3)), myTree.evaluate(-0.3, 1));
	
		for(int i=-1;i<=1;i++) {
			assertEquals(new RGBColor(Math.log(i), Math.log(i), Math.log(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.log(-i), Math.log(-i), Math.log(-i)), myTree.evaluate(-i, i));
		}
		
		double tests[] = {-.7, -.00001, .000001, .5 };
		
		for( double testVal : tests) {
			double logOfTestVal = Math.log(testVal);
			
			assertEquals(new RGBColor(logOfTestVal, logOfTestVal, logOfTestVal), myTree.evaluate(testVal, 1));
			assertEquals(new RGBColor(logOfTestVal, logOfTestVal, logOfTestVal), myTree.evaluate(testVal, -1));
		}
	}
	
	@Test
	public void testModuloEvaluation() {
		Module myTree = new Module(new X(), new Y());
		
		assertEquals(new RGBColor(4 % 3, 4 % 3, 4 % 3), myTree.evaluate(4, -1));
		assertEquals(new RGBColor(5 % 4, 5 % 4, 5 % 4), myTree.evaluate(5, 0));
		assertEquals(new RGBColor(6 % 5, 6 % 5, 6 % 5), myTree.evaluate(6, 1));
	}
	
	@Test
	public void testTanEvaluation() {
		Tangent myTree = new Tangent(new X());
		
		assertEquals(new RGBColor(Math.tan(0.6), Math.tan(0.6), Math.tan(0.6)), myTree.evaluate(0.6, 0));
		assertEquals(new RGBColor(Math.tan(0), Math.tan(0), Math.tan(0)), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(Math.tan(-0.3), Math.tan(-0.3), Math.tan(-0.3)), myTree.evaluate(-0.3, 1));
	
		for(int i=-1;i<=1;i++) {
			assertEquals(new RGBColor(Math.tan(i), Math.tan(i), Math.tan(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.tan(-i), Math.tan(-i), Math.tan(-i)), myTree.evaluate(-i, i));
		}
		
		double tests[] = {-.7, -.00001, .000001, .5 };
		
		for( double testVal : tests) {
			double tanOfTestVal = Math.log(testVal);
			
			assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal), myTree.evaluate(testVal, 1));
			assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal), myTree.evaluate(testVal, -1));
		}
	}
}
