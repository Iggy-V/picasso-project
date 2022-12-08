package picasso.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.EqualsToken;

/**
 * Handles parsing the equals sign.
 * 
 * @author Joe Condie
 * 
 */
public class EqualsAnalyzer implements SemanticAnalyzerInterface {
	
	

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		
		ExpressionTreeNode param = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		IdentifierToken t = (IdentifierToken) tokens.pop();
		//EqualsToken t = (EqualsToken) tokens.pop();
		String id = t.getName();
		return new Equals(id, param);
		
		
	}
}


 