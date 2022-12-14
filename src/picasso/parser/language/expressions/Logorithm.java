package picasso.parser.language.expressions;
import java.lang.Math;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Log function in the Picasso language.
 * 
 * @author Ignas Volcokas
 * 
 */
public class Logorithm extends UnaryFunction {

	/**
	 * Create a Log expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to logorithm
	 */
	public Logorithm(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the log of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the log of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.log(Math.abs(result.getRed()));
		double green = Math.log(Math.abs(result.getGreen()));
		double blue = Math.log(Math.abs(result.getBlue()));

		return new RGBColor(red, green, blue);
	}

}

