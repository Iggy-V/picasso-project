package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ArcTan;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the tan function.
 * 
 * @author Ignas Volcokas
 * 
 */
public class AtanAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		
		return new ArcTan(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}

