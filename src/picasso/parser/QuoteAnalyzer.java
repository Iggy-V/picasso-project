package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Quote;
import picasso.parser.tokens.QuoteToken;
import picasso.parser.tokens.Token;

/**
* Analyzer for a quote.
*
* @author Jack d'Entremont
*/
public class QuoteAnalyzer implements SemanticAnalyzerInterface {
	
	private static QuoteAnalyzer singleton;
	
	public static QuoteAnalyzer getInstance() {
		if(singleton == null) {
			singleton = new QuoteAnalyzer();
		}
		return singleton;
	}
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		QuoteToken token = (QuoteToken) tokens.pop();
		
		String value = token.value();
		
		return new Quote(value);
	}
}