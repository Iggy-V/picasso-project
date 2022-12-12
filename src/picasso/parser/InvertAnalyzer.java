package picasso.parser;

import java.util.Stack;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Invert;
import picasso.parser.tokens.Token;

/**
* Handles parsing the ! function.
*
* @author Jack d'Entremont
* 
*/
public class InvertAnalyzer extends UnaryFunctionAnalyzer {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Invert(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}
}
