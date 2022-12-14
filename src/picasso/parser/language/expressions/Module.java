
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Devision operator in the Picasso language
 * @author Ignas Volcokas
 *
 */
public class Module extends BinaryOperator{ 
	
	/**
	 * Creates an module expression that takes two parameters for an expression
	 * 
	 * @param param
	 * @param param2
	 */
	public Module(ExpressionTreeNode param, ExpressionTreeNode param2) {
		super(param, param2);
	}
	/**
	 * Evaluates this expression at the given x,y point by evaluating the module of
	 * the function's parameter..
	 */
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		RGBColor result2 = param2.evaluate(x, y);
		double red = result.getRed()% result2.getRed();
		double green = result.getGreen()% result2.getGreen();
		double blue = result.getBlue()% result2.getBlue();
		
		return new RGBColor(red, green, blue);
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
		return classname.substring(classname.lastIndexOf(".")) + "(" + param + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Module)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		Module a = (Module) o;

		// check if their parameters are equal
		if (!this.param.equals(a.param)) {
			return false;
		}
		return true;
	}

}
