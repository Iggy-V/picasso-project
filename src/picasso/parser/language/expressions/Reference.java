package picasso.parser.language.expressions;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.view.History;

/**
* Represents the $ call of history
* 
* @author Ignas Volcokas
*
*/

public class Reference extends ExpressionTreeNode {
	
    private String r;
    public int x;
	ExpressionTreeNode e;
	/**
     *  
	 */
	public Reference(int x) {
		this.r = History.getHistory().get(x);
        ExpressionTreeGenerator exp = new ExpressionTreeGenerator();
	    e = exp.makeExpression(r);
	}
	
	/**
	 * Evaluates this expression at the given x,y point by inverting the color.
	 * 
	 * @return the inverted color
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = e.evaluate(x, y);
		double red = result.getRed();
		double green =result.getGreen();
		double blue = result.getBlue();
		
		return new RGBColor(red, green, blue);
	}
}