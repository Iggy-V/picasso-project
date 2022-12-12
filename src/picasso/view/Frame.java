package picasso.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

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
public class Frame extends JFrame implements KeyListener, FocusListener, MouseListener{

	private JTextField entry;
    private JLabel jLabel1;
    private JButton evaluate;
    public static String textFieldValue;
	public Canvas canvas;

	public void keyPressed(KeyEvent e){
		System.out.println("key pressed");
	}

	public void keyReleased(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			System.out.println("right");
			History.timeTravel();
			History.backToTheFuture();
			Evaluator ev = new Evaluator();
			ThreadedCommand<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, ev);
			action.execute(canvas.getPixmap());
			canvas.refresh();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			System.out.println("left, index:" + History.getIndex() + " " + History.getHistory());
			History.timeTravel();
			History.timeMachine();
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
		
		
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		//commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));
		commands.add("Save", new Writer());
		commands.add("Read File", new FileReader(canvas));
		commands.add(jLabel1);
		commands.add(entry);
		commands.add(evaluate);
		

		//commands.add("Submit", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));
		evaluate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Input.setInput(entry.getText());
				System.out.println(Input.getInput());
				Evaluator ev = new Evaluator();
				ThreadedCommand<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, ev);
				action.execute(canvas.getPixmap());
				canvas.refresh();
				// TODO:
				// Input.setInput("y+x"); why is this the one getting evluated
			}
		});
		//Input.setInput("");
		// add our container to Frame and show it
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
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
