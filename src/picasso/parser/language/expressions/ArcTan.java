package picasso.parser.language.expressions;
import java.lang.Math;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Tan function in the Picasso language.
 * 
 * @author Ignas Volcokas
 * 
 */
public class ArcTan extends UnaryFunction {

	/**
	 * Create a Tan expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to Tangent
	 */
	public ArcTan(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the Tan of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the Tan of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.atan(result.getRed());
		double green = Math.atan(result.getGreen());
		double blue = Math.atan(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
