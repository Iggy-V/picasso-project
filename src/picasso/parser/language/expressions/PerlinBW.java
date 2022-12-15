package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the perlinBW function in the picasso language.
*
* @author Joe Condie
*/
public class PerlinBW extends ExpressionTreeNode {
	
	private ExpressionTreeNode param;
	private ExpressionTreeNode param2;
	
	/**
	 * Creates a perlin BW expression that takes as parameters an image and x,y coordinates to 
	 * be evaluated.
	 * 
	 * @param param
	 * @param param2
	 */
	public PerlinBW(ExpressionTreeNode param, ExpressionTreeNode param2) {
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
		double grey = ImprovedNoise.noise(result.getRed() + result2.getRed(), result.getGreen() + result2.getGreen(), result.getBlue() + result2.getBlue());
		return new RGBColor(grey, grey, grey);
	}
}
