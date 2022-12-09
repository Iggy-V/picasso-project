package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the plus sign token
 * 
 */
public class AdditionToken extends CharToken implements OperationInterface {
	public AdditionToken() {
		super(CharConstants.PLUS);
		
	}
	
	@Override
	public final int OrderofOp() {
		return ADD_OR_SUBTRACT;
	}
	
}
