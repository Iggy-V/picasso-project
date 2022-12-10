package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the image clip function in the picasso language.
*
* @author Jack d'Entremont
*/
public class ImageClip extends ExpressionTreeNode {
	
	private String img;
	private ExpressionTreeNode paramx;
	private ExpressionTreeNode paramy;
	
	/**
	 * Creates an image clip expression that takes as parameters an image and x,y coordinates to 
	 * be evaluated.
	 * 
	 * @param img
	 * @param paramx
	 * @param paramy
	 */
	public ImageClip(String img, ExpressionTreeNode paramx, ExpressionTreeNode paramy) {
		this.paramx = paramx;
		this.paramy = paramy;
		this.img = img;
	}
	
	/**
	 * Evaluates this expression by evaluating the x and y coordinate expressions, and applying
	 * the new resulting color to the image.
	 */
	public RGBColor evaluate(double x, double y) {
		RGBColor result = paramx.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();
		
		return new RGBColor(red, green, blue);
	}
}