package picasso.parser.language.expressions;

import java.util.Random;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Random Color function in the Picasso language.
 * 
 * @author Joe Condie
 * 
 */
public class RandomColor extends NoArgFunction{

	/**
	 * Create a random color that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */
	
	//ExpressionTreeNode node;
	
	public RandomColor(ExpressionTreeNode node) {
		super(node);
	}
	/**
	 * Draws a random color 
	 * 
	 * @return random color
	 */
	public RGBColor evaluate(double x, double y) {
		//Random rand = new Random();
		RGBColor result = node.evaluate(x, y);
		//color = rand.nextDouble()*(-1);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();

		return new RGBColor(red, green, blue);
	}

}