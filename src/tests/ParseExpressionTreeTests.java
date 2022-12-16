package tests;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.language.expressions.Module;

/**
 * Tests of creating an expression tree from a string expression. Will have
 * compiler errors until some code is created.
 * 
 * @author Sara Sprenkle
 * 
 */
public class ParseExpressionTreeTests {

	private ExpressionTreeGenerator parser;

	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void constantExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("[1,-1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
	}

	@Test
	public void variableExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x");
		assertEquals(new X(), e);
	}
	
	@Test
	public void orderofOpTest() {
		ExpressionTreeNode e = parser.makeExpression("x + y * x");
		assertEquals(new Addition(new X(), new Multiplication(new Y(), new Y())), e);
		
		e = parser.makeExpression("x * y - y");
		assertEquals(new Subtraction(new Multiplication(new X(), new Y()), new Y()), e);
	
	}

	@Test
	public void additionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x + y");
		assertEquals(new Addition(new X(), new Y()), e);
		
		ExpressionTreeNode e1 = parser.makeExpression("x+y");
		assertEquals(new Addition(new X(), new Y()), e1);

		e1 = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Addition(new RGBColor(1, .3, -1), new Y()), e1);
		
		e1 = parser.makeExpression("x + y + [ -.51, 0, 1]");
		assertEquals(new Addition(new Addition(new X(), new Y()), new RGBColor(-.51, 0, 1)), e1);
	}
	
	@Test
	public void subtractionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x - y");
		assertEquals(new Subtraction(new X(), new Y()), e);
		
		ExpressionTreeNode e1 = parser.makeExpression("x-y");
		assertEquals(new Subtraction(new X(), new Y()), e1);

		e1 = parser.makeExpression("[1,.3,-1] - y");
		assertEquals(new Subtraction(new RGBColor(1, .3, -1), new Y()), e1);
		
		e1 = parser.makeExpression("x - y - [ -.51, 0, 1]");
		assertEquals(new Subtraction(new Subtraction(new X(), new Y()), new RGBColor(-.51, 0, 1)), e1);
	}
	
	@Test
	public void multiplicationExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x * y");
		assertEquals(new Multiplication(new X(), new Y()), e);
		
		ExpressionTreeNode e1 = parser.makeExpression("x*y");
		assertEquals(new Multiplication(new X(), new Y()), e1);

		e1 = parser.makeExpression("[1,.3,-1] * y");
		assertEquals(new Multiplication(new RGBColor(1, .3, -1), new Y()), e1);
		
		e1 = parser.makeExpression("x * y * [ -.51, 0, 1]");
		assertEquals(new Multiplication(new Multiplication(new X(), new Y()), new RGBColor(-.51, 0, 1)), e1);
	}

	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("( x + y )");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		assertEquals(new Addition(new X(), new Addition(new Y(), new RGBColor(1, 1, 1))), e);
	}

	@Test
	public void floorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("floor( x )");
		assertEquals(new Floor(new X()), e);

		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Floor(new Addition(new X(), new Y())), e);
	}
	@Test
	public void cosFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("cos( x )");
		assertEquals(new Cosine(new X()), e);
		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Cosine(new Addition(new X(), new Y())), e);
	}

	@Test
	public void sinFunctionTests(){
		ExpressionTreeNode e = parser.makeExpression("sin( x )");
		assertEquals(new Sin(new X()), e);

		e = parser.makeExpression("sin( x + y )");
		assertEquals(new Sin(new Addition(new X(), new Y())), e);
	}

	@Test
	public void absFunctionTests(){
		ExpressionTreeNode e = parser.makeExpression("abs( x )");
		assertEquals(new Absolute(new X()), e);

		e = parser.makeExpression("abs(x+y)");
		assertEquals(new Absolute(new Addition(new X(), new Y())), e);
	}

	@Test
	public void RGBToYCrCbFunctionTests(){
		ExpressionTreeNode e = parser.makeExpression("RGBToYCrCb( x )");
		assertEquals(new RGBToYCrCb(new X()), e);
	}
	@Test
	public void YCrCbToRGBFunctionTests(){
		ExpressionTreeNode e = parser.makeExpression("yCrCbToRGB( x )");
		assertEquals(new YCrCbToRGB(new X()), e);
	}
	@Test
	public void exponentialExpressionTest() {
		ExpressionTreeNode e = parser.makeExpression("x^y");
		assertEquals(new Exponentiate(new X(), new Y()), e);
		
		e = parser.makeExpression("[1,.3,-1] ^ y");
		assertEquals(new Exponentiate(new RGBColor(1, .3, -1),new Y()), e);
	}
	@Test
	public void divisionExpressionTest() {
		ExpressionTreeNode e = parser.makeExpression("x/y");
		assertEquals(new Division(new X(), new Y()), e);
		
		ExpressionTreeNode e1 = parser.makeExpression("y/x");
		assertEquals(new Division(new Y(), new X()), e1);
		
		e1 = parser.makeExpression("[1,.3,-1] / y");
		assertEquals(new Division(new RGBColor(1, .3, -1),new Y()), e1);
		
		e1 = parser.makeExpression("x / y / [ -.51, 0, 1]");
		assertEquals(new Division(new Division(new X(), new Y()), new RGBColor(-.51, 0, 1)), e1);
	}
	public void moduleExpressionTest() {
		ExpressionTreeNode e = parser.makeExpression("x%y");
		assertEquals(new Module(new X(), new Y()), e);
		
		ExpressionTreeNode e1 = parser.makeExpression("y%x");
		assertEquals(new Module(new Y(), new X()), e1);
		
		e1 = parser.makeExpression("[1,.3,-1] % y");
		assertEquals(new Module(new RGBColor(1, .3, -1),new Y()), e1);
		
		e1 = parser.makeExpression("x % y % [ -.51, 0, 1]");
		assertEquals(new Module(new Division(new X(), new Y()), new RGBColor(-.51, 0, 1)), e1);
	}
	@Test
	public void tangentFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("tan(x)");
		assertEquals(new Tangent(new X()), e);
		
		e = parser.makeExpression("tan(x+y)");
		assertEquals(new Tangent(new Addition(new X(), new Y())), e);
	}
	@Test
	public void arctanFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("arctan(x)");
		assertEquals(new ArcTan(new X()), e);
		
		e = parser.makeExpression("arctan(y)");
		assertEquals(new ArcTan(new Y()), e);
		
		e = parser.makeExpression("arctan(x+y)");
		assertEquals(new ArcTan(new Addition(new X(), new Y())), e);
	}	
	@Test
	public void expFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("exp(x)");
		assertEquals(new Exp(new X()), e);
		
		e = parser.makeExpression("exp(y)");
		assertEquals(new Exp(new Y()), e);
		
		e = parser.makeExpression("exp(x+y)");
		assertEquals(new Exp(new Addition(new X(), new Y())), e);
	}
	@Test
	public void logFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("log(x)");
		assertEquals(new Logorithm(new X()), e);
		
		e = parser.makeExpression("log(y)");
		assertEquals(new Logorithm(new Y()), e);
		
		e = parser.makeExpression("log(x+y)");
		assertEquals(new Logorithm(new Addition(new X(), new Y())), e);
	}
	@Test
	public void rgbToYCrCbFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("rgbToYCrCb(x)");
		assertEquals(new RGBToYCrCb(new X()), e);
		
		e = parser.makeExpression("rgbToYCrCb(y)");
		assertEquals(new RGBToYCrCb(new Y()), e);
		
		e = parser.makeExpression("rgbToYCrCb(x+y)");
		assertEquals(new RGBToYCrCb(new Addition(new X(), new Y())), e);
	}
	@Test
	public void yCrCbToRGBFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("yCrCbToRGB(x)");
		assertEquals(new YCrCbToRGB (new X()), e);
		
		e = parser.makeExpression("yCrCbToRGB(y)");
		assertEquals(new YCrCbToRGB(new Y()), e);
		
		e = parser.makeExpression("yCrCbToRGB(x+y)");
		assertEquals(new YCrCbToRGB(new Addition(new X(), new Y())), e);
	}
}
