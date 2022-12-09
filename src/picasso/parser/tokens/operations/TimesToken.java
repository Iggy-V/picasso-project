package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the multiplication sign token
 * 
 */
public class TimesToken extends CharToken implements OperationInterface {
	public TimesToken() {
		super(CharConstants.STAR);
		
	}
	
	@Override
	public final int OrderofOp() {
		return MULTIPLY_OR_DIVIDE;
	}
	

}

	