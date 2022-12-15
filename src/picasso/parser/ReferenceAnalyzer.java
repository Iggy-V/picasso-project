package picasso.parser;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.NumberToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the reference call.
 * 
 * @author Ignas Volcokas
 * 
 */
public class ReferenceAnalyzer implements SemanticAnalyzerInterface {
		
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the random exp token
		NumberToken token = (NumberToken) tokens.pop();
		int len = (int) token.value();
		return new RandExp(len);
	}

}
