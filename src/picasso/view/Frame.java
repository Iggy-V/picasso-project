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
import java.awt.event.ActionListener;

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

	public void keyReleased(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			System.out.println("right");
			History.timeTravel();
			History.backToTheFuture();
			jLabel2.setText("Current Expression: " + History.getPresent());
			Evaluator ev = new Evaluator();
			ThreadedCommand<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, ev);

			action.execute(canvas.getPixmap());
			canvas.refresh();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			System.out.println("left, index:" + History.getIndex() + " " + History.getHistory());
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
		jLabel3.setText("Saved Expressions: ");
		
		
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
			commands.add("Open", new Reader());
			//commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));
			commands.add("Save", new Writer());
			commands.add("Read File", new FileReader(canvas));
			commands.add(jLabel1);
			commands.add(entry);
			commands.add(evaluate);
		
		ButtonPanel commandsBottom = new ButtonPanel(canvas);
			commandsBottom.add(jLabel2);
			commandsBottom.add(jLabel3);
		//ButtonPanel commandsSide = new ButtonPanel(canvas);
		//	commandsSide.add(jLabel2);
			
			
			
		
		Action action = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				Input.setInput(entry.getText());
				System.out.println(Input.getInput());
				Evaluator ev = new Evaluator();
				ThreadedCommand<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, ev);
				action.execute(canvas.getPixmap());
				jLabel2.setText("Current Expression: " + Input.getInput() + "  | ");
				jLabel3.setText("<html>" + "Saved expressions: " + History.getSavedExpHistory()+ "</html>");
				canvas.refresh();
				// TODO:
				// Input.setInput("y+x"); why is this the one getting evluated
			}
		};
		Action update = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("updating label");
				//jLabel2.setText("Current Expression: " + Input.getInput());
				canvas.refresh();
			}
		};
		
		//commands.add("Submit", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));
		evaluate.addActionListener(action);
		entry.addActionListener(action);
		entry.addActionListener(update);
		//entry.addActionListener(showVariables);
		//Input.setInput("");
		// add our container to Frame and show it
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(commandsBottom, BorderLayout.SOUTH);
		//getContentPane().add(commandsSide, BorderLayout.WEST);
		pack();
	}

	public void focusGained(FocusEvent e) {
        //displayMessage("Focus gained", e);
    }

    public void focusLost(FocusEvent e) {
        //displayMessage("Focus lost", e);
    }

    void displayMessage(String prefix, FocusEvent e) {
        // System.out.println(prefix
        //             + (e.isTemporary() ? " (temporary):" : ":")
        //             +  e.getComponent().getClass().getName()
        //             + "; Opposite component: " 
        //             + (e.getOppositeComponent() != null ?
        //                 e.getOppositeComponent().getClass().getName() : "null")
        //             + "\n"); 
		
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
     
    public void mouseClicked(MouseEvent e) {
		;
		requestFocus();
    }
}
