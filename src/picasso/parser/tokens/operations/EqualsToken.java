package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the equals sign in the Picasso programming language
 */
public class EqualsToken extends CharToken implements OperationInterface {
	public EqualsToken() {
		super(CharConstants.EQUAL);
	}
	@Override
	public final int OrderofOp() {
		return EQUALS;
	}
	
}
