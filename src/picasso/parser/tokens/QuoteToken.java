package picasso.parser.tokens;

/**
* Represents a quote.
*
* @author Jack d'Entremont
*/
public class QuoteToken extends Token {
	
	private final String myValue;
	
	/**
	 * Constructs a token representing myValue.
	 * 
	 * @param value the value of this quote token.
	 */
	public QuoteToken(String value) {
		super("Quote Token");
		myValue = value;
	}
	
	/**
	 * @return the value of this token
	 */
	public String value() {
		return myValue;
	}
	
	public String toString() {
		return super.toString() + ": " + myValue;
	}
	
	public boolean isConstant() {
		return false;
	}
	
	public boolean isFunction() {
		return false;
	}
}