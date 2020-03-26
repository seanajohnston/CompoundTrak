import java.util.*;

abstract class Action{

    DataManager dm;
    String cmd;
    
    public Action(DataManager dm, String cmd){
	this.dm = dm;
	this.cmd = cmd;
    }

    public String getCmd(){
	return cmd;
    }

    abstract void action();
}

class Help extends Action{

    public Help(DataManager dm){
	super(dm, "help");
    }

    public void action(){
	System.out.println("--Commands--     --Action--");
	System.out.println("  help          displays this menu");
	System.out.println("  register      a new compound ID");
	System.out.println("  assign        a compound ID to a well ID");
	System.out.println("  transfer      the compound in a well to"
			   + "another well(s)");
	System.out.println("  lookup        the compound ID contained"
			   + "in a well");
	System.out.println("  quit          exit from this program");
                                                                       
    }

}

class Register extends Action{

    public Register(DataManager dm){
	super(dm, "register");
    }
    
    public void action(){
	Scanner s = new Scanner(System.in);
	System.out.println("Enter Compound ID:");
	dm.register(s.next());
    }
}

class Assignment extends Action{

    public Assignment(DataManager dm){
	super(dm, "assign");
    }
    
    public void action(){
	Scanner s = new Scanner(System.in);
	String cid, wid;
	System.out.println("Compound ID:");
	cid = s.next();
	System.out.println("Well ID:");
	wid = s.next();
	dm.assign(cid, wid);
	System.out.println("Compund " + cid + " has been assigned to well "
			   + wid);
    }
}

class Transfer extends Action{

    public Transfer(DataManager dm){
	super(dm, "transfer");
    }
    
    public void action(){
	Scanner scanner = new Scanner(System.in);
	String wid;
	ArrayList<String> wids = new ArrayList<>();
	System.out.println("Well ID:");
	wid = scanner.next();
	System.out.print("Enter the number of new wells: ");
	int size = scanner.nextInt();
	System.out.print("Enter one or more space seperated well IDs:");
	for(int i = 0; i < size; i++){
	    wids.add(scanner.next());
	}
	dm.transfer(wid, wids);
	System.out.println("Confirmed");

    }
}

class Lookup extends Action{

    public Lookup(DataManager dm){
	super(dm, "lookup");
    }
    
    public void action(){
	Scanner s = new Scanner(System.in);
	String wid;
	System.out.println("Well ID:");
	wid = s.next();
	System.out.println(dm.lookup(wid));
    }
}

class Quit extends Action{

    public Quit(DataManager dm){
	super(dm, "quit");
    }

    public void action(){
	dm.close();
	System.exit(0);
    }
}
	

class ActionBuilder{

    public static HashMap<String, Action> getActions(){
	DataManager dm = new DataManager();
	ArrayList<Action> actions = new ArrayList<>();
	HashMap<String, Action> cmdMap = new HashMap<>();
	actions.add(new Register(dm));
	actions.add(new Lookup(dm));
	actions.add(new Transfer(dm));
	actions.add(new Assignment(dm));
	actions.add(new Help(dm));
	actions.add(new Quit(dm));
	for(Action action: actions){
	    cmdMap.put(action.getCmd(), action);
	}
	return cmdMap;
    }
}
