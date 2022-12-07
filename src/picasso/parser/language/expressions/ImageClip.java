package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the imageClip function in the Picasso language.
* @author Jack d'Entremont
* 
*/
public class ImageClip extends UnaryFunction{
	
	String image;
	
	/**
	 * Creates an image clip expression that takes as parameters x,y coordinates and a
	 * string representing the image to be clipped.
	 * 
	 * @param image
	 * @param param
	 * @param param2
	 */
	public ImageClip(String image, ExpressionTreeNode param) {
		super(param);
		this.image = image;
	}
	/**
	 * Evaluates this expression at the given x,y point by clipping the the image passed
	 * as a parameter.
	 * 
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();
		
		if(red>1) {
			red = 1;
		}
		if(red<-1){
			red =-1;
		}
		if(green>1) {
			green=1;
		}
		if(green<-1) {
			green=-1;
		}
		if(blue>1) {
			blue=1;
		}
		if(blue<-1) {
			blue=-1;
		}
		
		return new RGBColor(red, green, blue);
	}
}