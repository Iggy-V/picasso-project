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

public class FileReader extends FileCommand<Pixmap> {
    
    private Canvas canvas;
    public FileReader(Canvas c){
        super(JFileChooser.OPEN_DIALOG);
        canvas = c;
	}

    public void execute(Pixmap target){
        String filename = getFileName();
        if (filename != null){
            try {
                Scanner input = new Scanner(new File(filename));
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
             catch (FileNotFoundException e){ System.out.println(e);}
             finally {;}
            }
        }
    }

