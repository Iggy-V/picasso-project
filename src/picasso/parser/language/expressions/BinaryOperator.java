/**
 * 
 */
package picasso.parser.language.expressions;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes two arguments
 * 
 * @author Elijah "Uno" Christopher
 * @author Ignas Volcokas
 */
public abstract class BinaryOperator extends ExpressionTreeNode{
	
	ExpressionTreeNode param;
	ExpressionTreeNode param2;
	
	/**
	 * @param param 
	 * @param param2 
	 */
	
	public BinaryOperator(ExpressionTreeNode param, ExpressionTreeNode param2) {
		this.param = param;
		this.param2 = param2;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof BinaryOperator)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		BinaryOperator bf = (BinaryOperator) o;

		// check if their parameters are equal
		if (!this.param.equals(bf.param)) {
			return false;
		}
		
		if(!this.param2.equals(bf.param2)) {
			return false;
		}
		return true;
		
	}

}
