package picasso.view;
import java.util.ArrayList;
import java.util.*;


public class History {
    
    private static List<String> list = new ArrayList<String>();
    private static int index = -1;
    private static boolean timeTraveler = false;

    public static void AddHistory(String x){
        list.add(x);
        index = list.size()-1;
    }

    public static List<String> getHistory(){
        return list;
    }
    public static int getIndex(){
        return index;
    }
    public static void timeMachine(){
        index -= 1;
        if (index < 0){
            index = list.size() -1;
        }
    }
    public static void backToTheFuture(){
        index += 1;
        if (index > list.size()-1){
            index = 0;
        }   
    }


    public static String retrieveHistory(){
        timeTravel();
        return list.get(index);
    }

    public static void timeTravel(){
        timeTraveler = !(timeTraveler);
    }

    public static boolean getTimeTravellingStatus(){
        return timeTraveler;
    }


}
