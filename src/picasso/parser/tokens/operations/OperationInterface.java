package picasso.parser.tokens.operations;

/**
 * A marker interface for operators 
 * @author Elijah "Uno" Christopher
 */
public interface OperationInterface {
	
	static final int CONSTANT = 0;
	static final int EQUALS = 0;
	static final int GROUPING = 1; // parentheses
	static final int ADD_OR_SUBTRACT = 2;
	static final int MULTIPLY_OR_DIVIDE = 3;
	static final int EXP = 4;
	
	
	/**
	 * 
	 * @return OrderofOp precedence of token
	 */
	public int OrderofOp();

}
