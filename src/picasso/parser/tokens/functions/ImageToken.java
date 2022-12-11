package picasso.parser.tokens.functions;

import picasso.parser.tokens.Token;

/**
* Represents an image token.
*
* @author Jack d'Entremont
*/
public class ImageToken extends Token {
	
	private final String myImage;
	
	/**
	 * @param description
	 */
	public ImageToken(String image) {
		super("Image Token");
		this.myImage = image;
	}
	
	@Override
	public boolean isConstant() {
		return false;
	}
	
	@Override
	public boolean isFunction() {
		return false;
	}
	
	public String getString() {
		return this.myImage;
	}
}