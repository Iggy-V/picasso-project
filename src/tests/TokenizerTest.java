package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ParseException;
import picasso.parser.Tokenizer;
import picasso.parser.tokens.*;
import picasso.parser.tokens.chars.*;
import picasso.parser.tokens.functions.*;
import picasso.parser.tokens.operations.*; // needed to import this for binary operators.

public class TokenizerTest {

	Tokenizer tokenizer;
	List<Token> tokens;

	@BeforeEach
	public void setUp() throws Exception {
		tokenizer = new Tokenizer();
	}
	
	/**
	 * Test that parsing an expression with a comment works
	 */
	@Test
	public void testTokenizeComment() {
		String expression = "x // this is a comment";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(1, tokens.size());
		
		expression = "// everything is a comment";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(0, tokens.size());
	}

	/**
	 * Test that parsing a constant works
	 */
	@Test
	public void testTokenizeConstant() {
		String expression = ".324";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(.324), tokens.get(0));

		expression = "-1";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1), tokens.get(0));

		// No problems here; problem will be in next step (Semantic Analysis)
		expression = "-1.2";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1.2), tokens.get(0));
	}

	@Test
	public void testTokenizeColor() {
		String expression = "[1, 1, 1]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(1, 1, 1), tokens.get(0));

		expression = "[-1, 0, .5]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(-1, 0, .5), tokens.get(0));
	}

	@Test
	public void testTokenizeInvalidColor() {
		String expression = "[1, 1.0001, 1]";

		assertThrows(ParseException.class, () -> {
			tokens = tokenizer.parseTokens(expression);
		});
	}

	@Test
	public void testTokenizeBasicFunctionExpression() {
		String[] expressions = {"floor(x)", "ceil(x)", "sin(x)", "cos(x)", "abs(x)", 
				"RGBToYCrCb(x)", "yCrCbToRGB(x)", "perlinColor(x)", "perlinBW(x)"};
		
		Token[] tokenList = {new FloorToken(), new CeilToken(), new SinToken(), 
				new CosToken(), new AbsToken(), new RGBToYCrCbToken(), new YCrCbToRGBToken(), new PerlinColorToken(), new PerlinBWToken()};

		for(int i=0;i<=expressions.length-1;i++){
		
			//String expression = "floor(x)";
			tokens = tokenizer.parseTokens(expressions[i]);
			assertEquals(tokenList[i], tokens.get(0));
			assertEquals(new LeftParenToken(), tokens.get(1));
			assertEquals(new IdentifierToken("x"), tokens.get(2));
			assertEquals(new RightParenToken(), tokens.get(3));
			
		}
	}
	
	@Test
	public void testTokenizePlusOperatorExpression() {
		String expression = "x+y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new PlusToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
	}
	
	@Test
	public void testTokenizeMinusOperatorExpression() {
		String expression = "x-y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new SubtractionToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
	}
	
	@Test
	public void testTokenizeTimesOperatorExpression() {
		String expression = "x*y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new TimesToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
	}

	@Test
	public void testTokenizeCombinedFunctionExpression() {
		String expression = "perlinColor(floor(x), y)";
		List<Token> tokens = tokenizer.parseTokens(expression);
		// TODO: Check the tokens...

		expression = "sin(perlinColor(x, y))";
		tokens = tokenizer.parseTokens(expression);
		// TODO: Check the tokens...
	}
	
	@Test
	public void testTokenizeEqualsOperatorExpression() {
		String expression = "a=x+y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("a"), tokens.get(0));
		assertEquals(new EqualsToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new PlusToken(), tokens.get(3));
		assertEquals(new IdentifierToken("y"), tokens.get(4));
	}
	
	@Test
	public void testTokenizeRandomExpression() {
		String expression = "random()";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new RandomToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new RightParenToken(), tokens.get(2));
	}
	
	@Test
	public void testTokenizeRandExpExpression() {
		String expression = "randExp(5)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new RandExpToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new NumberToken(5), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}

}
