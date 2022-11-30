package picasso.parser;

import java.util.Stack;

/**
* Handles parsing the ceil function.
*
* @author Jack d'Entremont
*
*/
public class CeilAnalyzer extends UnaryFunctionAnalyzer {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Ceil(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}
}