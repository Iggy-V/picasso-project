package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the perlinColor function in the picasso language.
*
* @author Joe Condie
*/
public class PerlinColor extends ExpressionTreeNode {
	
	private ExpressionTreeNode param;
	private ExpressionTreeNode param2;
	
	/**
	 * Creates a perlin color expression that takes as parameters an image and x,y coordinates to 
	 * be evaluated.
	 * 
	 * @param param
	 * @param param2
	 */
	public PerlinColor(ExpressionTreeNode param, ExpressionTreeNode param2) {
		this.param = param;
		this.param2 = param2;
	}
	
	/**
	 * Generate Perlin noise based on the given values. Algorithm described in
	 * detail at this site:
	 * http://freespace.virgin.net/hugo.elias/models/m_perlin.htm
	 */
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		RGBColor result2 = param2.evaluate(x, y);
		double red = ImprovedNoise.noise(result.getRed() + 0.3, result2.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(result.getBlue() + 0.1, result2.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(result.getGreen() - 0.8, result2.getGreen() - 0.8, 0);
		return new RGBColor(red, green, blue);
	}
}
