package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes no arguments.
 * 
 * @author Joe Condie
 *
 */
public abstract class NoArgFunction extends ExpressionTreeNode {
	
	ExpressionTreeNode node;
	
	/**
	 * 
	 * @param param
	 */
	public NoArgFunction(ExpressionTreeNode node) {
		this.node = node;
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".")) + "()";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof NoArgFunction)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		return true;
	}

}
