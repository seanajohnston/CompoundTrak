import java.io.*;
import java.util.*;

public class CompoundTrak {

    private HashMap<String, Action> cmdMap;
    
    public CompoundTrak() {
	cmdMap = ActionBuilder.getActions();
    }

    public void begin(){
	Scanner scanner = new Scanner(System.in);
	String input;
	Action action;
	while(true){
	    System.out.println("Welcom to CompoundTrak. Enter \"help\" for a"
			       + " list of commands.");
	    System.out.print("CTrak> ");
	    input = scanner.next();
	    action = cmdMap.get(input);
	    if(action == null){
		System.out.println("Invalid command: " + input);
		System.out.println("Enter \"help\" for a list of commands");
	    } else {
		action.action();
	    }
				  
	}
    }
    
    public static void main(String[] args){
	new CompoundTrak().begin();
    }

}
