package picasso.view;

/**
 * a class that represents input whether from a file or entered in
 * 
 * @author Ignas Volcokas
 */
public class Input {
    
    private static String input="";
    /**
     * returns the input
     * @return input
     */
    public static String getInput(){
        if (input == ""){
            System.out.println("empty");
        }
        return input;
    }
    /**
     * sets the input
     * @param x
     */
    public static void setInput(String x) throws IllegalArgumentException{
       
        input = x;
        if( input.contains("//")){
            String[] stringparts = input.split("//");
            input = stringparts[0];
        }        
       
    }
}
