package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the clamp function in the Picasso language.
* 
* @author Jack d'Entremont
*
*/
public class Clamp extends UnaryFunction {
	
	public static double red;
	public static double green;
	public static double blue;
	
	/**
	 * Create a clamp expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to clamp
	 */
	public Clamp(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates this expression at the given x,y point by clamping the
	 * functions parameter.
	 * 
	 * @return the color evaluated from clamping the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = clamp(result.getRed());
		double green = clamp(result.getGreen());
		double blue = clamp(result.getBlue());
		
		return new RGBColor(red, green, blue);
	}
	
	public static double clamp(double x) {
		double result = x;
		if (result>1) {
			result=1;
		}
		if (result<-1) {
			result=-1;
		}
		return result;
	}
}