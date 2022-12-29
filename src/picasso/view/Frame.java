package picasso.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
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
 * @author Ignas Volcokas
 * 
 */

@SuppressWarnings("serial")
public class Frame extends JFrame implements KeyListener, FocusListener, MouseListener{

	private JTextField entry;
    private JLabel jLabel1;
    private JButton evaluate;
    public static String textFieldValue;
	public Canvas canvas;
	public JLabel jLabel2 = new JLabel();
	public JLabel jLabel3 = new JLabel();

	public void keyPressed(KeyEvent e){
		System.out.println("key pressed");
	}

	/**
	 * Handles key inputs of left/right arrow and enter
	 */
	public void keyReleased(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			History.timeTravel();
			History.backToTheFuture();
			jLabel2.setText("Current Expression: " + History.getPresent());

			Evaluator ev = new Evaluator();
			ThreadedCommand<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, ev);

			action.execute(canvas.getPixmap());
			canvas.refresh();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			History.timeTravel();
			History.timeMachine();
			jLabel2.setText("Current Expression: " + History.getPresent());

			Evaluator ev = new Evaluator();
			ThreadedCommand<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, ev);
		
			action.execute(canvas.getPixmap());
			canvas.refresh();

		}
	}
	public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }
    
	public Frame(Dimension size) {
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		canvas = new Canvas(this);
		canvas.setSize(size);
	
		canvas.addMouseListener(this);
		canvas.addFocusListener(this);
		canvas.setFocusable(true);
		
		  
		entry = new JTextField(25);
		entry.addFocusListener(this);

		jLabel1 = new JLabel();
		evaluate = new JButton("Submit");
		jLabel1.setText("Enter the expression:");
		jLabel2.setText("");
		jLabel3.setText("Saved Expressions");
		
		
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
			commands.add("Open", new Reader());
			commands.add("Save", new Writer());
			commands.add("Read File", new FileReader(canvas));
			
			commands.add(jLabel1);
			commands.add(entry);
			commands.add(evaluate);
		
		ButtonPanel commandsBottom = new ButtonPanel(canvas);
			commandsBottom.add(jLabel2);

		//commandsBottom.add(jLabel3);
		//ButtonPanel commandsSide = new ButtonPanel(canvas);
		//	commandsSide.add(jLabel2);
			
		ButtonPanel commandsSide = new ButtonPanel(canvas);
			commandsSide.add(jLabel3);

			
		
		Action actionOne = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				Input.setInput(entry.getText());
				System.out.println(Input.getInput());
				Evaluator ev = new Evaluator();
				ThreadedCommand<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, ev);
				
				action.execute(canvas.getPixmap());
				//System.out.println(History.getPresent());
				jLabel2.setText("Current Expression: " + History.getPresent());

				StringBuilder assignment = new StringBuilder();
				assignment.append("<html><body>Saved Expressions");
				for (String i: History.getSavedExpHistory()){
					assignment.append("<br>");
					assignment.append(i);
				}
				assignment.append("</body></html>");
				jLabel3.setText(assignment.toString());
				canvas.refresh();
				
			}
		};

		evaluate.addActionListener(actionOne);
		entry.addActionListener(actionOne);

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(commandsBottom, BorderLayout.SOUTH);
		getContentPane().add(commandsSide, BorderLayout.EAST);
		//getContentPane().add(commandsSide, BorderLayout.WEST);
		pack();
	}

	public void focusGained(FocusEvent e) {
    	;
	}

    public void focusLost(FocusEvent e) {
    	;
	}

    void displayMessage(String prefix, FocusEvent e) {
		;
    }
	public void mousePressed(MouseEvent e) {
        ;
    }
     
    public void mouseReleased(MouseEvent e) {
		;
    }
     
    public void mouseEntered(MouseEvent e) {
        ;
    }
	public void mouseExited(MouseEvent e) {
    	;
    }
    
	/**
	 * focuses on the item clicked. 
	 */
    public void mouseClicked(MouseEvent e) {
		;
		requestFocus();
    }
}
