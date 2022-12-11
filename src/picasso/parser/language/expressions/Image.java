package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

/**
* Represents an image in the Picasso language.
* @author Jack d'Entremont
* 
*/
public class Image extends ExpressionTreeNode {
	
	private String myfilename;
	private BufferedImage myImage;
	
	/**
	 * Creates an image from a string representation of the image file.
	 * 
	 * @param image
	 */
	public Image(String filename) {
		try {
			this.myfilename = filename;
			File fileName = new File("images/"+ filename);
			this.myImage = ImageIO.read(fileName);
		}
		catch (IOException e) {
			e.printStackTrace();;
		}
	}
	
	public static int scale(double value, int bounds) {
		return (int) (((value + 1)/2)*(bounds-1));
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		int xexpr = scale(x, myImage.getWidth());
		int yexpr = scale(y, myImage.getHeight());
		
		return new RGBColor(new Color(myImage.getRGB(xexpr, yexpr)));
	}
	
}