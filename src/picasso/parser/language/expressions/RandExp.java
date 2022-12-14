package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Random Expression function in the Picasso language.
 * 
 * @author Joe Condie
 * 
 */
public class RandExp extends UnaryFunction {

	/**
	 * Create a random expression that takes as a parameter the given expression
	 * 
	 * @param param the expression
	 */
	public RandExp(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this random expression at the given x,y point
	 * 
	 * @return the color from evaluating the random expression
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.cos(result.getRed());
		double green = Math.cos(result.getGreen());
		double blue = Math.cos(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}