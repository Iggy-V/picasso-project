package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
/**
 * Represents the Multiplication operator in the Picasso language
 * @author Elijah "Uno" Christopher
 *
 */
public class Multiplication extends BinaryOperator {
	
	/**
	 * Creates an Multiplication expression that takes two parameter for an expression
	 * 
	 * @param param
	 * @param param2
	 */
	public Multiplication(ExpressionTreeNode param, ExpressionTreeNode param2) {
		super(param, param2);
	}
	/**
	 * Evaluates this expression at the given x,y point by evaluating the multiplication of
	 * the function's parameter.
	 * 
	 * Returns the color from evaluating Multiplication from the two parameters
	 */
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		RGBColor result2 = param2.evaluate(x, y);
		double red = result.getRed()* result2.getRed();
		double green = result.getGreen()* result2.getGreen();
		double blue = result.getBlue()* result2.getBlue();
		
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

		if (!(o instanceof Subtraction)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		Multiplication m = (Multiplication) o;

		// check if their parameters are equal
		if (!this.param.equals(m.param)) {
			return false;
		}
		return true;
	}
}
