package picasso.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.ImageClipToken;
import picasso.parser.tokens.Token;

/**
* Handles parsing the image clip function
*
* @author Jack d'Entremont
*/
public class ImageClipAnalyzer implements SemanticAnalyzerInterface {
	
	public static Map<String, ExpressionTreeNode> idToExpression = new HashMap<String, ExpressionTreeNode>();
	
	static {
		idToExpression.put("x", new X());
		idToExpression.put("y", new Y());
	}
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		ImageClipToken i = (ImageClipToken) tokens.pop();
		String id = i.getName();
		ExpressionTreeNode mapped = idToExpression.get(id);
		if (mapped != null) {
			return mapped;
		}
		return null;
	}
	}
