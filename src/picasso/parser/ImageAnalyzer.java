package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.ImageToken;

/**
* Handles parsing an image.
*
* @author Jack d'Entremont
*/
public class ImageAnalyzer implements SemanticAnalyzerInterface {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		Token t = tokens.pop();
		if( ! ( t instanceof ImageToken)) {
			throw new ParseException("Expected an Image.");
		}
		ImageToken it = (ImageToken) t;
		return new Image(it.getString());
	}
}