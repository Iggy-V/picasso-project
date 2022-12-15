package picasso.parser.language.expressions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Random Expression function in the Picasso language.
 * 
 * @author Joe Condie
 * 
 */
public class RandExp extends UnaryFunction {

	/**
	 * Create a random expression that takes as a parameter the given expression
	 * 
	 * @param param the expression
	 */
	public RandExp(ExpressionTreeNode param) {
		super(param);
	}
	
	List<String> functions = Arrays.asList("x","y","floor","ceil","sin","abs","cos","tan","atan","^","log");
	Random rand = new Random();
	
	int randIndex = rand.nextInt(functions.size());
	String randFunc = functions.get(randIndex);
	
	//Math method = Math.getMethod(randFunc, Math.class);
	/**
	 * Evaluates this random expression at the given x,y point
	 * 
	 * @return the color from evaluating the random expression
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = (result.getRed());
		double green = (result.getGreen());
		double blue = (result.getBlue());

		return new RGBColor(red, green, blue);
	}

}