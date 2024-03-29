package picasso.parser;

import java.util.Stack;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ceil;
import picasso.parser.tokens.Token;

/**
* Handles parsing the ceil function.
*
* @author Jack d'Entremont15
*
*/
public class CeilAnalyzer extends UnaryFunctionAnalyzer {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Ceil(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}
}