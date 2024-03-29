package picasso.parser;

import java.util.Stack;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Wrap;
import picasso.parser.tokens.Token;

/**
* Handles parsing the wrap function.
* 
* @author Jack d'Entremont
*/
public class WrapAnalyzer extends UnaryFunctionAnalyzer {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Wrap(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}
}