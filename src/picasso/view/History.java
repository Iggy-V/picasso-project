package picasso.view;
import java.util.ArrayList;
import java.util.*;


public class History {
    
    private static List<String> listt = new ArrayList<String>();
    private static int index = -1;
    private static boolean timeTraveler = false;

    public static void AddHistory(String x){
        if(x!="" && x != null){
            listt.add(x);
            index = listt.size()-1;
        }
        
    }

    public static List<String> getHistory(){
        return listt;
    }
    public static int getIndex(){
        return index;
    }
    public static void timeMachine(){
        index -= 1;
        if (index < 0){
            index = listt.size() -1;
        }
    }
    public static void backToTheFuture(){
        index += 1;
        if (index > listt.size()-1){
            index = 0;
        }   
    }


    public static String retrieveHistory(){
        timeTravel();
        return listt.get(index);
    }

    public static void timeTravel(){
        timeTraveler = !(timeTraveler);
    }

    public static boolean getTimeTravellingStatus(){
        return timeTraveler;
    }

    public static void deleteHistory(){
        int i = listt.size()-1;
        listt.remove(i);
        index = listt.size()-1;
    }

}