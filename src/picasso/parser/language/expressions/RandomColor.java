package picasso.parser.language.expressions;

import java.util.Random;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Random Color function in the Picasso language.
 * 
 * @author Joe Condie
 * 
 */
	
	
public class RandomColor extends ExpressionTreeNode {

	Random rand = new Random();
	private double red = rand.nextDouble()*(-1);
	private double green = rand.nextDouble()*(-1);
	private double blue = rand.nextDouble()*(-1);
	
	
	/**
	 * Create a random color that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */
		@Override
		public RGBColor evaluate(double x, double y) {

			return new RGBColor(red, green, blue);
		}
	}
