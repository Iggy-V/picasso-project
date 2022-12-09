package picasso.parser.language.expressions;

/**
* Represents an image in the Picasso language.
* @author Jack d'Entremont
* 
*/
public class Image {
	
	String image;
	double paramx;
	double paramy;
	
	/**
	 * Creates an image from a string representation of the image file.
	 * 
	 * @param image
	 * @param paramx
	 * @param paramy
	 */
	public Image(String image, double paramx, double paramy) {
		this.paramx = paramx;
		this.paramy = paramy;
		this.image = image;
	}
	
	public Image imageClip(String img, double x, double y) {
		Image pic = new Image(img, x, y);
		if(x>1) {
			x=1;
		}
		if(x<-1){
			x=-1;
		}
		if(y>1) {
			y=1;
		}
		if(y<-1) {
			y=-1;
		}
		return pic;
	}
}