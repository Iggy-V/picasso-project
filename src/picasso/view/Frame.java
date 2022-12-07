package picasso.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 * 
 */

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private JTextField entry;
    private JLabel jLabel1;
    private JButton evaluate;
    public static String textFieldValue;
    
	public Frame(Dimension size) {
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);

		
		entry = new JTextField(25);
		jLabel1 = new JLabel();
		evaluate = new JButton("Submit");
		
		jLabel1.setText("Enter the expression:");
		
		
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		//commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));
		commands.add("Save", new Writer());
		
		commands.add(jLabel1);
		commands.add(entry);
		commands.add(evaluate);
		//commands.add("Submit", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));
		evaluate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldValue = entry.getText();
				System.out.println(textFieldValue);
				Evaluator ev = new Evaluator();
				ThreadedCommand<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, ev);
				action.execute(canvas.getPixmap());
				canvas.refresh();
			}
		});
		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		pack();
	}
}
