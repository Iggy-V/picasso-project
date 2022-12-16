package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
* Represents a quote in the Picasso language.
*
* @author Jack d'Entremont
*
*/
public class Quote extends ExpressionTreeNode {
	
	protected String value;  
	
	/**
	 * Creates new Quote object that represents the given value.
	 * 
	 * @param d must be string.
	 */
	public Quote(String d) {
		if(!(d instanceof String)) {
			throw new IllegalArgumentException("Parameter must be a String.");
		}
		value = d;
	}
	
	/**
	 * Returns the value of the Quote.
	 * 
	 * @return the value of the Quote.
	 */
	public String value() {
		return value;
	}
	
	/**
	 * Returns the Quote.
	 * 
	 * @return the Quote.
	 */
	public String toString() {
		return "Quote: " + value;
	}
	
	/**
	 * If the quote is not a file in images return black.
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		return new RGBColor(1, 1, 1);
	}
}