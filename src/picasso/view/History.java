package picasso.view;
import java.util.ArrayList;
import java.util.*;


/**
 * A class that stores history of the expressions being entetred
 * and allows traversal of the histories. It is a class for a variable and no constructor
 * all the methods refer to one of the static variables that are private
 * 
 * @author Ignas Volcokas
*/
public class History {
    
    private static List<String> listt = new ArrayList<String>();
    private static List<String> savedExp = new ArrayList<String>();
    private static int index = -1;
    private static boolean timeTraveler = false;

    /**
     * Checks if the expression is non zero and not empty and
     * adds it to the list of expressions.
     * 
     * @param x - expression entered
     */
    public static void AddHistory(String x){
        if(x!="" && x != null){
            listt.add(x);
            index = listt.size()-1;
        }
        if (x.contains("=")) {
        	savedExp.add(x);
        }
        
    }
    public static List<String> getSavedExpHistory() {
    	return savedExp;
    }

    public static void removeLastExpHistory(){
        int x = savedExp.size()-1;
        savedExp.remove(x);
    }

    /**
     * Returns the list of expressions entered before.
     * @return
     */
    public static List<String> getHistory(){
        return listt;
    }

    /**
     * Get the expression that is currently evaluated
     */
    public static String getPresent(){
        if (index == -1){
            return "";
        }
        return listt.get(index);
    }

    /**
     * returns the index of the current item in focus.
     * @return 
     */
    public static int getIndex(){
        return index;
    }

    /**
     * makes index go one back - travels back in time
     * if on the first item loops aroudn to the last item entered
     */
    public static void timeMachine(){
        index -= 1;
        if (index < 0){
            index = listt.size() -1;
        }
    }

    /**
     * makes index go one up - travels ahead in history
     * if on the last item loops aroudn to the first item entered
     */
    public static void backToTheFuture(){
        index += 1;
        if (index > listt.size()-1){
            index = 0;
        }   
    }

    /**
     * Gets the expression at the current index.
     * @return
     */
    public static String retrieveHistory(){
        timeTravel();
        if (index < 0){

            return null;
        }
        else{
            return listt.get(index);
        }
    }

    /**
     * a switch statement that switches the value of timeTraveler
     * a variable responsible for checking if we actually are time travelling
     */
    public static void timeTravel(){
        timeTraveler = !(timeTraveler);
    }


    /**
     * a getter for the status of the timeTraveler, to see if we can retrieve history.
     * @return
     */
    public static boolean getTimeTravellingStatus(){
        return timeTraveler;
    }

    /**
     * deletes the latest item entered into the history list
     */
    public static void deleteHistory(){
        if (listt.size()>0){
            int i = listt.size()-1;
            listt.remove(i);
            index = listt.size()-1; 
        }
    }

}
