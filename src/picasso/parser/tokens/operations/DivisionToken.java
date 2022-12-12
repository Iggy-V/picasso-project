package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the devision sign token
 * 
 * @author Ignas Volcokas
 */
public class DivisionToken extends CharToken implements OperationInterface {
	public DivisionToken() {
		super(CharConstants.SLASH);
		
	}
	
	@Override
	public final int OrderofOp() {
		return MULTIPLY_OR_DIVIDE;
	}
	
}