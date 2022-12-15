
package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.RGBToYCrCb;
import picasso.parser.language.expressions.X;
import picasso.parser.tokens.functions.RGBToYCrCbToken;
/**
 * Tests for RGBToYCrCb function
 * @author Joe Condie
 *
 */
public class RGBToYCrCbTest {
	
	@Test
	public void testRGBToYCrCbTokenDescription() {
		RGBToYCrCbToken token = new RGBToYCrCbToken();
		assertEquals(token.toString(),"RGBToYCrCb Function Token");
	}
	@Test
	public void testRGBToYCrCbTokenFunction() {
		RGBToYCrCbToken token = new RGBToYCrCbToken();
		assertTrue(token.isFunction()== true);
	}
	@Test
	public void testRGBToYCrCbTokenNotConstant() {
		RGBToYCrCbToken token = new RGBToYCrCbToken();
		assertTrue(token.isConstant()== false);
	}
	@Test
	public void testRGBToYCrCbEvaluation() {
		RGBToYCrCb myTree = new RGBToYCrCb(new X());

		// some straightforward tests
		assertEquals(new RGBColor((0.6* 0.2989 + 0.6*0.5866 + 0.6 * 0.1145), (0.6* -0.1687 + 0.6* -0.3312 + 0.6* 0.5), 
				(0.6* -0.1687 + 0.6* -0.3312 + 0.6* 0.5)), myTree.evaluate(.6, -1));
		
		assertEquals(new RGBColor((1* 0.2989 + 1*0.5866 + 1 * 0.1145), (1* -0.1687 + 1* -0.3312 + 1* 0.5), 
				(1* -0.1687 + 1* -0.3312 + 1* 0.5)), myTree.evaluate(1, -1));
		
		assertEquals(new RGBColor((-1* 0.2989 + -1*0.5866 + -1 * 0.1145), (-1* -0.1687 + -1* -0.3312 + -1* 0.5), 
				(-1* -0.1687 + -1* -0.3312 + -1* 0.5)), myTree.evaluate(-1, 1));
		

		// test the ints
		for(int i=-1;i<=1;i++){
			
			assertEquals(new RGBColor((i* 0.2989 + i*0.5866 + i* 0.1145), (i* -0.1687 + i* -0.3312 + i* 0.5), 
					(i* -0.1687 + i* -0.3312 + i* 0.5)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor((i* 0.2989 + i*0.5866 + i* 0.1145), (i* -0.1687 + i* -0.3312 + i* 0.5), 
					(i* -0.1687 + i* -0.3312 + i* 0.5)), myTree.evaluate(i, i));
		}

	}
	
	
}
