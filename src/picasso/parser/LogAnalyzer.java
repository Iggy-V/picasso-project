package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Logorithm;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the log function.
 * 
 * @author Ignas Volcokas
 * 
 */
public class LogAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		
		return new Logorithm(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}

