package picasso.parser.tokens.functions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;


/**
* Represents the image clip function token.
* @author Jack d'Entremont
*/
public class ImageClipToken extends FunctionToken {
	
	private final Image img;
	private final ExpressionTreeNode paramx;
	private final ExpressionTreeNode paramy;
	
	public ImageClipToken(Image img, ExpressionTreeNode paramx, ExpressionTreeNode paramy) {
		super("Image Clip Function Token");
		this.img = img;
		this.paramx = paramx;
		this.paramy = paramy;
	}
	
	public Image getImage() {
		return img;
	}
	
	public ExpressionTreeNode getX() {
		return paramx;
	}
	
	public ExpressionTreeNode getY() {
		return paramy;
	}
}