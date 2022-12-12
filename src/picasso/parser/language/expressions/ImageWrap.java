package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the image wrap function in the picasso language.
*
* @author Jack d'Entremont
*/
public class ImageWrap extends ExpressionTreeNode {
	
	public static Image img;
	private ExpressionTreeNode paramx;
	private ExpressionTreeNode paramy;
	
	/**
	 * Creates an image wrap expression that takes as parameters an image and x,y coordinates to 
	 * be evaluated.
	 * 
	 * @param img
	 * @param paramx
	 * @param paramy
	 */
	public ImageWrap(Image img, ExpressionTreeNode paramx, ExpressionTreeNode paramy) {
		this.paramx = paramx;
		this.paramy = paramy;
		this.img = img;
	}
	
	/**
	 * Evaluates this expression by evaluating the x and y coordinate expressions, and applying
	 * the new resulting color to the image.
	 */
	public RGBColor evaluate(double x, double y) {
		double xexpr = Wrap.wrap((paramx.evaluate(x,y)).getRed());
		double yexpr = Wrap.wrap((paramy.evaluate(x,y)).getRed());
		
		RGBColor imgColor = img.evaluate(xexpr, yexpr);
		return imgColor;
	}
}