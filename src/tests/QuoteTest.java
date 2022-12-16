package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.Quote;
import picasso.parser.tokens.QuoteToken;

public class QuoteTest {
	
	@Test
	public void testQuoteTokenDescription(){
		QuoteToken token = new QuoteToken("vortex.jpg");
		assertEquals(token.toString(), "Quote Token");
	}
	
	@Test
	public void testQuoteTokenFunction() {
		QuoteToken token = new QuoteToken("vortex.jpg");
		assertTrue(token.isFunction()==false);
	}
	
	@Test
	public void testQuoteTokenConstant() {
		QuoteToken token = new QuoteToken("vortex.jpg");
		assertTrue(token.isConstant()==false);
	}
	
	@Test
	public void testQuoteMethods() {
		Quote quote = new Quote("vortex.jpg");
		assertEquals(quote.value(), quote);
		
		assertTrue(quote.toString().equals("Quote: " + quote));
	}
}