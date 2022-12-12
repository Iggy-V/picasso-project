package picasso.parser.language.expressions;
import java.lang.Math;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the exp function in the Picasso language.
 * 
 * @author Ignas Volcokas
 * 
 */
public class Exp extends UnaryFunction {

	/**
	 * Create a exp expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to exp
	 */
	public Exp(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the exp of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the exp of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.exp(result.getRed());
		double green = Math.exp(result.getGreen());
		double blue = Math.exp(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
