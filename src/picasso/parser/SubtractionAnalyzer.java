package picasso.parser;

import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;
import picasso.parser.language.expressions.*;

/**
 * Handles parsing the minus operator.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 *
 */
public class SubtractionAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the minus token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed.
		ExpressionTreeNode param = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode param2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		return new Subtraction(param, param2);
	}

}
