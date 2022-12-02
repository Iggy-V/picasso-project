package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the ceil function in the Picasso language.
*
* @author Jack d'Entremont
*
*/
public class Ceil extends UnaryFunction {
	
	/**
	 * Create a ceil expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to ceil
	 */
	public Ceil(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates this expression at the given x,y point by evaluating the ceil of
	 * the functions parameter.
	 * 
	 * @return the color from evaluating the ceil of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.ceil(result.getRed());
		double green = Math.ceil(result.getGreen());
		double blue = Math.ceil(result.getBlue());
		
		return new RGBColor(red, green, blue);
	}
}