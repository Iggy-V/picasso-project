package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the $ call of history
* 
* @author Ignas Volcokas
*
*/
public class Reference extends ExpressionTreeNode {
	
	/**
	 * Create a ! expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to invert
	 */
	public Reference(int param) {
		
	}
	
	/**
	 * Evaluates this expression at the given x,y point by inverting the color.
	 * 
	 * @return the inverted color
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = -1 * result.getRed();
		double green = -1 * result.getGreen();
		double blue = -1 * result.getBlue();
		
		return new RGBColor(red, green, blue);
	}
}