/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the assignment operator in the Picasso language
 * @author Joe Condie
 * 
 */
public class Equals extends BinaryOperator{ 
	
	/**
	 * Creates an assignment expression that takes as a parameter the given two expressions
	 * 
	 * @param param
	 * @param param2
	 */
	public Equals(ExpressionTreeNode param, ExpressionTreeNode param2) {
		super(param, param2);
	}
	/**
	 * Evaluates this expression on both sides of the equals sign
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
