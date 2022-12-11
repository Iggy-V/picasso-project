package picasso.parser.tokens;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;
import picasso.parser.tokens.operations.OperationInterface;

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
