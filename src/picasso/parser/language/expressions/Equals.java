/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.IdentifierAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.IdentifierToken;

/**
 * Represents the assignment operator in the Picasso language
 * @author Joe Condie
 * 
 */
public class Equals extends ExpressionTreeNode { 
	
	
	/**
	 * Creates an assignment expression that takes as a parameter the given two expressions
	 * 
	 * @param var
	 * @param param
	 */
	 String left; 
	 ExpressionTreeNode right;
	
	public Equals(String left, ExpressionTreeNode right) {
		this.left = left;
		this.right = right;
		IdentifierAnalyzer.idToExpression.put(this.left, this.right);
	}
	
	/**
	 * Evaluates this expression on both sides of the equals sign
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		
		RGBColor result = right.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();
		
		return new RGBColor(red,green,blue);
		
	}
	
}
