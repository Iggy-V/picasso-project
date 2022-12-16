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
	double min = -1.0;
	double max = 1.0;
	private double red = Math.random()*(max-min)+min;
	private double green = Math.random()*(max-min)+min;
	private double blue = Math.random()*(max-min)+min;
	
	
	/**
	 * Create a random color that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */
		@Override
		public RGBColor evaluate(double x, double y) {
			//System.out.println("[ " +red+", " + green +", " + blue + " ]");
			return new RGBColor(red, green, blue);
		}
	}
