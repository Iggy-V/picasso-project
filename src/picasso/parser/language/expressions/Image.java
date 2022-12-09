package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
* Represents an image in the Picasso language.
* @author Jack d'Entremont
* 
*/
public class Image {
	
	String image;
	
	/**
	 * Creates an image from a string representation of the image file.
	 * 
	 * @param image
	 * @param paramx
	 * @param paramy
	 */
	public Image(String image) {
		this.image = image;
	}
	
	public Image imageClip(String img, ExpressionTreeNode x, ExpressionTreeNode y) {
		Image pic = new Image(img);
		
		return pic;
	}
	
}