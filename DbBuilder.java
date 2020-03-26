import java.sql.*;

public class DbBuilder{

    public static void build(){

	String url = "jdbc:sqlite:ctrak.db";  
        
        // SQL statement for creating a new table  
        String c1 = "create table compounds (\n"  
	    + " compound_id text PRIMARY KEY\n"  
	    + ");";

	String c2 = "create table assignments (\n"  
	    + " well_id text PRIMARY KEY,\n"
	    + " compound_id text, \n"
	    + " foreign key(compound_id) references compounds(compound_id) \n"
	    + ");";
	
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(c1);
	    stmt.execute(c2);
        } catch (SQLException e) {
	    //	    if(e.getErrorCode() == 1) return;
	    System.out.println(e.getMessage());  
        }  
    }

    public static void main(String[] args){
	build();
    }
    
}
