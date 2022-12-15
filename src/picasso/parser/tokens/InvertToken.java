package picasso.parser.tokens;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;
import picasso.parser.tokens.operations.OperationInterface;

/**
* Represents the ! function token.
* 
* @author Jack d'Entremont
* 
*/
public class InvertToken extends CharToken implements OperationInterface{
	
	public InvertToken() {
		super(CharConstants.BANG);
	}
	@Override
	public final int OrderofOp() {
		return EQUALS;
	}
}