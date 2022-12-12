package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

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