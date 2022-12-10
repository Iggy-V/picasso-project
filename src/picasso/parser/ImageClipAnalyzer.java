package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.ImageClipToken;

/**
* Handles parsing the image clip function
*
* @author Jack d'Entremont
*/
public class ImageClipAnalyzer implements SemanticAnalyzerInterface {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		Token t = tokens.pop();
		if(!(t instanceof ImageClipToken)) {
			throw new ParseException("Expected an Image Clip function.");
		}
		ImageClipToken ict = (ImageClipToken) t;
		return new ImageClip(ict.getString(), ict.getX(), ict.getY());
	}
}
