/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Plus operator in the Picasso language
 * @author Elijah "Uno" Christopher
 *
 */
public class Addition extends BinaryOperator{ 
	
	/**
	 * Creates an addition expression that takes as a parameter the given two expressions
	 * 
	 * @param param
	 * @param param2
	 */
	public Addition(ExpressionTreeNode param, ExpressionTreeNode param2) {
		super(param, param2);
	}
	/**
	 * Evaluates this expression at the given x,y point by evaluating the addition of
	 * the function's parameter. 
	 */
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		RGBColor result2 = param2.evaluate(x, y);
		double red = result.getRed()+ result2.getRed();
		double green = result.getGreen()+ result2.getGreen();
		double blue = result.getBlue()+ result2.getBlue();
		
		return new RGBColor(red, green, blue);
	}

}
