package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the plus sign token
 * 
 */
public class ReferenceToken extends CharToken implements OperationInterface {
	public ReferenceToken() {
		super(CharConstants.DOLLAR);
		
	}
	
	@Override
	public final int OrderofOp() {
		return REFERENCE;
	}
	
}