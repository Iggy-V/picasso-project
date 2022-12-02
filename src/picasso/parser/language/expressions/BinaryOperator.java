/**
 * 
 */
package picasso.parser.language.expressions;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes two arguments
 * @author Elijah "Uno" Christopher
 *
 */
public abstract class BinaryFunction extends ExpressionTreeNode{
	
	ExpressionTreeNode param;
	ExpressionTreeNode param2;
	
	/**
	 * @param param
	 * @param param2
	 */
	
	public BinaryFunction(ExpressionTreeNode param, ExpressionTreeNode param2) {
		this.param = param;
		this.param2 = param2;
	}

}
