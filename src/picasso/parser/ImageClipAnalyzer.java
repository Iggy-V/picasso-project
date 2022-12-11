package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.ImageToken;

/**
* Handles parsing the image clip function
*
* @author Jack d'Entremont
*/
public class ImageClipAnalyzer implements SemanticAnalyzerInterface {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		
		ExpressionTreeNode paramx = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode paramy = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		if(tokens.peek() instanceof ImageToken) {
			ImageAnalyzer analyzer = new ImageAnalyzer();
			ExpressionTreeNode newImage = analyzer.generateExpressionTree(tokens);
			return new ImageClip((Image) newImage, paramx, paramy);
		}
		else {
			throw new ParseException("No Image Token Found.");
		}
	}
}
