package picasso.view.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.FileCommand;
import picasso.util.ThreadedCommand;
import picasso.view.Input;
import picasso.view.Canvas;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 * this class reads from a file and uses the last expresion
 * in the file to display it
 * 
 * @author Ignas Volcokas
 */

public class FileReader extends FileCommand<Pixmap> {
    
    private Canvas canvas;
    /**
     * represents a file reader object that opens a file
     * and a canvas upon which to act is passed
     * @param c - is this a good design decision?
     */
    public FileReader(Canvas c){
        super(JFileChooser.OPEN_DIALOG);
        canvas = c;
	}
    /**
     * reads the file and goes line by line executing the last line in the file.
     * @param target - the target pixamp for the input
     */
    public void execute(Pixmap target){
        String filename = getFileName();
        if (filename != null){
            try {
                Scanner input = new Scanner(new File(filename));
                if (!input.hasNextLine()){
                    // TODO 
                    // duplicate 
                    showMessageDialog(null, "Empty file");
                    return;
                }
                while (input.hasNextLine())
                {
                    String expression = input.nextLine();
                    System.out.println(expression);
                    Input.setInput(expression);
                    
                }
                Evaluator ev = new Evaluator();
                ThreadedCommand<Pixmap> action = new ThreadedCommand<Pixmap>(canvas, ev);
                action.execute(canvas.getPixmap());
                canvas.refresh();
             }
             catch (FileNotFoundException e){showMessageDialog(null, "Please select a valid file (.txt)");}
             finally {;}
            }
        }
    }

