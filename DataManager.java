import java.sql.*;
import java.util.*;

public class DataManager{

    Connection c;

    public DataManager(){
	c = Connect.getConnection();
    }

    /*
     * Registers a new compound id in the db.
     *
     * @param id the id of the compound to be registered
     */

    public void register(String id){
	try{
	    String sql = "insert into compounds values(?)";
	    PreparedStatement stmt = c.prepareStatement(sql);
	    stmt.setString(1,id);
	    int i=stmt.executeUpdate();
	} catch(SQLException e){
	    System.out.println(e.getMessage());
	}
    }

    public void assign(String compoundID, String wellID){
	try{
	    String sql = "insert into assignments values(?,?)";
	    PreparedStatement stmt = c.prepareStatement(sql);
	    stmt.setString(1,wellID);
	    stmt.setString(2, compoundID);
	    int i=stmt.executeUpdate();
	} catch(SQLException e){
	    System.out.println(e.getMessage());
	}
    }

    public void transfer(String wellID, List<String> wellIDs){
	String compoundID = lookup(wellID);
        for(String wid: wellIDs){
	    assign(compoundID, wid);
	}
    }

    public String lookup(String well_id){
	String res = "";
	try{
	    String sql = "select compound_id from assignments where "
		+ "well_id = ?";
	    PreparedStatement stmt = c.prepareStatement(sql);
	    stmt.setString(1,well_id);
	    ResultSet rs = stmt.executeQuery();
	    res = rs.getString(1);
	} catch(SQLException e){
	    System.out.println(e.getMessage());
	}
	return res;
    }

    public void close(){
	try{
	    c.close();
	} catch(SQLException e){
	    System.out.println(e.getMessage());
	}
    }

    public void action(){}

    public static void main(String[] args){
    }
}
