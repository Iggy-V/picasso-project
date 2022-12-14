package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
//import picasso.parser.tokens.functions.PerlinColorToken;
import picasso.parser.tokens.Token;


/**
* Handles parsing the image clip function
*
* @author JIgnas Volcokas
*/
public class PerlinColorAnalyzer implements SemanticAnalyzerInterface {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		
		ExpressionTreeNode param1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode param2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
        return new PerlinColor(param1, param2);
	}
}