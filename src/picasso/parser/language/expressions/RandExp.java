package picasso.parser.language.expressions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Random Expression function in the Picasso language.
 * 
 * @author Joe Condie
 * 
 */
public class RandExp extends ExpressionTreeNode {

	/**
	 * Create a random expression that takes as a parameter ~ the desired size of the expression
	 * To avoid errors, sometimes an additional function is added so the length might be greater than you intended
	 * User inputed length is to make sure the expression isn't enormous
	 * 
	 * @param param the expression
	 */
	
	
	public int length;
	public String expression;
	ExpressionTreeNode e;
	
	public RandExp(int length) {
		this.length = length;
		
		List<String> functions = Arrays.asList("RGBToYCrCb(", "yCrCbToRGB(","floor(","ceil(","sin(","abs(","cos(","tan(","atan(","log(");
		List<String> others = Arrays.asList("x","y","random()");
		List<String> operators = Arrays.asList("+","-","*","/");
		
		Random rand = new Random();
		
		int randStartFunc = rand.nextInt(functions.size());
		String start = functions.get(randStartFunc);
		expression = start;
		
		int counter = 0;
		
		for( int i = 0; i<length;) {
			int randList = rand.nextInt(3);

			if (randList == 0) {
				if (expression.endsWith("x") == true || expression.endsWith("y") == true
					|| expression.endsWith("random()") == true) {
					
					int randAction = rand.nextInt(operators.size());
					String item = (String) operators.get(randAction);
					expression += item;
					i++;
					
					}
				
				else {
					int randAction = rand.nextInt(functions.size());
					String item = (String) functions.get(randAction);
					expression += item;
					i++;
					counter++;
					}
				}
			
			if (randList == 1) {
				if (expression.endsWith("x") == true || expression.endsWith("y") == true
						|| expression.endsWith("random()") == true) {
					
					int randAction = rand.nextInt(operators.size());
					String item = (String) operators.get(randAction);
					expression += item;
					i++;
					}
				else {
					int randAction = rand.nextInt(others.size());
					String item = (String) others.get(randAction);
					expression += item;
					i++;
					
				}
				
			if (randList == 2) {
				if (expression.endsWith("(") == true || expression.endsWith("+") == true || expression.endsWith("-") == true
						|| expression.endsWith("*") == true || expression.endsWith("/") == true) {
						
					int randAction = rand.nextInt(functions.size());
					String item = (String) functions.get(randAction);
					expression += item;
					i++;
					counter++;
					}
				
				else {
					int randAction = rand.nextInt(operators.size());
					String item = (String) operators.get(randAction);
					expression += item;
					i++;	
						}
					}
				}	
			}
		if (expression.endsWith(")")) {
			int randAction = rand.nextInt(operators.size());
			String item = (String) operators.get(randAction);
			expression += item;
		}
		if (expression.endsWith("(") == true || expression.endsWith("+") == true || expression.endsWith("-") == true
				|| expression.endsWith("*") == true || expression.endsWith("/") == true) {
			int randAction = rand.nextInt(others.size());
			String item = (String) others.get(randAction);
			expression += item;
		}
		
		for (int x = 0; x< counter+1; x++) {
			expression += ")";
		}
	System.out.println("");
	System.out.println("Random Expression: " + expression);
	
	ExpressionTreeGenerator exp = new ExpressionTreeGenerator();
	e = exp.makeExpression(expression);
	
	}
	
	
	/**
	 * Evaluates this random expression at the given x,y point
	 * 
	 * @return the color from evaluating the random expression
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
	    RGBColor result = e.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();

		return new RGBColor(red, green, blue);
	}

}