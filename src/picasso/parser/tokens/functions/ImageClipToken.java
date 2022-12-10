package picasso.parser.tokens.functions;

import picasso.parser.language.ExpressionTreeNode;


/**
* Represents the image clip function token.
* @author Jack d'Entremont
*/
public class ImageClipToken extends FunctionToken {
	
	private final String img;
	private final ExpressionTreeNode paramx;
	private final ExpressionTreeNode paramy;
	
	public ImageClipToken(String img, ExpressionTreeNode paramx, ExpressionTreeNode paramy) {
		super("Image Clip Function Token");
		this.img = img;
		this.paramx = paramx;
		this.paramy = paramy;
	}
	
	public String getString() {
		return img;
	}
	
	public ExpressionTreeNode getX() {
		return paramx;
	}
	
	public ExpressionTreeNode getY() {
		return paramy;
	}
}