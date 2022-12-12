package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the wrap function in the Picasso language.
* 
* @author Jack d'Entremont
*
*/
public class Wrap extends UnaryFunction {
	
	public static double red;
	public static double green;
	public static double blue;
	
	/**
	 * Create a wrap expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to wrap
	 */
	public Wrap(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates this expression at the given x,y point by wrapping the
	 * functions parameter.
	 * 
	 * @return the color evaluated from wrapping the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = wrap(result.getRed());
		double green = wrap(result.getGreen());
		double blue = wrap(result.getBlue());
		
		return new RGBColor(red, green, blue);
	}
	
	public static double wrap(double x) {
		double difference = x - 1;
		if (difference>0) {
			difference=-1+difference;
		}
		difference = x + 1;
		if (difference<0) {
			difference= 1 + difference;
		}
		return difference;
	}
}