package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the minus sign token
 * 
 */
public class SubtractionToken extends CharToken implements OperationInterface {
	public SubtractionToken() {
		super(CharConstants.MINUS);
		
	}
	
	@Override
	public final int OrderofOp() {
		return ADD_OR_SUBTRACT;
		
	}
	

}
