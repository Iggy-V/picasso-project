package picasso.parser.tokens.functions;

import picasso.parser.tokens.Token;

/**
* Represents the image clip token.
* @author Jack d'Entremont
*/
public class ImageClipToken extends Token {
	
	private String myName;
	
	public ImageClipToken(String value) {
		super("Function Token");
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
	
	public String toString() {
		return super.toString() + ": " + myName;
	}
}