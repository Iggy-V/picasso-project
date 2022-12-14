package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the module sign token
 * 
 * @author Ignas Volcokas
 */
public class ModuleToken extends CharToken implements OperationInterface {
	public ModuleToken() {
		super(CharConstants.MOD);
		
	}
	
	@Override
	public final int OrderofOp() {
		return MULTIPLY_OR_DIVIDE;
	}
	
}