package picasso.parser.tokens.functions;

import picasso.parser.tokens.Token;

/**
* Represents the image clip token.
* @author Jack d'Entremont
*/
public class ImageClipToken extends Token {
	
	private final String myName;
	
	public ImageClipToken(String value) {
		super("Image Clip Token");
		myName = value;
	}
	
	public String getName() {
		return myName;
	}
	
	@Override
	public boolean isFunction() {
		return true;
	}
	
	@Override
	public boolean isConstant() {
		return false;
	}
}