package picasso.parser;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the RandExp function.
 * 
 * @author Joe Condie
 * 
 */
public class RandExpAnalyzer implements SemanticAnalyzerInterface {
		
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the random exp token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		
		return new RandExp(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
