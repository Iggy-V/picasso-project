package picasso.view.commands;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;

import picasso.model.Pixmap;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.util.Command;
import static javax.swing.JOptionPane.showMessageDialog;
import picasso.view.History;


import picasso.view.Input;
/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 */
public class Evaluator implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;
	
	/**
	 * Evaluate an expression for each point in the image.
	 */
	public void execute(Pixmap target) {
		try{
			// create the expression to evaluate just once
			ExpressionTreeNode expr = createExpression();
			// evaluate it for each pixel
			Dimension size = target.getSize();
			for (int imageY = 0; imageY < size.height; imageY++) {
				double evalY = imageToDomainScale(imageY, size.height);
				for (int imageX = 0; imageX < size.width; imageX++) {
					double evalX = imageToDomainScale(imageX, size.width);
					Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
					target.setColor(imageX, imageY, pixelColor);
					
				}
			}

		}
		catch (NullPointerException e){
			showMessageDialog(null, "Invalid input - please enter valid expression");
			History.deleteHistory();
		}

	}

	/**
	 * Convert from image space to domain space.
	 */
	protected double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}
	
	/**
	 * 
	 * A place holder for a more interesting way to build the expression.
	 */
	private ExpressionTreeNode createExpression() {
		// Note, when you're testing, you can use the ExpressionTreeGenerator to
		// generate expression trees from strings, or you can create expression
		// objects directly (as in the commented statement below).


		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		if (History.getTimeTravellingStatus()){
			return expTreeGen.makeExpression(History.retrieveHistory());
		}
		else{
		History.AddHistory(Input.getInput());
		//History.getHistory().removeAll(Arrays.asList("", null)); // clears wrong inputs - empty strings

		return expTreeGen.makeExpression(Input.getInput());
		}
		// return new Multiply( new X(), new Y() );
	}

}
